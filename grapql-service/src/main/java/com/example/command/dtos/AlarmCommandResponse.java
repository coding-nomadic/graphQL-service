package com.example.command.dtos;

import lombok.Data;

import java.io.Serializable;

/**
 * Pojo
 */
@Data
public class AlarmCommandResponse implements Serializable {

    private int id;
    private String business;
    private String productType;
    private String name;
    private String severity;
    private boolean readonly;
}
