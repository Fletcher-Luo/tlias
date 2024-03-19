package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.EmpService;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登陆：" + emp);
        Emp e = empService.login(emp);
        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("NOT_LOGIN");
    }
}
