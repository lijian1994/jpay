package com.qwer.master.mapper;

import com.qwer.module.pojo.Employee;
import com.qwer.sqlparent.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MasterEmployeeMapper extends EmployeeMapper {

    /**
     * 管理员使用
     */
    public List<Employee> selectByTeam(String team);

    public List<Employee> selectAll();

    public int deleteById(Integer id);

    public int deleteByTeam(String team);
}
