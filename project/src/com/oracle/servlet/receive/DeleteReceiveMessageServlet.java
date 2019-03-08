package com.oracle.servlet.receive;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.MessageService;

/**
 * Servlet implementation class DeleteReceiveMessageServlet
 */
@WebServlet("/files/deletereceivemessage.do")
public class DeleteReceiveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String receiveId = request.getParameter("receiveId");
		
		MessageService ms = new MessageService();
		
		ms.DeleteReceiveMessage(Integer.valueOf(receiveId));
		
		response.sendRedirect("getreceivemessagelook.do");
		
	}

}
