package com.example.demo.services;

import com.example.demo.config.FileStorageProperties;
import com.example.demo.model.UploadImageModel;
import com.example.demo.repo.UploadImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class UploadImageServices {
    @Autowired
    private UploadImageRepo uploadImageRepo;

    @Autowired
    private FileStorageProperties fileStorageProperties;

    public UploadImageModel uploadImage(MultipartFile file) throws Exception {

        // Read uploadDir from application.properties
        String uploadDir = fileStorageProperties.getUploadDir();

        // Create directory if not exists
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Fix: use correct file name method
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        // Create URL
        String url = "/uploads/" + fileName;

        // Save in DB
        UploadImageModel entity = new UploadImageModel();
        entity.setFood_name(fileName);
        entity.setFood_url(url);

        return uploadImageRepo.save(entity);
    }
}
