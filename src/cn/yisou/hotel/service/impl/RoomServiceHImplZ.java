package cn.yisou.hotel.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.yisou.hotel.dao.RoomDao;
import cn.yisou.hotel.dao.RoomDaoZ;
import cn.yisou.hotel.dao.impl.RoomDaoImplZ;
import cn.yisou.hotel.db.DBHelper;
import cn.yisou.hotel.pojo.Check;
import cn.yisou.hotel.pojo.Room;
import cn.yisou.hotel.service.RoomServiceH;
import cn.yisou.hotel.service.RoomServiceZ;

public class RoomServiceHImplZ implements RoomServiceZ{
	private RoomDaoZ rdao=new RoomDaoImplZ();
	
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

	/*@Override
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
*/
	@Override
	public Room findRoomByType(String roomtype) {
		System.out.println("11111111"+roomtype);
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Room> selectRoomByState;
		try {
			selectRoomByState = rdao.selectRoomByRoomType(roomtype,conn);
			System.out.println("selectRoomByState"+selectRoomByState.size());
			
			for (Room room : selectRoomByState) {
				System.out.println(room.getRoomid()+"11111111111");
				System.out.println(room.getState());
				if(room.getState().equals("可入住")) {
				System.out.println(room.getState());
				if(rdao.updateStateByRoomid(room.getRoomid(), "已入住", conn)) {
					System.out.println("I`m hero");
					conn.commit();
					return room;
				}
				}else {
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		
		return null;
	}

}
