package cn.yisou.hotel.service;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.pojo.Room;

public interface RoomServiceZ {
	public List<Room> findRoomByState(String state);
	public Room findRoomByType(String roomtype);
	public int  findRoomNumByType(String roomtype);
}
