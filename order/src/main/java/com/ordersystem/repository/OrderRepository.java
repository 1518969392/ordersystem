package com.ordersystem.repository;

import com.ordersystem.entity.Order;

import java.util.List;

public interface OrderRepository {
    public void save(Order order);
    public void deleteById(Integer id);
    public List<Order> findAll(Integer index, Integer limit,Integer uid);
    public int getCount();
    public Order findById(Integer id);
//    public void update(Order order);
}
