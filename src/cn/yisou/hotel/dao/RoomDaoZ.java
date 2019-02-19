package cn.yisou.hotel.dao;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.pojo.Check;
import cn.yisou.hotel.pojo.Room;

public interface RoomDaoZ {
	public boolean updateStateByRoomid(String roomid,String state,Connection conn)throws Exception;
	public List<Room> selectRoomByState(String state, Connection conn)throws Exception;
	public List<Room> selectRoomByRoomType(String roomtype, Connection conn) throws Exception;
}
