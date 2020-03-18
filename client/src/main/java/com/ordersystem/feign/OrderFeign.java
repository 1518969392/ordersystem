package com.ordersystem.feign;

import com.ordersystem.entity.Order;
import com.ordersystem.entity.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "order")
public interface OrderFeign {

    @PostMapping("/order/save")
    public void save( Order order);

    @GetMapping("/order/findAll/{index}/{limit}/{uid}")
    public OrderVO findAll(@PathVariable("index")Integer index, @PathVariable("limit")Integer limit,@PathVariable("uid") Integer uid);
}
