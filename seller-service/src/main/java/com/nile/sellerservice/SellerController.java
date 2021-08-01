package com.nile.sellerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @RequestMapping("/sellers")
    public Iterable<Seller> getAllSellers(@RequestHeader("Authorization") String token) {
        return sellerService.getAllSellers(token);
    }

    @RequestMapping("/sellers/{id}")
    public Optional<Seller> getSeller(@PathVariable("id") String id) {
        return sellerService.getSeller(UUID.fromString(id));
    }

    @RequestMapping("/sellers/search/{userName}")
    public Optional<Seller> getSellerByUsername(@PathVariable("userName") String userName) {
        return sellerService.getSellerByUsername(userName);
    }

    @PostMapping("/sellers")
    public void addSeller(@RequestBody Seller seller) {
        sellerService.addSeller(seller);
    }

    @PutMapping("/sellers/user")
    public void updateSellerBySeller(@RequestHeader("Authorization") String token, @RequestBody Seller seller) {
        sellerService.updateSellerBySeller(token, seller);
    }

    @PutMapping("/sellers/admin")
    public void updateSellerByAdmin(@RequestHeader("Authorization") String token, @RequestBody Seller seller) {
        sellerService.updateSellerByAdmin(token, seller);
    }

    @DeleteMapping("/sellers/{id}")
    public void deleteSeller(@RequestHeader("Authorization") String token, @PathVariable("id") String id) {
        sellerService.deleteSeller(token, UUID.fromString(id));
    }
}
