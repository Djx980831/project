package com.oracle.servlet.send;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.MessageService;

/**
 * Servlet implementation class DeleteSendMessagesServlet
 */
@WebServlet("/files/deletesendmessages.do")
public class DeleteSendMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] sendIds = request.getParameterValues("sendId");
		Integer [] ids = new Integer [sendIds.length];
		for(int i = 0;i < ids.length;i++) {
			ids[i] = Integer.valueOf(sendIds[i]);
		}
		
		MessageService ms = new MessageService();
		ms.DeleteSendMessages(ids);
		
		response.sendRedirect("getsendmessage.do");
	}

}
