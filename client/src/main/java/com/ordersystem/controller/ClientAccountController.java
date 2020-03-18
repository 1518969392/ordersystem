package com.ordersystem.controller;

import com.ordersystem.entity.Admin;
import com.ordersystem.entity.User;
import com.ordersystem.feign.AccountFeign;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/clientAccount")
public class ClientAccountController {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, @RequestParam String type, HttpSession session){
       Object object =  this.accountFeign.login(username,password,type);
        LinkedHashMap<String,Object> hashMap = (LinkedHashMap)object;

       String result = null;
       if(object == null){
           result = "login";
       }else {
           switch (type){
               case "admin":
                   Admin admin = new Admin();
                   String idStr = hashMap.get("id")+"";
                   Integer id = Integer.parseInt(idStr);
                   admin.setId (id);
                   admin.setUsername((String)hashMap.get("username"));
                   session.setAttribute("admin",admin);
                   result = "index";
                   break;
               case "user":
                   User user = new User();
                   user.setId((Integer)hashMap.get("id"));
                   user.setNickname((String)hashMap.get("nickname"));
                   session.setAttribute("user",user);
                   result = "user_index";
                   break;
           }
       }
       return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
}
