package com.nile.java.WarehouseService.services;

import com.nile.java.WarehouseService.models.Warehouse;
import com.nile.java.WarehouseService.models.WarehouseRepository;
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
    private RestTemplate restTemplate;

    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Warehouse> getAllWarehouseItems(String token) {
        if (authenticateAdmin(token).matches("OK")) {
            List<Warehouse> warehouses = warehouseRepository.findAll();
            return warehouses;
        } else {
            return null;
        }
    }

    public Optional<Warehouse> getWarehouseItem(String token, UUID id) {
        if (authenticateAdmin(token).matches("OK")) {
            return warehouseRepository.findById(id);
        } else {
            return null;

        }
    }

    public void addWarehouseItem(String token, Warehouse warehouse) {
        if (authenticateAdmin(token).matches("OK")) {
            warehouseRepository.save(warehouse);
        }
    }

    public void updateWarehouseItem(String token, Warehouse warehouse) {
        if (authenticateAdmin(token).matches("OK")) {
            warehouseRepository.save(warehouse);
        }
    }

    public void deleteWarehouseItem(String token, UUID id) {
        if (authenticateAdmin(token).matches("OK")) {
            warehouseRepository.deleteById(id);
        }
    }

    public String authenticateAdmin(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://admin-authentication-service/admin/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}
