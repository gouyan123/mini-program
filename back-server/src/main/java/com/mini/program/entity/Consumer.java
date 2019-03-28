package com.mini.program.entity;

import com.mini.program.enums.Gender;
import lombok.Data;

@Data
public class Consumer {

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
}
