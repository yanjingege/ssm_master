package com.oracle.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.oralce.web.bean.PageBean;
import com.oralce.web.bean.subMonster;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class TestController {
	
	@Autowired
	WebApplicationContext context;
	
	//模拟发送请求
	MockMvc mvc;
	
	@Before
	public void init(){
		
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
	
	}

	@Test
	public void testPage() throws Exception{
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/monsters")).andReturn();
		
		MockHttpServletRequest request = mvcResult.getRequest();
		
	    PageBean<subMonster> pb = (PageBean<subMonster>) request.getAttribute("pb");
	    
	    //System.out.println(pb);
	    
	    List<subMonster> list=pb.getBeanList();
	    
	    for (subMonster subMonster : list) {
			
	    	System.out.println(subMonster);
	    	
		}
	}
}
