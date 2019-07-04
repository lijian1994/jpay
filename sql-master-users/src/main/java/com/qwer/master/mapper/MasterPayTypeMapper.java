package com.qwer.master.mapper;

import com.qwer.module.pojo.PayType;
import com.qwer.sqlparent.mapper.PayTypeMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MasterPayTypeMapper extends PayTypeMapper {

    public int add(PayType payType);

    public int update(PayType payType);

    public int deleteById(Integer id);

    public int deleteByTeam(String team);

    public PayType selectById(Integer id);

    public List<PayType> selectAll();
}
