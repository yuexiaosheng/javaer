package com.javaer.microservicecloudproviderdept8001.service;

import com.javaer.microservicecloudapi.entity.Dept;

import java.util.List;


public interface DeptService {
    Dept get(Integer deptNo);
    List<Dept> selectAll();
}
