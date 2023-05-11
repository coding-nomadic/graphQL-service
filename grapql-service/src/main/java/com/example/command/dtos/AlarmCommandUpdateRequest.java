package com.example.command.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class AlarmCommandUpdateRequest implements Serializable {

    private String name;
    private String severity;
}
