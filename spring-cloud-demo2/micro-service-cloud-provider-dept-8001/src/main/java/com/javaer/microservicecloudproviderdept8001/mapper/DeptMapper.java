package com.javaer.microservicecloudproviderdept8001.mapper;

import com.javaer.microservicecloudapi.entity.Dept;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface DeptMapper {
    Dept selectByPrimaryKey(Integer deptNo);
    List<Dept> GetAll();
}
