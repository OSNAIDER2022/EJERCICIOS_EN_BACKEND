package com.symplifica.demoSymplifica.services;

import com.symplifica.demoSymplifica.entity.Order;
import com.symplifica.demoSymplifica.errors.LocalNotFoundException;
import com.symplifica.demoSymplifica.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
/*
    @Override
    public Optional<Order> findById(Long id, Order order){
        return orderRepository.findById(id);
    }
*/
//    @Override
//    public Optional<Order> findByName(String name, Order order) throws LocalNotFoundException{
//        return orderRepository.findByName(name,order);
//    }


    @Override
    public Order updateOrder(Long id, Order order) {
        Order ofTheOrder = orderRepository.findById(id).get();
        if (Objects.nonNull(order.getProductId()) && !"".equalsIgnoreCase(String.valueOf(order.getProductId()))) {
            ofTheOrder.setProductId(order.getProductId());
        }
        return orderRepository.save(ofTheOrder);
    }
    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> listAllOrders() throws LocalNotFoundException {
        Optional<List<Order>> order = Optional.of(orderRepository.findAll());
        if (!order.isPresent()) {
            throw new LocalNotFoundException("Orders are not Available.");
        }
        return order.get();
//    @Override
        //   public Optional<Order> findProductByIdOrderJPQL(Long id){
        //       return orderRepository.findById(id);
//    }
    }
}