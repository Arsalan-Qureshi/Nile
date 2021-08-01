package com.nile.warehouseservice.models;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WarehouseRepository extends CouchbaseRepository<Warehouse, UUID> {
}
