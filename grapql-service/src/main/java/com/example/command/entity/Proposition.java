package com.example.command.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity(name = "tbl_proposition")
public class Proposition {
    @Id
    @Column
    private Integer id;
    @Column
    private String organisation;
    @Column
    private String proposition;
}
