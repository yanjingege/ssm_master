package com.oracle.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.oracle.web.mapper.SchoolMapper;
import com.oracle.web.service.SchoolService;
import com.oralce.web.bean.School;

@Service
public class SchoolServiceImpl implements SchoolService {

	
	@Autowired
	private SchoolMapper schoolMapper;

	@Override
	@Transactional(readOnly=true)
	public List<School> list() {
		// TODO Auto-generated method stub
		return this.schoolMapper.selectAll();
	}
	
	
	
}
