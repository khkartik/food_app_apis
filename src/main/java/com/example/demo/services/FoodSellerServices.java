package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FoodSellerModel;
import com.example.demo.repo.FoodSellerRepo;

@Service
public class FoodSellerServices {
    @Autowired
    public FoodSellerRepo foodSellerRepo;

    public FoodSellerModel addFoodSeller(FoodSellerModel foodSellerModel) {
        return foodSellerRepo.save(foodSellerModel);
    }

    public List<FoodSellerModel> listFoodSeller() {
        return (List<FoodSellerModel>) foodSellerRepo.findAll();
    }

    public Optional<FoodSellerModel> getSellerById(Long id) {
        return foodSellerRepo.findById(id);
    }

    public void deleteSellerId(Long id) {
        foodSellerRepo.deleteById(id);
    }

    public FoodSellerModel loginSeller(String phone, String password) {

        FoodSellerModel seller = foodSellerRepo.findByPhone(phone)
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        if (!seller.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return seller;
    }

    public boolean updateSeller(String phone, String password) {

        Optional<FoodSellerModel> seller = foodSellerRepo.findByPhone(phone);

        if (seller.isEmpty()) {
            return false;
        }

        FoodSellerModel sellerModel = seller.get();

        sellerModel.setPassword(password);
        foodSellerRepo.save(sellerModel);

        return true;
    }

}
