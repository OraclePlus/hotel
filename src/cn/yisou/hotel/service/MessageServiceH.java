package cn.yisou.hotel.service;

import java.util.List;

import cn.yisou.hotel.pojo.Message;

public interface MessageServiceH {
	public boolean saveMessage(Message message);
	public List<Message> findAll();
}
