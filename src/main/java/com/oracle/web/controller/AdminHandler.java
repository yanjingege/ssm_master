package com.oracle.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.web.service.AdminService;
import com.oralce.web.bean.Admin;

@Controller
@Scope(value="prototype")
public class AdminHandler{

	private static final String NONE = null;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
    public String add(Admin admin){
		
		adminService.save(admin);
		
		return "redirect:/login.jsp";
	}
    
	@RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(Admin admin){
    	
    	Admin admin1=this.adminService.login(admin);
    	
    	if(admin1==null){
    		
    		return "redirect:/login.jsp";
    	}
    	
    	if(!admin1.getPassword().equals(admin.getPassword())){
    		
    		return "redirect:/login.jsp";
    	}
  	  
    	return "redirect:/index.jsp";
		
    }
	
	@RequestMapping(value = "validate.action")
	@ResponseBody
	public String queryByMame(String username,HttpServletResponse response) throws IOException{

		System.out.println(username);

		Admin a =adminService.queryone(username);

		response.setContentType("text/html;charset=utf-8");

        if(a!=null){
			
            response.getWriter().write("{\"valid\":\"false\"}");
		
			}else{
				
				response.getWriter().write("{\"valid\":\"true\"}");//不存在
			}
		
		return NONE;

	}
}
