package com.example.command.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "tbl_alarm")
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column(name = "severity_id")
    private Integer severityId;
    @Column(name = "product_type_id")
    private Integer productTypeId;
    @Column(name = "readonly")
    private boolean readOnly;

}
