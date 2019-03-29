package com.mini.program.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product{

    /**
     * 关联分类表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 面料名称
     */
    private Integer fabric;

    /**
     * 边框颜色：1.白灰2.香槟3.木纹4.喷涂
     */
    private Integer color;

    /**
     * 产品编号
     */
    private String product_no;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 开启方式
     */
    private String open_type;

    /**
     * 通用窗型
     */
    private String window_type;

    /**
     * 产品主图
     */
    private String img;
    /**
     * 详情图片，以 ","分隔
     * */

    private String imgs;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id")           //product表的 外键名称
    private Category category;
}
