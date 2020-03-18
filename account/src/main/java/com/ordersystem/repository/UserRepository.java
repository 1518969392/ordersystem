package com.ordersystem.repository;

import com.ordersystem.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
