package com.ordersystem.feign;

import com.ordersystem.entity.Menu;
import com.ordersystem.entity.MenuVO;
import com.ordersystem.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index")Integer index, @PathVariable("limit") Integer limit);

    @GetMapping("/menu/deleteById/{id}")
    public void deleteMenuById(@PathVariable("id") Long id);

    /*查询类型*/
    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    public void save( Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") Integer id);

    @PostMapping("/menu/update")
    public void update(Menu menu);

    }
