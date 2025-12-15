package com.example.demo.controller;

import com.example.demo.model.UploadImageModel;

import com.example.demo.services.UploadImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Validated
@RestController
@RequestMapping("/uploads")
public class UploadImageController {
    @Autowired
    public UploadImageServices uploadImageServices;
     public UploadImageController(UploadImageServices uploadImageServices) {
        this.uploadImageServices = uploadImageServices;
    }
   @PostMapping("/upload-file")
    public ResponseEntity<UploadImageModel> upload(@RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(uploadImageServices.uploadImage(file));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
