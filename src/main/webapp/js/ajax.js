
       function getXMLHttpRequest(){
       	
       	   try{
       	   	
       	   	return  new XMLHttpRequest();
       	   	
       	   }catch(e){
       	   	
       	   	   try{
       	   	   	
       	   	   	   return new AcitveXObject("Microsoft.XMLHTTP");
       	   	   	
       	   	   }catch(e){
       	   	   	    try{
       	   	   	    	
       	   	   	    	return new ActiveXObject("Msxml2.XMLHTTP");
       	   	   	    	
       	   	   	    }catch(e){
       	   	   	    	
       	   	   	    	alert("哥们，你用的浏览器是什么鬼？请换一个吧");
       	   	   	    	
       	   	   	    	throw e;
       	   	   	    	
       	   	   	    }
       	   	   	
       	   	   }
       	   }
       	
       }
      
       
       
    
       function ajax(opt){
       	
       	
       	//1.得到对象
       	var http=getXMLHttpRequest();
       	
       	//2.打开连接
       	
       	//method默认不传的话，我就是get请求
       	
       	if(!opt.method){
       		
       		opt.method="GET";
       	}
       	
       	//ansy 一般都是异步
       	
       	if(opt.ansy==undefined){
       		
       		
       		opt.ansy=true;
       	}
       	
       	http.open(opt.method,opt.url,opt.ansy);
       	
       	//3.发送请求
       	
       	//如果是post请求，发送头信息
       	
       	if(opt.method=="POST"){
       		
       		
       		http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
       	}
       	
       	http.send(opt.params);
       	
       	//4.监听请求响应的变化
       	
       	http.onreadystatechange=function(){
       		
       		if(http.readyState==4&& http.status==200){
       		
       			var data;
       			
       			if(!opt.type){
       				
       				data=http.responseText;
       			
       			}else if(opt.type=="text"){
       				
       				data=http.responseText;
       				
       			}else if(opt.type=="xml"){
       				
       				//alert("ok");
       				
       				data=http.responseXML;
       				
       			}else if(opt.type=="json"){
       				
       				var content=http.responseText;
       				
       				data=eval("("+content+")");
       			}
       			
       		
       			opt.success(data);
       			
       		}
       		
       	}
       	
       }