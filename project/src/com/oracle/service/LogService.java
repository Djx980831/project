package com.oracle.service;

import org.apache.ibatis.session.SqlSession;

import com.mysql.cj.log.Log;
import com.oracle.dao.EmpsDao;
import com.oracle.dao.LogDao;
import com.oracle.util.MybatisUtil;

public class LogService {
	public void insert(com.oracle.vo.Log log) {
		try(SqlSession session = MybatisUtil.openSession()){
			LogDao dao = session.getMapper(LogDao.class);
			dao.insert(log);
			session.commit();
		}
	}
}
