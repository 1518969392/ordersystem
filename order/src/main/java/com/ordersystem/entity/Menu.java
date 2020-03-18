package com.ordersystem.entity;

import lombok.Data;

@Data
public class Menu {
    private Integer id;

    private String name;

    private Double price;

    private String flavor;

    private Type type;
}
