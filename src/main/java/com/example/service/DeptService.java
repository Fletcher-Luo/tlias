package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();
    void delete(Integer id);
    void save(Dept dept);

    void update(Dept dept);
    Dept getById(Integer id);
}
