package com.nile.productservice.services;

import com.nile.productservice.models.Product;
import com.nile.productservice.models.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    public String getProductsByName(String searchQuery) {
        // Needs no authentication
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic YWRtaW46MTIzNDU2");

        String body = "{\n" +
                "  \"explain\": false,\n" +
                "  \"fields\": [\n" +
                "    \"*\"\n" +
                "  ],\n" +
                "  \"highlight\": {},\n" +
                "  \"query\": {\n" +
                "    \"query\": \" " + searchQuery + "\"\n" +
                "  }\n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8094/api/index/product-search-index/query", HttpMethod.POST, entity, String.class);
        return responseEntity.getBody();
    }

    public Optional<Product> getProduct(String id) {
        // Needs no authentication
        return productRepository.findById(id);
    }

    // Available for all.
    public Optional<Product> getProductsForSeller(String id) {
        return productRepository.findBySellerId(id);
    }

    public void addProduct(String token, Product product) {
        if (authenticateSeller(token).matches("OK") && getSellerId(token).matches(product.getSellerId())) {
            productRepository.save(product);
        }
    }

    public void updateProduct(String token, Product product) {
        if (authenticateSeller(token).matches("OK")) {
            productRepository.save(product);
        }
    }

    public void deleteProduct(String token, String id) {
        if (authenticateSeller(token).matches("OK")) {
            productRepository.deleteById(id);
        }
    }

    public String authenticateSeller(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://seller-authentication-service/seller/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }

    public String getSellerId(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://seller-authentication-service/seller/userName", HttpMethod.GET, entity, String.class);
        String userName = responseEntity.getBody();
        if (userName != null) {
            ResponseEntity<Object[]> responseEntityObject = restTemplate.exchange("http://seller-service/sellers/search/" + userName, HttpMethod.GET, entity, Object[].class);
            Object[] objects = responseEntityObject.getBody();
            // Confirm seller status
            if (objects[12].toString().matches("Approved")) {
                return objects[0].toString();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
