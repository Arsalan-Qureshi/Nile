package com.nile.sellerservice;

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
public class SellerService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getAllSellers(String token) {
        if (authenticateAdmin(token).matches("OK")) {
            List<Seller> sellers = sellerRepository.findAll();
            return sellers;
        } else {
            return null;
        }
    }

    // No authentication as user can search product through seller.
    public Optional<Seller> getSeller(UUID id) {
        return sellerRepository.findById(id);
    }

    public void addSeller(Seller seller) {
        // Initially seller status will be unapproved.
        if (seller.getStatus().matches("Approved")) {
            seller.setStatus("Unapproved");
        }
        sellerRepository.save(seller);
    }

    public void updateSellerBySeller(String token, Seller seller) {
        Optional<Seller> sellerObj = sellerRepository.findById(seller.getId());
        if (authenticateSeller(token).matches("OK")) {
            // Making sure that the user is unable to change previous status.
            if (sellerObj.isPresent()) {
                seller.setStatus(sellerObj.get().getStatus());
                sellerRepository.save(seller);
            }
        }
    }

    // Admin can set seller account to Approved, Unapproved, or Blocked.
    public void updateSellerByAdmin(String token, Seller seller) {
        if (authenticateAdmin(token).matches("OK")) {
            sellerRepository.save(seller);
        }
    }

    public void deleteSeller(String token, UUID id) {
        if (authenticateAdmin(token).matches("OK")) {
            sellerRepository.deleteById(id);
        }
    }

    public Optional<Seller> getSellerByUsername(String userName) {
        return sellerRepository.findByUserName(userName);
    }

    public String authenticateAdmin(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://admin-authentication-service/admin/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }

    public String authenticateSeller(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://seller-authentication-service/seller/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}
