package cn.yisou.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yisou.hotel.dao.RoomDao;
import cn.yisou.hotel.pojo.Room;

public class RoomDaoImpl implements RoomDao{

	@Override
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
			room.setState(rs.getInt("state"));
			room.setHourroom(rs.getString("hourroom"));
		    room.setPeoplemun(rs.getInt("peoplenum"));
			room.setRoomtel(rs.getString("roomtel"));
			list.add(room);
		}
		return list;
	}
	
	@Override
	public boolean updateStateByRoomid(String roomid, Integer state, Connection conn) throws Exception {
		boolean flag=false;
		String sql="update room set state=? where roomid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, state);
		ps.setString(2, roomid);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updatePriceByType(Double price, String type, Connection conn) throws Exception {
		boolean flag=false;
		String sql="update room set price=? where type=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setDouble(1, price);
		ps.setString(2, type);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updateHourroomByRoomid(String roomid, String hourroom, Connection conn) throws Exception {
		boolean flag=false;
		String sql="update room set hourroom=? where roomid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, hourroom);
		ps.setString(2, roomid);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean addRemarkByRoomid(String roomid, String remark, Connection conn) throws Exception {
		boolean flag=false;
		String sql="update room set remark=? where roomid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, remark);
		ps.setString(2, roomid);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean addRoom(Room room, Connection conn) throws Exception {
		boolean flag=false;
		String hourroom="no";
		String sql="insert into room (roomid,type,price,state,hourroom,peoplenum,roomtel) values(?,?,?,?,?,?,?)";
		if (room.getHourroom()!=null) {
			hourroom=room.getHourroom();
		}
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, room.getRoomid());
		ps.setString(2, room.getType());
		ps.setDouble(3, room.getPrice());
		ps.setInt(4, room.getState());
		ps.setString(5, hourroom);
		ps.setInt(6, room.getPeoplemun());
		ps.setString(7, room.getRoomtel());
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public Room selectRoomByRoomid(String roomid, Connection conn) throws Exception {
		Room room=new Room();
		String sql="select * from room where roomid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, roomid);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			room.setRoomid(rs.getString("roomid"));
			room.setType(rs.getString("type"));
			room.setPrice(rs.getDouble("price"));
			room.setState(rs.getInt("state"));
			room.setHourroom(rs.getString("hourroom"));
		    room.setPeoplemun(rs.getInt("peoplenum"));
			room.setRoomtel(rs.getString("roomtel"));
		}
		return room;
	}


}
