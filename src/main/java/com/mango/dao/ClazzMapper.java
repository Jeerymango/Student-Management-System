package com.mango.dao;

import com.mango.domain.Clazz;

import java.util.List;

public interface ClazzMapper {

    // TODO: 6/14/2019 根据班级名称获取指定/全部班级信息列表
    List<Clazz> selectList(Clazz clazz);

    // TODO: 6/16/2019 查询所有班级列表信息(用于在学生管理页面中获取班级信息)
    List<Clazz> selectAll();

    // TODO: 6/15/2019 获取指定名称的班级信息
    Clazz findByName(String name);

    // TODO: 6/15/2019 添加班级信息
    int insert(Clazz clazz);

    // TODO: 6/15/2019 根据id删除指定班级信息
    int deleteById(Integer[] ids);

    // TODO: 6/15/2019 根据id修改指定班级信息
    int update(Clazz clazz);

}
