package com.ordersystem.controller;

import com.ordersystem.entity.Menu;
import com.ordersystem.entity.Order;
import com.ordersystem.entity.OrderVO;
import com.ordersystem.entity.User;
import com.ordersystem.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/clientOrder")
public class ClientOrderController {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/redirect/{location}")
    public String index(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid")Integer mid, HttpSession session){
        Order order = new Order();
        User user = (User) session.getAttribute("user");
        order.setUser(user);
        Menu menu = new Menu();
        menu.setId(mid);
        order.setMenu(menu);
        this.orderFeign.save(order);
        return "user_index";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public OrderVO findAll(@RequestParam("page")Integer page, @RequestParam("limit") Integer limit,HttpSession session){
        User user = (User) session.getAttribute("user");
        Integer uid = user.getId();
        int index = (page-1) * limit;
        OrderVO orderVO = this.orderFeign.findAll(index,limit,uid);
        return orderVO;
    }
}
