package com.qwer.sqlparent.mapper;

import com.qwer.module.pojo.Product;
import java.util.List;

/**
 * 产品接口，只有普通用户的权限
 */
public interface ProductMapper {

    /**
     *
     * 普通用户使用
     */
    public int add(Product product);

    public int update(Product product);

    public int deleteById(Integer id);

    public Product selectById(Integer id);

    public List<Product> selectByEmployeeId(Integer employeeId);

    public List<Product> selectByIdList(Integer[] list);

}
