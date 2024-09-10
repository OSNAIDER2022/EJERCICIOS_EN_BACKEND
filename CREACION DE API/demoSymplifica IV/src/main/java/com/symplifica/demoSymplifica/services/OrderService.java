package com.symplifica.demoSymplifica.services;

import com.symplifica.demoSymplifica.entity.Order;
import com.symplifica.demoSymplifica.errors.LocalNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    Order saveOrder(Order order);
//    Optional<Order> findById(Long id, Order order) throws LocalNotFoundException;
//    Optional<Order> findByName(String name, Order order) throws LocalNotFoundException;
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
    List<Order> listAllOrders()  throws LocalNotFoundException;
//    Optional<Order> findProductByIdOrderJPQL(Long id);
}
