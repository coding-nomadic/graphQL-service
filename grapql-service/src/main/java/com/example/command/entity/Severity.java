package com.example.command.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "tbl_severity")
@Data
public class Severity implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @Column
    private Integer id;
    @Column
    private String severity;
    @Column(name="display_order")
    private Integer displayOrder;
}
