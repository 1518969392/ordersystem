package com.ordersystem.controller;

import com.ordersystem.entity.User;
import com.ordersystem.entity.UserVO;
import com.ordersystem.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ClientUserController {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/redirect/{location}")
    public String index(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page")Integer page, @RequestParam("limit")Integer limit){
        Integer index = (page - 1) * limit;
        UserVO userVo = new UserVO();
        userVo.setCode(0);
        userVo.setCount(userFeign.getCount());
        userVo.setMsg("");
        List<User> data = userFeign.findAll(index,limit);
        userVo.setData(data);
        return userVo;
    }

    @PostMapping("/save")
    public String saveUser( User user){
        this.userFeign.saveUser(user);
        return "redirect:/user/redirect/user_add";

    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user){
        this.userFeign.updateUser(user);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id){
        this.userFeign.deleteUserById(id);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("/getCount")
    public int getCount(){
        return this.userFeign.getCount();
    }



}
