package com.mini.program.api;

import com.mini.program.dto.AccountDto;
import com.mini.program.dto.WechatAuthenticationResponse;
import com.mini.program.entity.Consumer;
import com.mini.program.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthEndpoint {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private WechatService wechatService;

    @GetMapping("/test")
    public String test() {
        return "test_success";
    }

    @GetMapping("/testAuth")
    public String testAuth() {
        return "testAuth_success";
    }

    @PostMapping("/auth")
    public ResponseEntity<WechatAuthenticationResponse> createAuthenticationToken(@RequestBody AccountDto accountDto)
            throws AuthenticationException {
        WechatAuthenticationResponse jwtResponse = wechatService.wechatLogin(accountDto.getCode());
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/updateConsumerInfo")
    public void updateConsumerInfo(@RequestBody Consumer consumer) {
        wechatService.updateConsumerInfo(consumer);
    }

}
