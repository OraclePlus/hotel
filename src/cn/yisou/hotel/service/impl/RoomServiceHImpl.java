package cn.yisou.hotel.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
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

	@Override
	public List<Room> findRoomByLC(String lc) {
		List<Room> list=null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			list=rdao.selectRoomByLC(lc, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	@Override
	public List<Room> findRoomByState(String state) {
		List<Room> list=null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			list=rdao.selectRoomByState(state, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	@Override
	public Room findRoomByRoomid(String roomid) {
		Room room=null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			room=rdao.selectRoomByRoomid(roomid, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return room;
	}

	/**
	 * 查找所有房间
	 */
	@Override
	public List<Room> findAll() {
		List<Room> list = null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			list = rdao.selectAll(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	
	/**
	 * 查找所有房间类型
	 */
	@Override
	public List<Room> findAllRoomType() {
		List<Room> list = null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			list = rdao.selectAllRoomType(conn);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return list;
	}

}
