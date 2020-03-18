package com.ordersystem.controller;

import com.ordersystem.entity.Order;
import com.ordersystem.entity.OrderVO;
import com.ordersystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "order的端口为："+this.port;
    }

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
       this.orderRepository.save(order);
    }

    @GetMapping("/findAll/{index}/{limit}/{uid}")
    public OrderVO findAll(@PathVariable("index") Integer index, @PathVariable("limit")Integer limit,@PathVariable("uid") Integer uid){
        List<Order> data =  this.orderRepository.findAll(index,limit,uid);
        return new OrderVO(0,"",this.orderRepository.getCount(),data);
    }
}
