package com.mini.program.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    /**
     * 分类 图
     * */
    private String img;

    private Byte status;
    @OneToMany
    private List<Product>  p_id;
}
