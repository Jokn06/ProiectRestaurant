package org.example.repository;

import org.example.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByOrderByDateStartDesc();

//    @Query("select t from Order t where t.dateStart BETWEEN : startDate AND :endDate")
//    List<Order> findByOrderDateBetween(
//            @Param("startDate") LocalDateTime dateFrom,
//            @Param("endDate") LocalDateTime dateTo);


}
