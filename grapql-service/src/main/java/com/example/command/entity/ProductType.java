package com.example.command.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "tbl_product_type")
public class ProductType {

    @Id
    @Column
    private Integer id;
    @Column
    private String name;

}
