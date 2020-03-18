package com.ordersystem.repository;

import com.ordersystem.entity.Type;

import java.util.List;

public interface TypeRepository {
    public Type findById(Long id);
    public List<Type> findAll();
}
