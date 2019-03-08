package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.EmpsService;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empNo = request.getParameter("empNo");
		String passWord = request.getParameter("passWord");
		String checkCode = request.getParameter("checkCode");
		
		EmpsService em = new EmpsService();
		Emp emp = em.getEmpByNoAndPw(empNo, passWord);
		
		String yzm = (String) request.getSession().getAttribute("randCheckCode");
		System.out.println("--------验证码："+yzm);
		String rem = request.getParameter("rem");
		
		
		if(rem != null) {
			//1.创建cookie
			Cookie cname = new Cookie("name",emp.getEmpNo());
			cname.setMaxAge(Integer.valueOf(rem));
			
			Cookie cpass = new Cookie("pw",emp.getPassWord());
			cpass.setMaxAge(Integer.valueOf(rem));
			
			//2.向客户端发送cookie
			response.addCookie(cname);
			response.addCookie(cpass);
		}
		
		if(emp != null) {
			if(checkCode.equals(yzm)) {
				request.getSession().setAttribute("emp", emp);
				if(emp.getId() == 1) {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("index2.jsp").forward(request, response);
				}
				
			}else {
				response.sendRedirect("login.jsp");
			}
		}else {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
