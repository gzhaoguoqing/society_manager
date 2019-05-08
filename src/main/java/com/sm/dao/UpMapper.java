package com.sm.dao;

import com.sm.client.UpExample;
import com.sm.po.Up;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UpMapper {
    long countByExample(UpExample example);

    int deleteByExample(UpExample example);

    int insert(Up record);

    int insertSelective(Up record);

    List<Up> selectByExample(UpExample example);

    int updateByExampleSelective(@Param("record") Up record, @Param("example") UpExample example);

    int updateByExample(@Param("record") Up record, @Param("example") UpExample example);
}