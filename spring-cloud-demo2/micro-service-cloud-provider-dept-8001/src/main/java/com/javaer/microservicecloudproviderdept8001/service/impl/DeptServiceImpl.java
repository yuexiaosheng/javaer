package com.javaer.microservicecloudproviderdept8001.service.impl;


import com.javaer.microservicecloudapi.entity.Dept;
import com.javaer.microservicecloudproviderdept8001.mapper.DeptMapper;
import com.javaer.microservicecloudproviderdept8001.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept get(Integer deptNo) {
        return deptMapper.selectByPrimaryKey(deptNo);
    }

    @Override
    public List selectAll() {
        return deptMapper.GetAll();
    }

    public List selectAll2() {
        List L = new ArrayList();
        L.add("abc1");
        L.add("abc2");
        //return deptMapper.GetAll();
        return L;
    }
}