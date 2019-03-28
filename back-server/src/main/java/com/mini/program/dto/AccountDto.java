package com.mini.program.dto;

import com.mini.program.enums.Gender;
import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    private String username;
    private Long phone;
    private Gender gender;
    private String vcode;
    private String password;
    private String promotionCode;
    private String InvitationCode;
    private String clientAssertion;
    private String code;
}
