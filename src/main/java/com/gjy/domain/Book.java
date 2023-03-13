package com.gjy.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

}
