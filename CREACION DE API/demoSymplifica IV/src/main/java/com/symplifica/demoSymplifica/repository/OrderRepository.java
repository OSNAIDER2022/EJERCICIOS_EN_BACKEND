package com.symplifica.demoSymplifica.repository;

import com.symplifica.demoSymplifica.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
//Optional<Order> findById(Long id, Order order);
//  Optional<Order> findByName(String name, Order order);
//    @Query("SELECT * FROM Orders o WHERE product_id= : id;")
//    Optional<Order> findProductByIdOrderJPQL(Long id);


}
