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
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/files/addemp.do")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("servlet");
		String empNo = request.getParameter("empNo");
		System.out.println(empNo);
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

		emp.setEmpNo(empNo);
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

		ms.addEmp(emp);

		response.sendRedirect("getallemp.do");

	}

}
