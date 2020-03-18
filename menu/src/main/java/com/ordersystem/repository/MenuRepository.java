package com.ordersystem.repository;

import com.ordersystem.entity.Menu;

import java.util.List;

public interface MenuRepository {
    public void save(Menu menu);
    public void deleteById(Integer id);
    public List<Menu> findAll(int index ,int limit); //分页查询
    public Menu findById(Integer id);
    public int getCount();
    public void update(Menu menu);
}
