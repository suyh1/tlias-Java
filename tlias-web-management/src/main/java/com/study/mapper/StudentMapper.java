package com.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    @Select("select count(*) from student where clazz_id = #{id}")
    int countByClazzId(Integer id);
}
