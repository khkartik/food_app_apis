package com.example.demo.repo;

import com.example.demo.model.UploadFoodModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadFoodRepo extends JpaRepository<UploadFoodModel,Long> {

}
