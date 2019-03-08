package com.oracle.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oracle.vo.Emp;
import com.oracle.vo.PageInfoEmp;

public interface EmpsDao {
	public List<Emp> getAll();
	
	public Emp getEmpByNoAndPw(@Param("empNo") String empNo,@Param("passWord") String passWord);
	
	public List<Emp> getAllEmp();
	
	public void deleteEmps(Integer []empId);
	
	public void addEmp(Emp emp);
	
	public void updateEmp(Emp emp);
	
	public Emp getEmpById(@Param("empId") Integer empId);
	
	public List<Emp> getAllEmpForPage(PageInfoEmp pageInfoEmp,@Param("start") int start, @Param("size") int size);
	
	public int getECount();
}
