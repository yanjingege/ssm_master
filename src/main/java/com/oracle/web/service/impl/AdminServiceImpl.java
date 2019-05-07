package com.oracle.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.oracle.web.mapper.AdminMapper;
import com.oracle.web.service.AdminService;
import com.oracle.web.service.MonsterService;
import com.oralce.web.bean.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	@Transactional
	public int save(Admin admin) {
		// TODO Auto-generated method stub
		return this.adminMapper.insert(admin);
	}

	@Override
	@Transactional
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		return this.adminMapper.selectone(admin);
	}

	@Override
	@Transactional
	public Admin queryone(String username) {
		// TODO Auto-generated method stub
		return this.adminMapper.selectByPrimaryKey(username);
	}


}
