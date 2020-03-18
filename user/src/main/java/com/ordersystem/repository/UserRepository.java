package com.ordersystem.repository;

import com.ordersystem.entity.User;

import java.util.List;

public interface UserRepository {
    public void saveUser(User user);
    public void deleteById(Integer id);
    public List<User> findAll(Integer index,Integer limit);
    public int getCount();
    public User findById(Integer id);
    public void updateUser(User user);
}
