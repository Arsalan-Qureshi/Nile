package com.nile.productservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Product {
    @Id
    private String productId;
    @Field
    private String sellerId;
    @Field
    private String name;
    @Field
    private String brand;
    @Field
    private String category;
    @Field
    private Double price;
    @Field
    private String sku;
    @Field
    private String description;
    @Field
    private String currency;
    @Field
    private String imgUrl;
    @Field
    private String type;

    public Product() {
    }

    public Product(String productId, String sellerId, String name, String brand, String category, Double price, String sku, String description, String currency, String imgUrl, String type) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.sku = sku;
        this.description = description;
        this.currency = currency;
        this.imgUrl = imgUrl;
        this.type = type;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
