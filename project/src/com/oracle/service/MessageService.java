package com.oracle.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.oracle.dao.ReceiveMessageDao;
import com.oracle.dao.SendMessageDao;
import com.oracle.util.MybatisUtil;
import com.oracle.vo.PageInfo;
import com.oracle.vo.ReceiveMessage;
import com.oracle.vo.SendMessage;

public class MessageService {
	
	/**
	 * 发送消息
	 * @param message
	 * @param emps
	 */
	
	public void sendMessage(SendMessage message,Integer []emps) {
		
		try(SqlSession session = MybatisUtil.openSession()){
			SendMessageDao sdao = session.getMapper(SendMessageDao.class);
			ReceiveMessageDao rdao = session.getMapper(ReceiveMessageDao.class);
			
			sdao.insert(message);
			
			for(Integer ids : emps) {
				ReceiveMessage rm = new ReceiveMessage();
				rm.setSendId(message.getSendId());
				rm.setEmpId(ids);
				rdao.insert(rm);
			}
			session.commit();
		}
	}
	
	/**
	 * 获得empId发送的消息
	 * @param empId
	 * @return
	 */
	
	public List<SendMessage> getSendMessage(Integer empId){
		List<SendMessage> list = new ArrayList<SendMessage>();
		try(SqlSession session = MybatisUtil.openSession()){
			SendMessageDao sdao = session.getMapper(SendMessageDao.class);
			list = sdao.getSendMessage(empId);
		}
		return list;
	}
	
	/**
	 * 根据sendId查询发送消息
	 * @param sendId
	 * @return
	 */
	public SendMessage getMessageById(Integer sendId) {
		SendMessage message = null;
		try(SqlSession session = MybatisUtil.openSession()){
			SendMessageDao sdao = session.getMapper(SendMessageDao.class);
			message = sdao.getMessageById(sendId);
		}
		return message;
	}
	
	/**
	 * 根据sendId删除发件箱消息
	 * @param sendId
	 */
	
	public void DeleteSendMessage(Integer sendId) {
		try(SqlSession session = MybatisUtil.openSession()){
			SendMessageDao sdao = session.getMapper(SendMessageDao.class);
			sdao.DeleteSendMessage(sendId);
			session.commit();
		}
	}
	
	/**
	 * 根据empId查询接收到的消息
	 * @param empId
	 * @return
	 */
	
	public List<Map<String,Object>> getReceiveMessage(@Param("empId") Integer empId){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try(SqlSession session = MybatisUtil.openSession()){
			ReceiveMessageDao rdao = session.getMapper(ReceiveMessageDao.class);
			list = rdao.getReceiveMessage(empId);
		}
		return list;
	}
	
	/**
	 * 根据sendId更新消息查看的时间
	 * @param receiveId
	 */
	
	public void updateOpenDate(Integer receiveId) {
		try(SqlSession session = MybatisUtil.openSession()){
			ReceiveMessageDao rdao = session.getMapper(ReceiveMessageDao.class);
			rdao.updateOpenDate(receiveId);
			session.commit();
		}
	}
	
	/**
	 * 根据receiveId查询收到的消息
	 * @param receiveId
	 * @return
	 */
	
	public Map<String,Object> getReceiveMessageById(Integer receiveId){
		Map<String,Object> oneRMessage = new HashMap<String,Object>();
		try(SqlSession session = MybatisUtil.openSession()){
			ReceiveMessageDao rdao = session.getMapper(ReceiveMessageDao.class);
			oneRMessage = rdao.getReceiveMessageById(receiveId);
		}
		return oneRMessage;
	}
	
	/**
	 * 根据receiveId删除收件箱信息
	 * @param receiveId
	 */
	
	public void DeleteReceiveMessage(Integer receiveId) {
		try(SqlSession session = MybatisUtil.openSession()){
			ReceiveMessageDao rdao = session.getMapper(ReceiveMessageDao.class);
			rdao.deleteReceiveMessage(receiveId);
			session.commit();
		}
	}
	
	/**
	 * 根据receiveId删除选中的消息
	 * @param receiveId
	 */
	
	public void DeleteReceiveMessages(Integer []receiveId) {
		try(SqlSession session = MybatisUtil.openSession()){
			ReceiveMessageDao rdao = session.getMapper(ReceiveMessageDao.class);
			rdao.deleteReceiveMessages(receiveId);
			session.commit();
		}
	}
	
