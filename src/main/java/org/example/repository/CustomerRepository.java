package org.example.repository;

import org.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {

@Query("SELECT u FROM Customer u WHERE u.name = ?1")
    Customer findByName(String name);

}
