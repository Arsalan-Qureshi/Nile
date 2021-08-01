package com.nile.warehouseservice;

import com.nile.warehouseservice.models.Warehouse;
import com.nile.warehouseservice.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping("/")
    public String welcome() {
        return "All's well!";
    }

    @RequestMapping("/warehouse")
    public Iterable<Warehouse> getAllWarehouseItems(@RequestHeader("Authorization") String token) {
        return warehouseService.getAllWarehouseItems(token);
    }

    @RequestMapping("/warehouse/{id}")
    public Optional<Warehouse> getWarehouseItem(@RequestHeader("Authorization") String token, @PathVariable("id") String id) {
        return warehouseService.getWarehouseItem(token, UUID.fromString(id));
    }

    @PostMapping("/warehouse")
    public void addWarehouseItem(@RequestHeader("Authorization") String token, @RequestBody Warehouse warehouse) {
        warehouseService.addWarehouseItem(token, warehouse);
    }

    @PutMapping("/warehouse")
    public void updateWarehouse(@RequestHeader("Authorization") String token, @RequestBody Warehouse warehouse) {
        warehouseService.updateWarehouseItem(token, warehouse);
    }

    @DeleteMapping("/warehouse/{id}")
    public void deleteOrder(@RequestHeader("Authorization") String token, @PathVariable("id") String id) {
        warehouseService.deleteWarehouseItem(token, UUID.fromString(id));
    }
}
