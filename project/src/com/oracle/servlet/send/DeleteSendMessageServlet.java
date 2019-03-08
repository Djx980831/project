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
 * Servlet implementation class DeleteSendMessageServlet
 */
@WebServlet("/files/delete.do")
public class DeleteSendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sendId = request.getParameter("sendId");
		
		MessageService ms = new MessageService();
		
		ms.DeleteSendMessage(Integer.valueOf(sendId));
		
		
		request.getRequestDispatcher("getsendmessage.do").forward(request, response);
	}

}
