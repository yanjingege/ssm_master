package com.oracle.web.mapper;

import com.oralce.web.bean.Admin;
import java.util.List;

public interface AdminMapper {
	 int deleteByPrimaryKey(Integer adminId);
	 
     int insert(Admin record);
	 
     Admin selectByPrimaryKey(String name);
	 
     List<Admin> selectAll();
	 
     int updateByPrimaryKey(Admin record);
	   
     Admin  selectone(Admin record);
}
