package com.nile.warehouseservice.services;

import com.nile.warehouseservice.models.Warehouse;
import com.nile.warehouseservice.models.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> getAllWarehouseItems(String token) {
        // Add Admin authentication here.
        if (authenticate(token).matches("OK")) {
            List<Warehouse> items = warehouseRepository.findAll();
            return items;
        } else {
            return null;
        }
    }

    public Optional<Warehouse> getWarehouseItem(String token, UUID id) {
        if (authenticate(token).matches("OK")) {
            return warehouseRepository.findById(id);
        } else {
            return null;
        }
    }

    public void addWarehouseItem(String token, Warehouse warehouse) {
        if (authenticate(token).matches("OK")) {
            warehouseRepository.save(warehouse);
        }
    }

    public void updateWarehouseItem(String token, Warehouse warehouse) {
        if (authenticate(token).matches("OK")) {
            warehouseRepository.save(warehouse);
        }
    }

    public void deleteWarehouseItem(String token, UUID id) {
        if (authenticate(token).matches("OK")) {
            warehouseRepository.deleteById(id);
        }
    }

    public String authenticate(String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8083/admins/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}
