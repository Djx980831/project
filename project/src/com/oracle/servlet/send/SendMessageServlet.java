package com.oracle.servlet.send;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.MessageService;
import com.oracle.vo.Emp;
import com.oracle.vo.SendMessage;

/**
 * Servlet implementation class SendMessageServlet
 */
@WebServlet("/files/sendmessage.do")
public class SendMessageServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String sendMessageTitle = request.getParameter("sendMessageTitle");
		String sendMessageContent = request.getParameter("sendMessageContent");
		String priority = request.getParameter("priority");
		String [] ids = request.getParameterValues("empId");
		
		Integer [] id = new Integer[ids.length];
		
		for(int i = 0 ; i < ids.length;i++) {
			id[i] = Integer.valueOf(ids[i]);
		}
		
		SendMessage sm = new SendMessage();
		Emp emp = (Emp)request.getSession().getAttribute("emp");
		
		sm.setEmpId(emp.getEmpId());
		sm.setMessageTitle(sendMessageTitle);
		sm.setMessageContent(sendMessageContent);
		sm.setPriority(Integer.valueOf(priority));
		
		MessageService ms = new MessageService();
		ms.sendMessage(sm, id);
		
		response.sendRedirect("sendMessage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
