package com.mini.program.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mini.program.enums.Gender;
import lombok.Data;

@Data
@TableName(value = "comsumer")
public class Consumer {
    @TableId
    private Long id;
    private String username;
    private String wechatOpenid;
    private Long phone;
    private String nickname;
    private String avatarUrl;
    private Gender gender;
    private String email;
    private Long lastLoginTime;
    private Boolean deleted;
    private Long createdBy;
    private Long createdAt;
    private Long updatedBy;
    private Long updatedAt;

    public Consumer() {
    }

    public Consumer(String username) {
        this.username = username;
    }
}
