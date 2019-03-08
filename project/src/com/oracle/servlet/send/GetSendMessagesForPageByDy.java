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
import com.oracle.vo.PageInfo;

/**
 * Servlet implementation class GetSendMessagesForPageByDy
 */
@WebServlet("/files/getsendmessagesforpagebydy.do")
public class GetSendMessagesForPageByDy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSendMessagesForPageByDy() {
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
		
		Integer empId = emp.getEmpId();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("empId",empId);
		map.put("messageTitle",messageTitle);
		map.put("empName",empName);
		
		
		PageInfo pageInfo = new PageInfo(request);
		System.out.println("url:"+pageInfo.getUrl()+"-----------");
		 
		MessageService ms = new MessageService();
		
		int size = pageInfo.getPageSize();
		
		int start = (pageInfo.getCurrentPage()-1) * size;
		
		ms.getSendMessageForPageByDy(map, pageInfo, start, size);
		
		request.getRequestDispatcher("SendMessageListForPageByDy.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
