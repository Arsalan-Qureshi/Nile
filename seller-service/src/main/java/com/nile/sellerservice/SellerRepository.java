package com.nile.sellerservice;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SellerRepository extends CouchbaseRepository<Seller, UUID> {
    //    @Query("#{#n1ql.selectEntity} WHERE userName = $1")
    Optional<Seller> findByUserName(String userName);
}
