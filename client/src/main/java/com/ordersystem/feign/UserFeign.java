package com.ordersystem.feign;

import com.ordersystem.entity.User;
import lombok.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {
    @GetMapping("/user/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index")Integer index, @PathVariable("limit")Integer limit);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id")Integer id);

    @PostMapping("/user/save")
    public void saveUser(User user);

    @PutMapping("/user/update")
    public void updateUser(User user);

    @DeleteMapping("/user/delete/{id}")
    public void deleteUserById(@PathVariable("id") Integer id);

    @GetMapping("/user/getCount")
    public int getCount();

}
