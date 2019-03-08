package com.oracle.servlet.send;

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

/**
 * Servlet implementation class GetSendMessageDynamicServlet
 */
@WebServlet("/files/getsendbydynamic.do")
public class GetSendMessageDynamicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSendMessageDynamicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		request.getSession().setAttribute("list", ms.getSendMessages(map));
		request.getRequestDispatcher("sendmessagesbydynamic.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
