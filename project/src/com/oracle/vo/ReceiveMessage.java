package com.oracle.vo;

import java.sql.Date;

public class ReceiveMessage {
	Integer receiveId;
	Integer sendId;
	Integer empId;
	Integer mseeageState;
	Date openDate;
	
	Emp receiver;
	
	
	
	public Emp getReceiver() {
		return receiver;
	}
	public void setReceiver(Emp receiver) {
		this.receiver = receiver;
	}
	public Integer getReceiveId() {
		return receiveId;
	}
	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
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
	public Integer getMseeageState() {
		return mseeageState;
	}
	public void setMseeageState(Integer mseeageState) {
		this.mseeageState = mseeageState;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	@Override
	public String toString() {
		return "ReceiveMessage [receiveId=" + receiveId + ", sendId=" + sendId + ", empId=" + empId + ", mseeageState="
				+ mseeageState + ", openDate=" + openDate + ", receiver=" + receiver + "]";
	}
	
	
}
