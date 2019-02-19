package cn.yisou.hotel.dao;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.pojo.Message;

public interface MessageDao {
	public boolean addMessage(Message message,Connection conn)throws Exception;
	public List<Message> selectAll(Connection conn)throws Exception;
	
}
