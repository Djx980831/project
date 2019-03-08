package com.oracle.test;

import com.oracle.service.MessageService;
import com.oracle.vo.SendMessage;

public class Test {

	public static void main(String[] args) {
		MessageService ms = new MessageService();
		ms.DeleteSendMessage(2);
		System.out.println("ok");
	}

}
