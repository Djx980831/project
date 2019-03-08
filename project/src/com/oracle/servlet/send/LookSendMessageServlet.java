package com.oracle.servlet.send;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.MessageService;
import com.oracle.vo.SendMessage;

/**
 * Servlet implementation class LookSendMessageServlet
 */
@WebServlet("/files/look.do")
public class LookSendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sendId = request.getParameter("sendId");
		
		MessageService ms = new MessageService();
		SendMessage smessage = ms.getMessageById(Integer.valueOf(sendId));
		
		request.getSession().setAttribute("smessage",smessage);
		
		request.getRequestDispatcher("sendxiaoximingxi.jsp").forward(request, response);
		
	}

}
