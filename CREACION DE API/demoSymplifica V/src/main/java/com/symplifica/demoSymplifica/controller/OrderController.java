package com.symplifica.demoSymplifica.controller;

import com.symplifica.demoSymplifica.entity.Order;
import com.symplifica.demoSymplifica.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("order/saveorder")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @PutMapping("order/updateorder/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order){
        return orderService.updateOrder(id,order);
    }

    @DeleteMapping("order/deleteorder/{id}")
    public String deleteOrderById(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "Ser ha eliminado la orden de id: " + id;
    }
    @GetMapping("order/findorderbyid/{id}")
    public Order findOrderById(@PathVariable Long id){
        return orderService.findOrderById(id);
    }

    @GetMapping("order/findallorders")
    public List<Order> findAllorders(){
        return orderService.listAllOrders();
    }
}
