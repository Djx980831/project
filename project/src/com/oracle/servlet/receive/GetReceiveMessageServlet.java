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
import com.oracle.vo.Emp;
import com.oracle.vo.PageInfo;

/**
 * Servlet implementation class getReceiveMessageServlet
 */
@WebServlet("/files/getreceivemessagelook.do")
public class GetReceiveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Emp emp = (Emp)request.getSession().getAttribute("emp");
		
		
		PageInfo pageInfo = new PageInfo(request);
		 
		MessageService ms = new MessageService();
		
		int size = pageInfo.getPageSize();
		
		int start = (pageInfo.getCurrentPage()-1) * size;
		
//		List<Map<String,Object>> rmessage = ms.getReceiveMessage(emp.getEmpId());
		
		ms.getReceiveMessageForPage(pageInfo, emp.getEmpId(),start,size);
		
		System.out.println("----当前页数："+pageInfo.getCurrentPage());
		
//		System.out.println(rmessage);
//		
//		request.getSession().setAttribute("rmessage", rmessage);
		
		request.getRequestDispatcher("ReceiveMessageList.jsp").forward(request, response);
		
	}

}
