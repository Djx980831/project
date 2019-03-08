package com.oracle.servlet.receive;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.MessageService;
import com.oracle.vo.Emp;
import com.oracle.vo.PageInfo;

/**
 * Servlet implementation class GetReceiveMessageDynamicServlet
 */
@WebServlet("/files/getreceivebydynamic.do")
public class GetReceiveMessageDynamicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String messageTitle = request.getParameter("messageTitle");
		String empName = request.getParameter("empName");
		
		Emp emp = (Emp)request.getSession().getAttribute("emp");
		System.out.println("-----"+emp);
		Integer empId = emp.getEmpId();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("empId",empId);
		map.put("messageTitle",messageTitle);
		map.put("empName",empName);
		
		
		MessageService ms = new MessageService();
		
		request.getSession().setAttribute("list", ms.getReceiveMessages(map));
		request.getRequestDispatcher("receivemessagesbydynamic.jsp").forward(request, response);
		
	}

}
