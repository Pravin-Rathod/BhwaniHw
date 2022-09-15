package com.example.bhawanihw.Model;

public class Category {

    private int id;
    private String categoryId;
    private String categoryName;
    private String categoryImageUrl;

    public Category(int id, String categoryId,String categoryName,String categoryImageUrl) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
        this.categoryImageUrl = categoryImageUrl;
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }
}
