package com.qwer.master.mapper;


import com.qwer.module.pojo.Product;
import com.qwer.sqlparent.mapper.ProductMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MasterProductMapper extends ProductMapper {

    /**
     * 管理员使用
     */
    public int deleteByTeam(String team);

    public List<Product> selectByTeam();

    public List<Product> selectAll();

}
