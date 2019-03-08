package com.oracle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.oracle.vo.PageInfo;
import com.oracle.vo.SendMessage;

public interface SendMessageDao {
	public void insert(SendMessage message);
	
	public List<SendMessage> getSendMessage(@Param("empId") Integer empId);
	
	public SendMessage getMessageById(@Param("sendId") Integer sendId);
	
	public void DeleteSendMessage(@Param("sendId") Integer sendId);
	
	public void deleteSendMessages(Integer [] sendId);
	
	public List<Map<String,Object>> getSendMessages(Map<String,Object> map);
	
	public List<Map<String,Object>> getSendMessageForPage(PageInfo pageInfo,@Param("empId") Integer empId,@Param("start") int start,@Param("size") int size);
	
	public int getSCount(@Param("empId") Integer empId);
	
	public List<Map<String,Object>> getSendMessageByDy(@Param("map") Map<String,Object> map,@Param("pageInfo") PageInfo pageInfo,@Param("start") int start,@Param("size") int size);
	
	public int getSCountByDy(Map<String,Object> map);
}
