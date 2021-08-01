package com.nile.productservice;

import com.nile.productservice.models.Product;
import com.nile.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductService productService;

    @GetMapping("/products/search")
    public String getProducts(@RequestParam(name = "searchQuery") String searchQuery) {
        return productService.getProductsByName(searchQuery);
    }

    @RequestMapping("/products/{id}")
    public Optional<Product> getProduct(@PathVariable("id") String id) {
        return productService.getProduct(id);
    }

    @RequestMapping("/products/seller/{id}")
    public Optional<Product> getProductsForSeller(@RequestHeader("Authorization") String token, @PathVariable("id") String id) {
        return productService.getProductsForSeller(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestHeader("Authorization") String token, @RequestBody Product product) {
        productService.addProduct(token, product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestHeader("Authorization") String token, @RequestBody Product product) {
        productService.updateProduct(token, product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@RequestHeader("Authorization") String token, @PathVariable("id") String id) {
        productService.deleteProduct(token, id);
    }
}