package com.oracle.listener;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.oracle.vo.Emp;


/**
 * Application Lifecycle Listener implementation class SessionAttributerListener
 *
 */
@WebListener
public class SessionAttributerListener implements HttpSessionListener, HttpSessionAttributeListener {

	static ConcurrentHashMap<String, HttpSession> map = new ConcurrentHashMap<String, HttpSession>();
	
    /**
     * Default constructor. 
     */
    public SessionAttributerListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	 //登录一个用户
    	if(se.getName().equals("user")) {
    		Emp emp = (Emp)se.getValue();
    		
    		//当前对象是否在线
    		if(map.containsKey(emp.getEmpName())) {
    			map.remove(emp.getEmpName()).invalidate();
    		}
    		
    		//向map中增加一个对象
    		map.put(emp.getEmpName(),se.getSession());
    		System.out.println(emp.getEmpName()+"-----------已上线");
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	 if(se.getName().equals("user")) {
         	Emp emp = (Emp)se.getValue();
         	map.remove(emp.getEmpName());
         	System.out.println(emp.getEmpName()+"-----------已下线");
         }
    }
	
}
