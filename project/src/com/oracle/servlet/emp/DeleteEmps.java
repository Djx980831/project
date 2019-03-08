package com.oracle.servlet.emp;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.EmpsService;

/**
 * Servlet implementation class DeleteEmps
 */
@WebServlet("/files/delectemps.do")
public class DeleteEmps extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] empIds = request.getParameterValues("empId");
		System.out.println("接收到的empIds是："+Arrays.toString(empIds));
		Integer []empId = new Integer[empIds.length];
		
		for(int i = 0;i < empIds.length;i++) {
			empId[i] = Integer.valueOf(empIds[i]);
		}
		
		EmpsService ms = new EmpsService();
		
		ms.daleteEmps(empId);
		
		response.sendRedirect("getallemp.do");
	}

}
