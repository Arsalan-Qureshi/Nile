package com.java.nile.repository;

import com.java.nile.model.Admin;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface AdminRepository extends CouchbaseRepository<Admin, UUID> {
    @Query("#{#n1ql.selectEntity} WHERE userName = $1")
    Optional<Admin> findByUserName(String userName);
}
