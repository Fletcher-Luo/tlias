package com.example.controller;

import com.example.anno.Log;
import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        log.info("查询部门全部数据");
        return Result.success(deptService.list());
    }

    @Log
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除部门" + id);
        deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping("/depts")
    public Result save(@RequestBody Dept dept) {
        log.info("新增部门：" + dept.getName());
        deptService.save(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("查询部门" + id);
        return Result.success(deptService.getById(id));
    }


    @Log
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门" + dept.getId() + "：" + dept.getName());
        deptService.update(dept);
        return Result.success();
    }
}
