package cn.yisou.hotel.service.impl;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.dao.RoomDao;
import cn.yisou.hotel.dao.impl.RoomDaoImpl;
import cn.yisou.hotel.db.DBHelper;
import cn.yisou.hotel.pojo.Check;
import cn.yisou.hotel.pojo.Room;
import cn.yisou.hotel.service.RoomServiceH;

public class RoomServiceHImpl implements RoomServiceH{
	private RoomDao rdao=new RoomDaoImpl();
	@Override
	public List<Room> splitQuery(int pageSize, int pageNo) {
		List<Room> list=null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			list=rdao.splitQuery(pageSize, pageNo, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	@Override
	public int getMaxPageNo(int pageSize) {
		int max=0;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			max=rdao.getMaxPageNo(pageSize, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return max;
	}

}
