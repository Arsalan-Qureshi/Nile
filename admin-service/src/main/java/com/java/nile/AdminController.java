package com.java.nile;

import com.java.nile.model.Admin;
import com.java.nile.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/admins")
    public Iterable<Admin> getAllAdmins(@RequestHeader("Authorization") String token) {
        return adminService.getAllAdmins(token);
    }

    @RequestMapping("/buyers/search/{userName}")
    public Optional<Admin> getAdminByUsername(@RequestHeader("Authorization") String token, @PathVariable("userName") String userName) {
        return adminService.getAdminByUsername(token, userName);
    }

    @RequestMapping("/admins/{id}")
    public Optional<Admin> getAdmin(@RequestHeader("Authorization") String token, @PathVariable("id") UUID id) {
        return adminService.getAdmin(token, id);
    }

    @PostMapping("/admins")
    public void addAdmin(@RequestHeader("Authorization") String token, @RequestBody Admin admin) {
        adminService.addAdmin(token, admin);

    }

    @PutMapping("/admins/{id}")
    public void updateAdmin(@RequestHeader("Authorization") String token, @PathVariable("id") UUID id, @RequestBody Admin admin) {
        adminService.updateAdmin(token, id, admin);
    }

    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@RequestHeader("Authorization") String token, @PathVariable("id") UUID id) {
        adminService.deleteAdmin(token, id);
    }
}
