package cn.yisou.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yisou.hotel.dao.RoomDao;
import cn.yisou.hotel.dao.RoomDaoZ;
import cn.yisou.hotel.pojo.Check;
import cn.yisou.hotel.pojo.Room;

public class RoomDaoImplZ implements RoomDaoZ{

	/*@Override
	public List<Room> selectAll(Connection conn) throws Exception {
		List<Room> list=new ArrayList<Room>();
		String sql="select * from room";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Room room=new Room();
			room.setRoomid(rs.getString("roomid"));
			room.setType(rs.getString("type"));
			room.setPrice(rs.getDouble("price"));
			room.setState(rs.getString("state"));
			room.setHourroom(rs.getString("hourroom"));
		    room.setPeoplenum(rs.getInt("peoplenum"));
			room.setRoomtel(rs.getString("roomtel"));
			list.add(room);
		}
		return list;
	}*/
	@Override
	public boolean updateStateByRoomid(String roomid, String state, Connection conn) throws Exception {
		boolean flag=false;
		String sql="update room set state=? where roomid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, state);
		ps.setString(2, roomid);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	public List<Room> selectRoomByRoomType(String roomType, Connection conn) throws Exception {
		List<Room> ro=new ArrayList<Room>();
		String sql="select roomid,state,price,roomtel from room where type=?";
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setString(1, roomType);
		ResultSet eq = ps.executeQuery();
		while(eq.next()) {
			Room room = new Room();
			room.setRoomid(eq.getString("roomid"));
			room.setState(eq.getString("state"));
			room.setPrice(eq.getDouble("price"));
			room.setRoomtel(eq.getString("roomtel"));
			ro.add(room);
		}
		System.out.println("room length"+ro.size());
		return ro;
	}

	public boolean updateRoomTypeByRoomid(Room room, Connection conn) throws Exception {
		String sql="update room set state=? where roomid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, room.getState());
		ps.setString(2, room.getRoomid());
		int executeUpdate = ps.executeUpdate();
		if(executeUpdate==1) {
			return true;
		}
		return false;
	}

	@Override
	public List<Room> selectRoomByState(String state, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
