package cn.yisou.hotel.service.impl;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.dao.MessageDao;
import cn.yisou.hotel.dao.impl.MessageDaoImpl;
import cn.yisou.hotel.db.DBHelper;
import cn.yisou.hotel.pojo.Message;
import cn.yisou.hotel.service.MessageServiceH;

public class MessageServiceImplH implements MessageServiceH{
	MessageDao mdao=new MessageDaoImpl();
	@Override
	public boolean saveMessage(Message message) {
		boolean flag=false;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			flag=mdao.addMessage(message, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public List<Message> findAll() {
		List<Message> list=null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			list=mdao.selectAll(conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return list;
	}

}
