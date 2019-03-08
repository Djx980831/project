package com.oracle.servlet.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.EmpsService;
import com.oracle.vo.Emp;
import com.oracle.vo.PageInfoEmp;

/**
 * Servlet implementation class GetAllEmp
 */
@WebServlet("/files/getallemp.do")
public class GetAllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpsService ms = new EmpsService();
		
		PageInfoEmp pageInfoEmp = new PageInfoEmp(request);
		
		int size = pageInfoEmp.getPageSize();
		int start = (pageInfoEmp.getCurrentPage()-1) * size;
		
		ms.getAllEmpForPage(pageInfoEmp, start, size);
		
		request.getRequestDispatcher("getallemp.jsp").forward(request, response);
	}

}
