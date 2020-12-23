package com.nile.orderservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.Date;
import java.util.UUID;

@Document
public class Order {
    @Id
    private UUID orderId;
    @Field
    private String buyerId;
    @Field
    private String productId;
    @Field
    private String warehouseId;
    @Field
    private String status;
    @Field
    private String datePlaced;
    @Field
    private String dateDue;

    public Order() {
    }

    public Order(UUID orderId, String buyerId, String productId, String warehouseId, String status, String datePlaced, String dateDue) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.productId = productId;
        this.warehouseId = warehouseId;
        this.status = status;
        this.datePlaced = datePlaced;
        this.dateDue = dateDue;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(String datePlaced) {
        this.datePlaced = datePlaced;
    }

    public String getDateDue() {
        return dateDue;
    }

    public void setDateDue(String dateDue) {
        this.dateDue = dateDue;
    }
}
