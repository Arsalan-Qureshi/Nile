package com.nile.warehouseservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.UUID;

@Document
public class Warehouse {
    @Id
    private UUID warehouseId;
    @Field
    private String productId;
    @Field
    private int inStock;
    @Field
    private String country;
    @Field
    private String city;

    public Warehouse() {
    }

    public Warehouse(UUID warehouseId, String productId, int inStock, String country, String city) {
        this.warehouseId = warehouseId;
        this.productId = productId;
        this.inStock = inStock;
        this.country = country;
        this.city = city;
    }

    public UUID getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(UUID warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
