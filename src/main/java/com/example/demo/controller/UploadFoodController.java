package com.example.demo.controller;

import com.example.demo.model.UploadFoodModel;
import com.example.demo.payload.UploadFoodPayload;
import com.example.demo.services.UploadFoodServices;
import com.example.demo.services.UploadImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequestMapping("/food")
public class UploadFoodController {
    @Autowired
    public UploadFoodServices uploadFoodServices;
    @Autowired
    public UploadImageServices uploadImageServices;
    @PostMapping(value="add-food",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public UploadFoodModel addFood(@RequestBody UploadFoodPayload uploadFoodPayload){
        UploadFoodModel uploadFoodModel=new UploadFoodModel();
        // UploadImageModel uploadImageModel=new UploadImageModel();
        uploadFoodModel.setFood_name(uploadFoodPayload.getFood_name());
        uploadFoodModel.setFood_category(uploadFoodPayload.getFood_category());
        uploadFoodModel.setFood_description(uploadFoodPayload.getFood_description());
        uploadFoodModel.setFood_price(uploadFoodPayload.getFood_price());
        uploadFoodModel.setFood_type(uploadFoodPayload.getFood_type());
        uploadFoodModel.setUser_id(uploadFoodPayload.getUser_id());
        uploadFoodModel.setFood_url(uploadFoodPayload.getFood_url());
        return uploadFoodServices.addFood(uploadFoodModel);
    }
    @GetMapping(value="all-food",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UploadFoodModel> listFood(){
        return uploadFoodServices.allFood();
    }
    @DeleteMapping("/delete-food/{id}")
public void deleteFood(@PathVariable Long id) {
    uploadFoodServices.deleteFood(id);
}

    @GetMapping(value = "/get-foodbyid{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UploadFoodModel getFoodById(@PathVariable Long id) {
        return uploadFoodServices.getFoodById(id)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
    }
}
