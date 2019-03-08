package com.oracle.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.oracle.vo.PageInfo;
import com.oracle.vo.ReceiveMessage;

public interface ReceiveMessageDao {
	
	public void insert(ReceiveMessage message);
	
	public List<Map<String,Object>> getReceiveMessage(@Param("empId") Integer empId);
	
	public void updateOpenDate(@Param("receiveId") Integer receiveId);
	
	public Map<String,Object> getReceiveMessageById(@Param("receiveId") Integer receiveId);
	
	public void deleteReceiveMessage(@Param("receiveId") Integer receiveId);
	
	public void deleteReceiveMessages(Integer [] receiveId);
	
	public List<Map<String,Object>> getReceiveMessages(Map<String,Object> map);
	
	public List<Map<String,Object>> getReceiveMessageForPage(PageInfo pageInfo,@Param("empId") Integer empId,@Param("start") int start,@Param("size") int size);
	
	public int getRCount(@Param("empId") Integer empId);
	
    public List<Map<String,Object>> getReceiveMessageByDy(@Param("map") Map<String,Object> map,@Param("pageInfo") PageInfo pageInfo,@Param("start") int start,@Param("size") int size);
    
    public int getRCountByDy(Map<String,Object> map);
	
}