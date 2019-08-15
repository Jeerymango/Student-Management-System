package com.mango.service;

import com.mango.domain.Admin;
import com.mango.domain.LoginForm;

import java.util.List;

public interface AdminService {

    // TODO: 6/18/2019 验证登录信息是否正确
    Admin login(LoginForm loginForm);

    // TODO: 6/12/2019 根据用户名查询指定管理员信息
    Admin findByName(String name);

    // TODO: 6/12/2019 添加管理员信息
    int insert(Admin admin);

    // TODO: 6/12/2019 根据姓名查询指定/所有管理员信息列表
    List<Admin> selectList(Admin admin);

    // TODO: 6/13/2019 根据id更新指定管理员信息
    int update(Admin admin);

    // TODO: 6/18/2019 根据id修改指定用户密码
    int updatePassowrd(Admin admin);

    // TODO: 6/13/2019 根据id删除管理员信息
    int deleteById(Integer[] ids);

}