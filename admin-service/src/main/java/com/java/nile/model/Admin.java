package com.java.nile.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.UUID;

@Document
public class Admin {
    @Id
    private UUID id;
    @Field
    private String userName;
    @Field
    private String password;
    @Field
    private String name;
    @Field
    private String address;
    @Field
    private String contactInformation;
    @Field
    private String email;
    @Field
    private String country;
    @Field
    private String role;
    @Field
    private Double balance;
    @Field
    private Boolean isActive;

    public Admin() {

    }

    public Admin(UUID id, String userName, String password, String name, String address, String contactInformation, String email, String country, String role, Double balance, Boolean isActive) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.address = address;
        this.contactInformation = contactInformation;
        this.email = email;
        this.country = country;
        this.role = role;
        this.balance = balance;
        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
