package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
    "values(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void save(Emp emp);
}
