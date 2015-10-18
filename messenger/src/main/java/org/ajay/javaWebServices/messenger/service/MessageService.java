package org.ajay.javaWebServices.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ajay.javaWebServices.messenger.database.DatabaseClass;
import org.ajay.javaWebServices.messenger.model.Message;

public class MessageService {

	private static Map<Long, Message> messages= DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1,"Hello World!", "Ajay"));
		messages.put(2L, new Message(2,"Hello Jersey!", "Ajay"));
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0)
		return null;
		
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessages(long id) {
		
		return messages.remove(id);
	}
//	{
//		Message m1 = new Message(1L, "Hello World!", "Ajay");
//		Message m2 = new Message(1L, "Hello Jersey!", "Ajay");
//		Message m3 = new Message(1L, "Hello New York!", "Ajay");
//		Message m4 = new Message(1L, "Hello California!", "Ajay");
//
//		List<Message> list = new ArrayList<>();
//		list.add(m1);
//		list.add(m2);
//		list.add(m3);
//		list.add(m4);
//
//		return list;
//
//	}

}
