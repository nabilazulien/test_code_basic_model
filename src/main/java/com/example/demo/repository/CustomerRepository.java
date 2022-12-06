package com.example.demo.repository;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findById (UUID id);
    Optional<Customer> findByFullName(String fullName);
    Optional<Customer> findByDob(String dob);
    Optional<Customer> findByEmail(String email);
}
