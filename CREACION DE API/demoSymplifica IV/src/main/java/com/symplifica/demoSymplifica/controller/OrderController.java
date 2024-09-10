package com.symplifica.demoSymplifica.controller;

import com.symplifica.demoSymplifica.entity.Order;
import com.symplifica.demoSymplifica.errors.LocalNotFoundException;
import com.symplifica.demoSymplifica.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("saveorder")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }
/*
    @GetMapping("findbyorderid/{id}")
    public Optional<Order> findById(@PathVariable Long id, @RequestBody Order order) throws LocalNotFoundException{
        return  orderService.findById(id,order);
    }
*/
    @PutMapping("updateorder/{id}")
    public Order updateOrder(@PathVariable Long id, Order order){
        return orderService.updateOrder(id,order);
    }

    @DeleteMapping("deleteorder/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "Ser ha eliminado la orden de id: " + id;
    }

    @GetMapping("findallorders")
    public List<Order> findAllorders() throws LocalNotFoundException {
        return orderService.listAllOrders();
    }
//    @GetMapping("findProductByIdOrder/{id}")
//    Optional<Order> findProductByIdOrder(@PathVariable Long id){
//        return orderService.findProductByIdOrderJPQL(id);
//    }
}
