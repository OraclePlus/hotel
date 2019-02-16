package cn.yisou.hotel.dao;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.pojo.Check;
import cn.yisou.hotel.pojo.Room;

public interface RoomDao {
	public boolean updateStateByRoomid(String roomid,Integer state,Connection conn)throws Exception;
	public boolean updatePriceByType(Double price,String type,Connection conn)throws Exception;
	public boolean updateHourroomByRoomid(String roomid,String hourroom,Connection conn)throws Exception;
	public boolean addRemarkByRoomid(String roomid,String remark,Connection conn)throws Exception;
	public boolean addRoom(Room room,Connection conn)throws Exception;
	public List<Room> selectAll(Connection conn)throws Exception;
	public Room selectRoomByRoomid(String roomid,Connection conn)throws Exception;
	public List<Room> splitQuery(int pageSize,int pageNo,Connection conn)throws Exception;
	public int getMaxPageNo(int pageSize,Connection conn)throws Exception;
	public List<Room> selectRoomByLC(String lc,Connection conn)throws Exception;
	public List<Room> selectRoomByState(String state,Connection conn)throws Exception;
}
