package com.example.personalassignment2;


public class GoodsModel {
    String title;
    int image_path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage_path() {
        return image_path;
    }

    public void setImage_path(int image_path) {
        this.image_path = image_path;
    }

    public GoodsModel(String title, int image_path) {
        this.title = title;
        this.image_path = image_path;
    }
}