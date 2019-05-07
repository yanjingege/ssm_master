package com.oralce.web.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class subMonster extends Monster {
	
	private School school;
	
	

	public School getSchool() {
		return school;
	}



	public void setSchool(School school) {
		this.school = school;
	}



	@Override
	public String toString() {
		return "subMonster [school=" + school + "]";
	}
	
	

   
   
}
