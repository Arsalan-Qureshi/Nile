package com.nile.productservice.models;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends CouchbaseRepository<Product, String> {
    @Query("#{#n1ql.selectEntity} WHERE sellerId = $1")
    Optional<Product> findBySellerId(String sellerId);
}
