package com.takagi.mybatis.mapper;

import com.takagi.mybatis.bean.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptMapper {

    @Select("SELECT * FROM Dept WHERE `id`=#{id}")
    public Dept getDeptById(Integer id);

    @Insert("INSERT INTO Dept(deptName) VALUES(#{deptName})")
    public int insertDept(Dept dept);
}
