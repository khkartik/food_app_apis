package com.example.demo.payload;

public class UploadFoodPayload {
    private String food_name;
    private Long food_price;

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Long getFood_price() {
        return food_price;
    }

    public void setFood_price(Long food_price) {
        this.food_price = food_price;
    }

    public String getFood_description() {
        return food_description;
    }

    public void setFood_description(String food_description) {
        this.food_description = food_description;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public String getFood_category() {
        return food_category;
    }

    public void setFood_category(String food_category) {
        this.food_category = food_category;
    }

    private String food_description;
    private String  food_type;
    private String food_category;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getFood_url() {
        return food_url;
    }

    public void setFood_url(String food_url) {
        this.food_url = food_url;
    }

    public String getFood_url_name() {
        return food_url_name;
    }

    public void setFood_url_name(String food_url_name) {
        this.food_url_name = food_url_name;
    }

    private Long user_id;
    private String food_url;
    private String food_url_name;
}
