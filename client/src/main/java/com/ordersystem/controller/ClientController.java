package com.ordersystem.controller;

import com.ordersystem.entity.Menu;
import com.ordersystem.entity.MenuVO;
import com.ordersystem.entity.Type;
import com.ordersystem.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/clientMenu")
public class ClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/redirect/{location}")
    public String index(@PathVariable("location") String location){
        return location;
    }

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page")Integer page, @RequestParam("limit") Integer limit){
        int index = (page-1) * limit;
        MenuVO menuVO =  this.menuFeign.findAll(index,limit);
        return menuVO;
    };

    @GetMapping("/deleteById/{id}")
    public String deleteMenuById(@PathVariable("id") Long id){
        this.menuFeign.deleteMenuById(id);
        return "redirect:/clientMenu/redirect/index";
    }

    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_add");
        List<Type> types = this.menuFeign.findTypes();
        modelAndView.addObject("list",types);
        return modelAndView;
    }

    @PostMapping("/save")
    public String save( Menu menu){
        this.menuFeign.save(menu);
        return "redirect:/clientMenu/redirect/index";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");
        Menu menu = this.menuFeign.findById(id);
        modelAndView.addObject("menu",menu);
        modelAndView.addObject("list",this.menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Menu menu){
        this.menuFeign.update(menu);
        return "redirect:/clientMenu/redirect/index";
    }

}
