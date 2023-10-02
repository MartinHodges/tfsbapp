package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "do_laters")
@Getter
@Setter
public class DoLaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "app_generator")
    @SequenceGenerator(name = "app_generator", sequenceName = "app_seq", initialValue = 1, allocationSize=10)
    private Long id;

    private String name;
}
