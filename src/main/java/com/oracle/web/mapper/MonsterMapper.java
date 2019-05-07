package com.oracle.web.mapper;

import com.oralce.web.bean.Monster;
import com.oralce.web.bean.PageBean;
import com.oralce.web.bean.subMonster;

import java.util.List;

public interface MonsterMapper {
    int deleteByPrimaryKey(Integer monsterId);

    int insert(Monster record);

    Monster selectByPrimaryKey(Integer monsterId);

    List<subMonster> selectAll();

    int updateByPrimaryKey(Monster record);

	List<subMonster> selectBypage(int index);
	
	int selectCount();

	List<subMonster> selectAllByPageHelper();

}
