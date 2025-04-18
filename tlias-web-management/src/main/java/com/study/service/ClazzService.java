package com.study.service;


import com.study.pojo.Clazz;
import com.study.pojo.ClazzQueryParam;
import com.study.pojo.PageResult;

import java.util.List;

public interface ClazzService {


    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    void add(Clazz clazz);

    Clazz getInfoById(Integer id);

    void update(Clazz clazz);

    void deteleById(Integer id);

    List<Clazz> getAllInfo();
}
