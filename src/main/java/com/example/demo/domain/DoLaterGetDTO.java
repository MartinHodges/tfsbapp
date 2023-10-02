package com.example.demo.domain;

import lombok.Data;

@Data
public class DoLaterGetDTO {

    private Long id;
    private String name;

    public DoLaterGetDTO(DoLaterEntity app) {
        this.id = app.getId();
        this.name = app.getName();
    }
}
