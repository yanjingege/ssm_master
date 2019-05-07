package com.oracle.web.mapper;

import com.oralce.web.bean.School;
import java.util.List;

public interface SchoolMapper {
    int deleteByPrimaryKey(Integer schoolId);

    int insert(School record);

    School selectByPrimaryKey(Integer schoolId);

    List<School> selectAll();

    int updateByPrimaryKey(School record);
}