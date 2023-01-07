package org.example.repository;

import org.example.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {


}
