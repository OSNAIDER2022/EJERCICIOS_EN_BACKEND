package com.symplifica.demoSymplifica.repository;

import com.symplifica.demoSymplifica.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
