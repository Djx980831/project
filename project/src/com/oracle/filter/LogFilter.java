package com.oracle.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.oracle.service.LogService;
import com.oracle.vo.Emp;
import com.oracle.vo.Log;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("*.do")
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String ip = request.getRemoteAddr();
		HttpServletRequest hsr = (HttpServletRequest)request;
	
		Emp emp = (Emp)hsr.getSession().getAttribute("emp");
		System.out.println("用户是："+emp);
		String url = hsr.getRequestURL().toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		String date = sdf.format(new Date());
		
		Log log = new Log();
		
		log.setIp(ip);
		log.setUrl(url);
		log.setTimestamp(date);
		
		LogService service = new LogService();
		
		service.insert(log);
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
