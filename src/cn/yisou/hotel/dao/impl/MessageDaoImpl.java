package cn.yisou.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yisou.hotel.dao.MessageDao;
import cn.yisou.hotel.pojo.Message;

public class MessageDaoImpl implements MessageDao{

	@Override
	public boolean addMessage(Message message, Connection conn) throws Exception {
		boolean flag=false;
		String sql="insert into message (mname,email,messages) values(?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, message.getMname());
		ps.setString(2, message.getEmail());
		ps.setString(3, message.getMessages());
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public List<Message> selectAll(Connection conn) throws Exception {
		List<Message>list=new ArrayList<Message>();
		String sql="select * from message";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Message message=new Message();
			message.setId(rs.getInt("id"));
			message.setMname(rs.getString("mname"));
			message.setEmail(rs.getString("email"));
			message.setMessages(rs.getString("messages"));
			list.add(message);
		}
		return list;
	}

}
