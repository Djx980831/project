package com.oracle.servlet.send;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.MessageService;
import com.oracle.vo.Emp;
import com.oracle.vo.PageInfo;
import com.oracle.vo.SendMessage;

/**
 * Servlet implementation class GetSendMessageServlet
 */
@WebServlet("/files/getsendmessage.do")
public class GetSendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSendMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Emp emp = (Emp)request.getSession().getAttribute("emp");
		
		
		PageInfo pageInfo = new PageInfo(request);
		 
		MessageService ms = new MessageService();
		
		int size = pageInfo.getPageSize();
		
		int start = (pageInfo.getCurrentPage()-1) * size;
		
//		List<Map<String,Object>> rmessage = ms.getReceiveMessage(emp.getEmpId());
		
		ms.getSendMessageForPage(pageInfo, emp.getEmpId(),start,size);
		
		request.getRequestDispatcher("sendMessageList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
