package com.mini.program.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product")
public class Product{

    /**
     * 关联分类表id
     */
    private Integer id;

    /**
     * 面料名称
     */
    private Integer fabric_id;

    /**
     * 边框颜色：1.白灰2.香槟3.木纹4.喷涂
     */
    private Integer color_id;

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
     * 详情图片
     * */
    private List<String> imgs;
}
