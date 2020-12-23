package com.java.nile.services;

import com.java.nile.model.Admin;
import com.java.nile.repository.AdminRepository;
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
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins(String token) {
        if (authenticateAdmin(token).matches("OK")) {
            List<Admin> admins = adminRepository.findAll();
            return admins;
        } else {
            return null;
        }
    }

    public Optional<Admin> getAdminByUsername(String token, String userName) {
        if (authenticateAdmin(token).matches("OK")) {
            return adminRepository.findByUserName(userName);
        } else {
            return null;
        }
    }

    public Optional<Admin> getAdmin(String token, UUID id) {
        if (authenticateAdmin(token).matches("OK")) {
            return adminRepository.findById(id);
        } else {
            return null;
        }

    }

    public void addAdmin(String token, Admin admin) {
        if (authenticateAdmin(token).matches("OK")) {
            adminRepository.save(admin);
        }
    }

    public void updateAdmin(String token, UUID id, Admin admin) {
        if (authenticateAdmin(token).matches("OK")) {
            adminRepository.save(admin);
        }
    }

    public void deleteAdmin(String token, UUID id) {
        if (authenticateAdmin(token).matches("OK")) {
            adminRepository.deleteById(id);
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
