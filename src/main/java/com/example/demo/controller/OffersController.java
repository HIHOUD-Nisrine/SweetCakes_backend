package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.model.Offers;
import com.example.demo.repository.OffersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class OffersController {

    @Autowired
    private OffersRepository offersRepository;

    private static String imageDirectory = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";

    // get all demandd
    @GetMapping("/offers")
    public List<Offers> getAllOffers() {
        return offersRepository.findAll();
    }

    // add offer to database
    @PostMapping(value = "/offers/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Offers> addOffer(@RequestParam("image") MultipartFile file,
            @RequestParam("prix_initial") int prix_initial, @RequestParam("prix_final") int prix_final,
            @RequestParam("description") String description,
            @RequestParam("date_debut") String date_debut, @RequestParam("date_fin") String date_fin)
            throws ParseException {

        // System.out.println("file : " + file + " prix_initial : " + prix_initial +
        // " prix_final : " + prix_final + " description : " + description +
        // " date_debut : " + date_debut
        // + " date_fin : " + date_fin);

        // image traitement
        // 1- extract extention
        int index = file.getOriginalFilename().lastIndexOf('.');
        String ext = file.getOriginalFilename().substring(index + 1);

        // 2- create unique name
        int randomNumber = (int) Math.floor(Math.random() * 1000);
        String newImageName = java.util.Calendar.getInstance().getTime().getTime() + "-" + randomNumber + "." + ext;

        // 3- store name to data base and store file in right folder
        makeDirectoryIfNotExist(imageDirectory);
        Path fileNamePath = Paths.get(imageDirectory, newImageName);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Offers offer = new Offers(newImageName, description, formatter.parse(date_debut), formatter.parse(date_fin),
                prix_initial, prix_final);

        try {
            Files.write(fileNamePath, file.getBytes());
            offersRepository.save(offer);
            return ResponseEntity.ok(offer);
        } catch (IOException ex) {
            System.out.println(">>>>>>>>>>>>>> image error :  " + ex);
            return ResponseEntity.ok(offer);
        }
    }

    private void makeDirectoryIfNotExist(String imageDirectory) {
        File directory = new File(imageDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    @DeleteMapping("offers/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteOffer(@PathVariable long id) {
        offersRepository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "offers/update/{id}")
    public ResponseEntity<Offers> updateOffer(@PathVariable long id,
            @RequestParam("prix_initial") int prix_initial, @RequestParam("prix_final") int prix_final,
            @RequestParam("description") String description,
            @RequestParam("date_debut") String date_debut, @RequestParam("date_fin") String date_fin)
            throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Offers myOffer = offersRepository.findById(id).orElseThrow();

        myOffer.setDescription(description);
        myOffer.setPrix_initial(prix_initial);
        myOffer.setPrix_final(prix_final);
        myOffer.setDate_debut(formatter.parse(date_debut));
        myOffer.setDate_fin(formatter.parse(date_fin));

        System.out.println(myOffer);
        Offers offerUpdated = offersRepository.save(myOffer);

        return ResponseEntity.ok(offerUpdated);
    }

    // update image post
    @PutMapping(value = "offer/{id}/update/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Offers> updatePostImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) {

        Offers myOffer = offersRepository.findById(id).orElseThrow();

        // image traitement
        // 1- extract extention
        int index = file.getOriginalFilename().lastIndexOf('.');
        String ext = file.getOriginalFilename().substring(index + 1);

        // 2- create unique name
        int randomNumber = (int) Math.floor(Math.random() * 1000);
        String newImageName = java.util.Calendar.getInstance().getTime().getTime() + "-" + randomNumber + "." + ext;

        // 3- store name to data base and store file in right folder
        makeDirectoryIfNotExist(imageDirectory);
        Path fileNamePath = Paths.get(imageDirectory, newImageName);

        myOffer.setImage(newImageName);

        try {
            Files.write(fileNamePath, file.getBytes());
            offersRepository.save(myOffer);
            return ResponseEntity.ok(myOffer);
        } catch (IOException ex) {
            System.out.println(">>>>>>>>>>>>>> image error :  " + ex);
            return ResponseEntity.ok(myOffer);
        }
    }
}
