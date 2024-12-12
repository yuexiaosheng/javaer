package com.example.Batis3.mapper;

import com.example.Batis3.po.Website;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WebsiteMapper {

    /**
     * 这个名字对应WebsitMapper.xml里的id
     * <select id="selectOneWebsite" parameterType="java.lang.Integer"
     *             resultType="com.example.Batis3.po.Website">
     * @param id
     * @return
     */
    public Website selectOneWebsite(Integer id);
}
