package com.mango.dao;

import com.mango.domain.LoginForm;
import com.mango.domain.Student;

import java.util.List;


public interface StudentMapper {

    // TODO: 6/18/2019 验证登录信息是否正确
    Student login(LoginForm loginForm);

    // TODO: 6/17/2019 根据班级与学生名获取指定或全部学生信息列表
    List<Student> selectList(Student student);

    // TODO: 6/19/2019 根据学号查询指定学生信息
    Student findBySno(Student student);

    // TODO: 6/17/2019 添加班级信息
    int insert(Student student);

    // TODO: 6/17/2019 根据id修改指定学生信息
    int update(Student student);

    // TODO: 6/18/2019 根据id修改指定学生密码
    int updatePassword(Student student);

    // TODO: 6/17/2019 根据id删除指定学生信息
    int deleteById(Integer[] ids);

}
