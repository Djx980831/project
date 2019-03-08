package com.oracle.servlet.receive;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.MessageService;

/**
 * Servlet implementation class DeleteReceiveMessagesServlet
 */
@WebServlet("/files/deletereceivemessages.do")
public class DeleteReceiveMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] receiveIds = request.getParameterValues("receiveId");
		Integer [] ids = new Integer [receiveIds.length];
		for(int i = 0;i < ids.length;i++) {
			ids[i] = Integer.valueOf(receiveIds[i]);
		}
		
		MessageService ms = new MessageService();
		ms.DeleteReceiveMessages(ids);
		
		response.sendRedirect("getreceivemessagelook.do");
	}

}
