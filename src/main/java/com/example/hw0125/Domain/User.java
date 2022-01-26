package com.example.hw0125.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
}
