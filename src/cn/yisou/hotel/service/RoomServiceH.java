package cn.yisou.hotel.service;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.pojo.Room;

public interface RoomServiceH {
	public List<Room> splitQuery(int pageSize,int pageNo);
	public int getMaxPageNo(int pageSize);
}