	/**
	 * 根据sendid删除消息
	 * @param sendId
	 */
	
	public void DeleteSendMessages(Integer []sendId) {
		try(SqlSession session = MybatisUtil.openSession()){
			SendMessageDao sdao = session.getMapper(SendMessageDao.class);
			sdao.deleteSendMessages(sendId);
			session.commit();
		}
	}
	
	/**
	 * 动态条件查询收件箱
	 * @param map
	 * @return
	 */
	
	public List<Map<String,Object>> getReceiveMessages(Map<String,Object> map){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try(SqlSession session = MybatisUtil.openSession()){
			ReceiveMessageDao rdao = session.getMapper(ReceiveMessageDao.class);
			list = rdao.getReceiveMessages(map);
		}
		return list;
	}
	
	/**
	 * 动态条件查询发件箱
	 * @param map
	 * @return
	 */
	
	public List<Map<String,Object>> getSendMessages(Map<String,Object> map){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try(SqlSession session = MybatisUtil.openSession()){
			SendMessageDao sdao = session.getMapper(SendMessageDao.class);
			list = sdao.getSendMessages(map);
		}
		return list;
	}
	
	/**
	 * 分页查询收件箱,获得总记录数
	 * @param pageInfo
	 * @return
	 */
	
	public void getReceiveMessageForPage(PageInfo pageInfo,Integer empId,int start,int size){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try(SqlSession session = MybatisUtil.openSession()){
			ReceiveMessageDao rdao = session.getMapper(ReceiveMessageDao.class);
			int pageSize = pageInfo.getPageSize();
			 
			list = rdao.getReceiveMessageForPage(pageInfo,empId,start,size);
			pageInfo.setList(list);
			System.out.println("----当前页数："+pageInfo.getCurrentPage());
			
			Long count = (long) rdao.getRCount(empId);
			pageInfo.setRecordCount(count.intValue());
		}
		
	}
	
	/**
	 * 分页查询发件箱，查出总记录
	 * @param pageInfo
	 * @param empId
	 * @param start
	 * @param size
	 */
	
	public void getSendMessageForPage(PageInfo pageInfo,Integer empId,int start,int size){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try(SqlSession session = MybatisUtil.openSession()){
			SendMessageDao sdao = session.getMapper(SendMessageDao.class);
			
			int pageSize = pageInfo.getPageSize();
			 
			list = sdao.getSendMessageForPage(pageInfo, empId, start, pageSize);
			pageInfo.setList(list);
			System.out.println("----当前页数："+pageInfo.getCurrentPage());
			
			Long count = (long) sdao.getSCount(empId);
			pageInfo.setRecordCount(count.intValue());
		}
		
	}
	
	
	/**
	 * 动态查询收件箱，分页
	 * @param map
	 * @param pageInfo
	 * @param empId
	 * @param start
	 * @param size
	 */
	
	public void getReceiveMessageForPageByDy(Map<String,Object> map,PageInfo pageInfo,int start,int size){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try(SqlSession session = MybatisUtil.openSession()){
			ReceiveMessageDao rdao = session.getMapper(ReceiveMessageDao.class);
			
		    size = pageInfo.getPageSize();
			 
			list = rdao.getReceiveMessageByDy(map,pageInfo,start,size);
			
			pageInfo.setList(list);
			
			Long count = (long) rdao.getRCountByDy(map);
			pageInfo.setRecordCount(count.intValue());
		}	
	}
	
	/**
	 * 动态查询发件箱，分页
	 * @param map
	 * @param pageInfo
	 * @param start
	 * @param size
	 */
	
	public void getSendMessageForPageByDy(Map<String,Object> map,PageInfo pageInfo,int start,int size){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try(SqlSession session = MybatisUtil.openSession()){
			SendMessageDao sdao = session.getMapper(SendMessageDao.class);
			
		    size = pageInfo.getPageSize();
			 
			list = sdao.getSendMessageByDy(map,pageInfo,start,size);
			
			pageInfo.setList(list);
			
			Long count = (long) sdao.getSCountByDy(map);
			pageInfo.setRecordCount(count.intValue());
			System.out.println("分页查询总记录数："+count);
			pageInfo.setRecordCount(count.intValue());
		}	
	}
	
	
}
