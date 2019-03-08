package com.oracle.vo;

import java.sql.Date;
import java.util.List;

public class SendMessage {
	Integer sendId;
	Integer empId;
	String messageTitle;
	String messageContent;
	Date createDate;
	Integer priority;
	Integer messageState;
	
	List<ReceiveMessage> list;
	
	public List<ReceiveMessage> getList() {
		return list;
	}
	public void setList(List<ReceiveMessage> list) {
		this.list = list;
	}
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getMessageState() {
		return messageState;
	}
	public void setMessageState(Integer messageState) {
		this.messageState = messageState;
	}
	@Override
	public String toString() {
		return "SendMessage [sendId=" + sendId + ", empId=" + empId + ", messageTitle=" + messageTitle
				+ ", messageContent=" + messageContent + ", createDate=" + createDate + ", priority=" + priority
				+ ", messageState=" + messageState + ", list=" + list + "]";
	}
	
	
}
