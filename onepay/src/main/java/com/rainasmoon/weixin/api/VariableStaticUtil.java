package com.rainasmoon.weixin.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class VariableStaticUtil {
	private static HashMap<String, Long> event = new HashMap<String, Long>();
	private static HashSet<Long> message = new HashSet<Long>();
	private final static int SIZE_MAX = 10000;
	private final static int SIZE_MAX1 = 20000;

	public static HashMap<String, Long> getEvent() {
		return event;
	}

	public static void setEvent(HashMap<String, Long> event) {
		VariableStaticUtil.event = event;
	}

	public static HashSet<Long> getMessage() {
		return message;
	}

	public static void setMessage(HashSet<Long> message) {
		VariableStaticUtil.message = message;
	}

	public static int getSizeMax() {
		return SIZE_MAX;
	}

	public static int getSizeMax1() {
		return SIZE_MAX1;
	}

	public static boolean addEvent(String FromUserName, Long CreateTime) {

		if (event.containsKey(FromUserName)) {
			if (event.get(FromUserName) == CreateTime)
				return false;
			else
				event.put(FromUserName, CreateTime);

		} else {
			if (event.size() > SIZE_MAX)
				event.clear();

			event.put(FromUserName, CreateTime);
		}
		return true;

	}

	public static void removeEvent(String FromUserName) {

		event.remove(FromUserName);

	}

	public static boolean addMessage(Long MsgId) {
		if (message.contains(MsgId))
			return false;
		else {
			if (message.size() > SIZE_MAX1)
				message.clear();
			message.add(MsgId);
			return true;
		}

	}

	public static void removeMessage(Long MsgId) {
		message.remove(MsgId);
	}

}
