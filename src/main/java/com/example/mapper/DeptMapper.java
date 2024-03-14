package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into dept (name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void save(Dept dept);

    @Update("update dept set name=#{name}, update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id=#{id}")
    Dept getById(Integer id);
}
