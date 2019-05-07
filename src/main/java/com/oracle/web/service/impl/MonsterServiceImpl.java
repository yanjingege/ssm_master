package com.oracle.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.web.mapper.MonsterMapper;
import com.oracle.web.service.MonsterService;
import com.oralce.web.bean.Monster;
import com.oralce.web.bean.PageBean;
import com.oralce.web.bean.subMonster;

@Service
public class MonsterServiceImpl implements MonsterService{

	
	@Autowired
	private MonsterMapper monsterMapper;

//	@Override
//	@Transactional(readOnly=true)
//	public List<subMonster> list() {
//		// TODO Auto-generated method stub
//		return this.monsterMapper.selectAll();
//	}

	@Override
	@Transactional
	public int save(Monster monster) {
		// TODO Auto-generated method stub
		return this.monsterMapper.insert(monster);
	}

	@Override
	@Transactional
	public void delete(Monster monster) {
		// TODO Auto-generated method stub
		this.monsterMapper.deleteByPrimaryKey(monster.getMonsterId());
	}

	@Override
	@Transactional(readOnly=true)
	public Monster queryOneMonster(Integer monsterId) {
		// TODO Auto-generated method stub
		return this.monsterMapper.selectByPrimaryKey(monsterId);
	}

	@Override
	@Transactional
	public void update(Monster monster) {
		// TODO Auto-generated method stub
		 this.monsterMapper.updateByPrimaryKey(monster);
	}
	
	@Override
	@Transactional(readOnly=true)
	public PageBean<subMonster> showByPage(Integer pageNow, int pageSize) {
		// TODO Auto-generated method stub
		
		PageBean<subMonster> pb = new PageBean<subMonster>();

		pb.setPageNow(pageNow);

		pb.setPageSize(pageSize);
		
		//查看有多少条
		int sum=monsterMapper.selectCount();
		
		pb.setCounts(sum);
		
		//从第几条开始
		int index=(pageNow-1)*pageSize;
		
		List<subMonster> list=this.monsterMapper.selectBypage(index);
		
		pb.setBeanList(list);
		
		return pb;
		
	}

	@Override
	public PageBean<subMonster> selectAllByPageHelper(Integer pageNow) {
		// TODO Auto-generated method stub
		
		PageBean<subMonster> pb = new PageBean<subMonster>();
		
		//当前页的数据
		PageHelper.startPage(pageNow, 2);
		
		//已经是分页好的数据了
		List<subMonster> list=this.monsterMapper.selectAllByPageHelper();
		
		pb.setBeanList(list);
		
		//总记录数
		PageInfo<subMonster> pi=new PageInfo<subMonster>(list);
		
		pb.setCounts((int)pi.getTotal());
		
		//当前页
		pb.setPageNow(pi.getPageNum());
		
		//每页显示的条数，自己定义
		pb.setPageSize(pi.getPageSize());
		
		return pb;
	}
}