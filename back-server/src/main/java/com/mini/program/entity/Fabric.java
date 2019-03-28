package com.mini.program.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "fabric")
public class Fabric {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Byte status;
}