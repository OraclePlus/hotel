package cn.yisou.hotel.service;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.pojo.Room;

public interface RoomServiceH {
	public List<Room> splitQuery(int pageSize,int pageNo);
	public int getMaxPageNo(int pageSize);
	public Room findRoomByRoomid(String roomid);
	public List<Room> findRoomByLC(String lc);
	public List<Room> findRoomByState(String state);
}
