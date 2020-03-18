package com.ordersystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*用于layUI的table数据格式要求*/
@Data     /*可自动生成get和set方法*/
@AllArgsConstructor  /*生成带所有参数的构造方法*/
@NoArgsConstructor   /*不带参数的构造方法*/
public class MenuVO {
    private Integer code;
    private String msg;
    private Integer count;
    private List<Menu> data;
}
