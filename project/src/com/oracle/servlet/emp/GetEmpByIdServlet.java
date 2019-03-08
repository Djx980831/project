package com.oracle.servlet.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.dao.EmpsDao;
import com.oracle.service.EmpsService;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/files/getempbyid.do")
public class GetEmpByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmpByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empId = request.getParameter("empId");
		EmpsService dao = new EmpsService();
		
		Emp empInfo = dao.getEmpById(Integer.valueOf(empId));
		
		request.getSession().setAttribute("empInfo", empInfo);
		
		request.getRequestDispatcher("updateemp.jsp").forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
