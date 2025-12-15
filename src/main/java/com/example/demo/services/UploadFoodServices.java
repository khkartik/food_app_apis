package com.example.demo.services;

import com.example.demo.model.UploadFoodModel;
import com.example.demo.repo.UploadFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UploadFoodServices {
    @Autowired
    private UploadFoodRepo uploadFoodRepo;

    public UploadFoodModel addFood(UploadFoodModel uploadFoodModel){
        return uploadFoodRepo.save(uploadFoodModel);
    }
    public List<UploadFoodModel>allFood(){
        return (List<UploadFoodModel>) uploadFoodRepo.findAll();
    }
    public void deleteFood(Long id){
        uploadFoodRepo.deleteById(id);
    }
    public Optional<UploadFoodModel> getFoodById(Long id){
        return uploadFoodRepo.findById(id);
    }
}
