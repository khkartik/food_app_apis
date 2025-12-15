package com.example.demo.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "uploadImages")
public class UploadImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String food_url;

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public String getFood_url() {
        return food_url;
    }

    public void setFood_url(String food_url) {
        this.food_url = food_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @CurrentTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;
    @Column(nullable = false)
    private String food_name;
}
