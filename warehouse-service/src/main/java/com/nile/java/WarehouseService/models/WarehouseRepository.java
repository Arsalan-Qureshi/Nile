package com.nile.java.WarehouseService.models;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WarehouseRepository extends CouchbaseRepository<Warehouse, UUID> {
}
