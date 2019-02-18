package cn.yisou.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yisou.hotel.dao.RoomDao;
import cn.yisou.hotel.pojo.Check;
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
			room.setState(rs.getString("state"));
			room.setHourroom(rs.getString("hourroom"));
		    room.setPeoplenum(rs.getInt("peoplenum"));
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
		ps.setString(4, room.getState());
		ps.setString(5, hourroom);
		ps.setInt(6, room.getPeoplenum());
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
			room.setState(rs.getString("state"));
			room.setHourroom(rs.getString("hourroom"));
		    room.setPeoplenum(rs.getInt("peoplenum"));
			room.setRoomtel(rs.getString("roomtel"));
		}
		return room;
	}

	@Override
	public List<Room> splitQuery(int pageSize, int pageNo, Connection conn) throws Exception {
		List<Room> list = new ArrayList<Room>();
		String sql = "select * from room limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNo-1)*pageSize);
		ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Room room = new Room();
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
	}

	@Override
	public int getMaxPageNo(int pageSize, Connection conn) throws Exception {
		int count = 0;
		String sql = "select count(*) from room";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count%pageSize==0 ? count/pageSize : count/pageSize+1;
	}

	@Override
	public List<Room> selectRoomByLC(String lc, Connection conn) throws Exception {
		List<Room> list=new ArrayList<Room>();
		String sql="select * from room where roomid like ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, lc+"%");
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Room room = new Room();
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
	}

	@Override
	public List<Room> selectRoomByState(String state, Connection conn) throws Exception {
		List<Room> list=new ArrayList<Room>();
		String sql="select * from room where state = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, state);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			Room room = new Room();
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
	}

	
	/**
	 * 查找所有房间类型
	 */
	@Override
	public List<Room> selectAllRoomType(Connection conn) throws Exception {
		List<Room> list=new ArrayList<Room>();
		String sql="SELECT *,count(type) FROM room WHERE state='可入住' GROUP BY type ORDER BY price DESC";
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
			room.setCount(rs.getInt("count(type)"));
			room.setPhoto(rs.getString("photo"));
			list.add(room);
		}
		return list;
	}


}
