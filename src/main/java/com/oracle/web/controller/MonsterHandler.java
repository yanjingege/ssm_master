package com.oracle.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oracle.web.service.MonsterService;
import com.oracle.web.service.SchoolService;
import com.oralce.web.bean.Monster;
import com.oralce.web.bean.PageBean;
import com.oralce.web.bean.School;
import com.oralce.web.bean.subMonster;


@Controller
@Scope(value = "prototype")
public class MonsterHandler{

	@Autowired
	private MonsterService monsterService;

	@Autowired
	private SchoolService schoolService;
	
//    @RequestMapping(value="/monsters",method=RequestMethod.GET)
//	public String monsters(HttpServletRequest request){
//		
//    	List<subMonster> list=monsterService.list();
//    	
//    	request.setAttribute("mlist", list);
//    	
//    	//System.out.println(list);
//    	
//    	return "list";
//    	
//	}

    @RequestMapping(value="/addUI",method=RequestMethod.GET)
	public String  addUI(HttpServletRequest request){
		
    	List<School> list=schoolService.list();
    	
    	request.setAttribute("slist", list);
    	
    	return "add";
    	
	}
    @RequestMapping(value="/monster",method=RequestMethod.POST)
   	public String  add(Monster monster){
    	
    	//System.out.println(monster);
   		
        monsterService.save(monster);
      
       	return "redirect:/monsters";
       	
   	}
    @RequestMapping(value="/monster/{monsterId}",method=RequestMethod.DELETE)
   	public String  delete(@PathVariable("monsterId") Integer id){
   		
         Monster m=new Monster();
         
         m.setMonsterId(id);
         
         monsterService.delete(m);
      
       	return "redirect:/monsters";
       	
   	}
    
    @RequestMapping(value="/monster/{monsterId}",method=RequestMethod.GET)
   	public String  updateUI(@PathVariable("monsterId") Integer id,HttpSession session){
   		
         Monster monster=monsterService.queryOneMonster(id);
         
         session.setAttribute("m", monster);
         
         List<School> list=schoolService.list();
        
         session.setAttribute("slist", list);
       
       	return "redirect:/update.jsp";
       	
   	}
    @RequestMapping(value="/monster",method=RequestMethod.PUT)
   	public String  update(Monster monster){
   		
         monsterService.update(monster);
         
       //  System.out.println(monster);
      
       	return "redirect:/monsters";
       	
   	}
    
//    @RequestMapping(value = "/monsters", method = RequestMethod.GET)
//	public String list(Integer pageNow ,HttpServletRequest request) {
//    	
//		if(pageNow==null||pageNow<1){
//			
//			pageNow=1;
//			
//		}
//		int pageSize = 5;
//		
//		PageBean<subMonster> pb =monsterService.showByPage(pageNow, pageSize);
//
//		//System.out.println(pb);
//
//		request.setAttribute("pb", pb);
//
//		return "list";
//
//	}
    
    
    @RequestMapping(value = "/monsters", method = RequestMethod.GET)
  	public String list(Integer pageNow ,HttpServletRequest request) {
      	
  		if(pageNow==null||pageNow<1){
  			
  			pageNow=1;
  			
  		}
  		
  		PageBean<subMonster> pb =this.monsterService.selectAllByPageHelper(pageNow);

  		request.setAttribute("pb", pb);

  		return "list";

  	}

	
}
