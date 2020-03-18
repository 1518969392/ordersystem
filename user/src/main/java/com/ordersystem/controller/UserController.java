package com.ordersystem.controller;

import com.ordersystem.entity.User;
import com.ordersystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
   @Autowired
    private UserRepository userRepository;

   @GetMapping("/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index")Integer index,@PathVariable("limit")Integer limit){
       return this.userRepository.findAll(index,limit);
   }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id")Integer id){
        return this.userRepository.findById(id);
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody User user){
        user.setRegisterdate(new Date());
        this.userRepository.saveUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user){
       this.userRepository.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Integer id){
        this.userRepository.deleteById(id);
    }

    @GetMapping("/getCount")
    public int getCount(){
        return this.userRepository.getCount();
    }



}
