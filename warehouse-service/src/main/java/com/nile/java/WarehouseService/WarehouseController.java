package com.nile.java.WarehouseService;

import com.nile.java.WarehouseService.models.Warehouse;
import com.nile.java.WarehouseService.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping("/warehouse")
    public Iterable<Warehouse> getAllWarehouseItems(@RequestHeader("Authorization") String token) {
        return warehouseService.getAllWarehouseItems(token);
    }

    @RequestMapping("/warehouse/{id}")
    public Optional<Warehouse> getWarehouseItem(@RequestHeader("Authorization") String token, @PathVariable("id") UUID id) {
        return warehouseService.getWarehouseItem(token, id);
    }

    @PostMapping("/warehouse")
    public void addWarehouseItem(@RequestHeader("Authorization") String token, @RequestBody Warehouse warehouse) {
        warehouseService.addWarehouseItem(token, warehouse);
    }

    @PutMapping("/warehouse")
    public void updateWarehouseItem(@RequestHeader("Authorization") String token, @RequestBody Warehouse warehouse) {
        warehouseService.updateWarehouseItem(token, warehouse);

    }

    @DeleteMapping("/warehouse/{id}")
    public void deleteWarehouse(@RequestHeader("Authorization") String token, @PathVariable("id") UUID id) {
        warehouseService.deleteWarehouseItem(token, id);
    }
}
