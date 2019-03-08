package com.oracle.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oracle.dao.EmpsDao;
import com.oracle.util.MybatisUtil;
import com.oracle.vo.Emp;
import com.oracle.vo.PageInfoEmp;

public class EmpsService {
	public List<Emp> getAll() {
		List<Emp> list = null;
		try (SqlSession session = MybatisUtil.openSession()) {
			EmpsDao dao = session.getMapper(EmpsDao.class);
			list = dao.getAll();
		}
		return list;
	}

	/**
	 * 根据账号密码登录系统
	 * 
	 * @param empNo
	 * @param passWord
	 * @return
	 */

	public Emp getEmpByNoAndPw(String empNo, String passWord) {
		Emp emp = null;
		try (SqlSession session = MybatisUtil.openSession()) {
			EmpsDao dao = session.getMapper(EmpsDao.class);
			emp = dao.getEmpByNoAndPw(empNo, passWord);
		}

		return emp;
	}

	/**
	 * 查询所有的员工
	 * 
	 * @return
	 */

	public List<Emp> getAllEmp() {
		List<Emp> list = null;
		try (SqlSession session = MybatisUtil.openSession()) {
			EmpsDao dao = session.getMapper(EmpsDao.class);
			list = dao.getAllEmp();
		}
		return list;
	}

	/**
	 * 根据empId删除员工
	 * @param empId
	 */
	
	public void daleteEmps(Integer [] empId) {
		try(SqlSession session = MybatisUtil.openSession()){
			EmpsDao dao = session.getMapper(EmpsDao.class);
			dao.deleteEmps(empId);
			session.commit();
		}
	}

	/**
	 * 添加员工
	 * @param emp
	 */
	
	public void addEmp(Emp emp) {
		try(SqlSession session = MybatisUtil.openSession()){
			EmpsDao dao = session.getMapper(EmpsDao.class);
			dao.addEmp(emp);
			session.commit();
		}
	}
	
	/**
	 * 根据empId获得emp
	 * @param empId
	 * @return
	 */
	
	public Emp getEmpById(Integer empId) {
		Emp emp = null;
		try(SqlSession session = MybatisUtil.openSession()){
			EmpsDao dao = session.getMapper(EmpsDao.class);
			emp = dao.getEmpById(empId);
		}
		return emp;
	}
	
	/**
	 * 更新emp信息
	 * @param emp
	 */
	
	public void updateEmp(Emp emp) {
		try(SqlSession session = MybatisUtil.openSession()){
			EmpsDao dao = session.getMapper(EmpsDao.class);
			dao.updateEmp(emp);
			session.commit();
		}
	}
	
	/**
	 * 分页查询emp
	 * @param start
	 * @param size
	 * @return
	 */
	
	public void getAllEmpForPage(PageInfoEmp pageInfoEmp,int start,int size) {
		List<Emp> list = new ArrayList<Emp>();
		try (SqlSession session = MybatisUtil.openSession()) {
			EmpsDao dao = session.getMapper(EmpsDao.class);
		    size = pageInfoEmp.getPageSize();
		    list = dao.getAllEmpForPage(pageInfoEmp,start, size);
			pageInfoEmp.setList(list);
			System.out.println("----当前页数："+pageInfoEmp.getCurrentPage());
			
			Long count = (long) dao.getECount();
			pageInfoEmp.setRecordCount(count.intValue());
		}
	}
	
}
