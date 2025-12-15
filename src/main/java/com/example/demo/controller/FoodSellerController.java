package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FoodSellerModel;
import com.example.demo.payload.FoodSellerPayload;
import com.example.demo.services.FoodSellerServices;


@Validated
@RestController
@RequestMapping("/seller")
public class FoodSellerController {
    @Autowired
    public FoodSellerServices foodSellerServices;
    @PostMapping(value = "/add-seller",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public FoodSellerModel addSeller(@RequestBody FoodSellerPayload foodSellerPayload){
        FoodSellerModel foodSellerModel=new FoodSellerModel();
        foodSellerModel.setName(foodSellerPayload.getName());
        foodSellerModel.setPhone(foodSellerPayload.getPhone());
        foodSellerModel.setPassword(foodSellerPayload.getPassword());
        return foodSellerServices.addFoodSeller(foodSellerModel);
    }
}
