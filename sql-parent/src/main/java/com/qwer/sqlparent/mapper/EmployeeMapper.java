package com.qwer.sqlparent.mapper;

import com.qwer.module.pojo.Employee;


/**
 * 用户接口，只有普通用户的权限
 */
public interface EmployeeMapper {

    /**
     *
     * 普通用户使用
     */
    public int add(Employee employee);

    public int update(Employee employee);

    public int selectById(Integer id);

    public int selectByUserName(String username);

    public Employee selectByUsernameAndPassword(Employee employee);

}
