package com.mini.program.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
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
    /**mappedBy = "category" 表示Product类的category属性 维护两者关系，即由外键维护关系*/
    @OneToMany(targetEntity = Product.class,mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
