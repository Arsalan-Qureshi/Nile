package com.nile.orderservice.models;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends CouchbaseRepository<Order, UUID> {
    @Query("#{#n1ql.selectEntity} WHERE buyerId = $1 AND status = \"delivered\"")
    Iterable<Order> findByBuyerId(String buyerId);
}
