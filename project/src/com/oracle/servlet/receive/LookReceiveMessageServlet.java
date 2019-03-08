package com.oracle.servlet.receive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.MessageService;

/**
 * Servlet implementation class LookReceiveMessageServlet
 */
@WebServlet("/files/getreceivemessage.do")
public class LookReceiveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receiveId = request.getParameter("receiveId");
		
		MessageService ms = new MessageService();
		
		ms.updateOpenDate(Integer.valueOf(receiveId));
		
		Map oneRMessage = (Map) ms.getReceiveMessageById(Integer.valueOf(receiveId));
		
		request.getSession().setAttribute("oneRMessage", oneRMessage);
		
		request.getRequestDispatcher("ReceiveMessage.jsp").forward(request, response);
	}

}
