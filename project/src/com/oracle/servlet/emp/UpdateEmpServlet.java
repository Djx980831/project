package com.oracle.servlet.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.service.EmpsService;
import com.oracle.vo.Emp;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/files/updateemp.do")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String passWord = request.getParameter("passWord");
		String empName = request.getParameter("empName");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String idCard = request.getParameter("idCard");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String empType = request.getParameter("empType");
		String empTypeName = request.getParameter("empTypeName");
		String bankName = request.getParameter("bankName");
		String bankNo = request.getParameter("bankNo");
		System.out.println("--------"+bankNo);
		String sal = request.getParameter("sal");
		System.out.println("--------"+sal);
		String comm = request.getParameter("comm");
		System.out.println("--------"+comm);
		String subsidy = request.getParameter("subsidy");
		String descript = request.getParameter("descript");
		String hireDate = request.getParameter("hireDate");

		Emp emp = new Emp();

		emp.setEmpId(Integer.valueOf(empId));
		emp.setPassWord(passWord);
		emp.setEmpName(empName);
		emp.setSex(sex);
		emp.setAge(0);
		emp.setBirth(birth);
		emp.setIdCard(idCard);
		emp.setEmail(email);
		emp.setTel(tel);
		emp.setAddress(address);
		emp.setEmpType(empType);
		emp.setEmpTypeName(empTypeName);
		emp.setBankName(bankName);
		emp.setBankNo(bankNo);
		emp.setSal(Integer.valueOf(sal));
		emp.setComm(Integer.valueOf(comm));
		emp.setSubsidy(Integer.valueOf(subsidy));
		emp.setHireDate(hireDate);
		emp.setDescript(descript);
		
		EmpsService ms = new EmpsService();

		ms.updateEmp(emp);
		
		response.sendRedirect("getallemp.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
