package com.mini.program.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String detail;

    private String com_img;

    private String qualification_img;

    private Long phone;

    private Date open_time;

    private Date end_time;

    private String longitude;

    private String latitude;

    private String code;

}