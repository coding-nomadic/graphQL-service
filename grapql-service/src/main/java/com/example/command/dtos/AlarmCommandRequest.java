package com.example.command.dtos;

import java.io.Serializable;

import lombok.Data;

@Data
public class AlarmCommandRequest implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String business;
    private String productType;
    private String name;
    private String severity;
    private boolean readonly;
}
