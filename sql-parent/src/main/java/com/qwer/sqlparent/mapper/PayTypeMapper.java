package com.qwer.sqlparent.mapper;

import com.qwer.module.pojo.PayType;

import java.util.List;

/**
 * 支付编码接口，只有普通用户的权限
 */
public interface PayTypeMapper {

    /**
     *
     * 普通用户使用
     */
    public List<PayType> selectByTeam();
}
