package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    EmpService empService;
    @GetMapping("/emps")
    public Result page(Integer page,
                       Integer pageSize,
                       String name,
                       Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("查询" + "page" + page +
                "pageSize" + pageSize +
                "name" + name +
                "gender" + gender +
                "begin" + begin +
                "end" + end);
        return Result.success(empService.page(page, pageSize, name, gender, begin, end));
    }

    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除员工：" + ids);
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping("/emps")
    public Result save(@RequestBody Emp emp) {
        log.info("添加员工" + emp.getName() + emp.getUsername());
        empService.save(emp);
        return Result.success();
    }
}
