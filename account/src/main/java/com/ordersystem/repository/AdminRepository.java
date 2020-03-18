package com.ordersystem.repository;

import com.ordersystem.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);
}
