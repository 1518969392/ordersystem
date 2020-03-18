package com.ordersystem.controller;

import com.ordersystem.entity.Menu;
import com.ordersystem.entity.MenuVO;
import com.ordersystem.entity.Type;
import com.ordersystem.repository.MenuRepository;
import com.ordersystem.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private TypeRepository typeRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return "menu的端口为："+this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") Integer index, @PathVariable("limit") Integer limit){
        List<Menu> data =  this.menuRepository.findAll(index,limit);
        return new MenuVO(0,"",this.menuRepository.getCount(),data);
    }

    @GetMapping("/deleteById/{id}")
    public void deleteMenuById(@PathVariable("id") Integer id){
        this.menuRepository.deleteById(id);
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return this.typeRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        this.menuRepository.save(menu);
    };

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") Integer id){
        return this.menuRepository.findById(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody Menu menu){
        this.menuRepository.update(menu);
    }


}
