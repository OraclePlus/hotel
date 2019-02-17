package cn.yisou.hotel.dao;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.pojo.Room;
import cn.yisou.hotel.pojo.User;

public interface UserDao {
	public boolean addUser(User user,Connection conn)throws Exception;
	public List<User> selectAll(Connection conn) throws Exception;
	public User selectUserByUid(String uid,Connection conn)throws Exception;
	public boolean updateGradeByUid(String uid,String grade,Connection conn)throws Exception;
	public boolean updateUtelByUid(String utel,String uid,Connection conn)throws Exception;
	public boolean updatePswByUid(String uid,String psw,Connection conn)throws Exception;
	public User selectUserByIdcard(String idcard,Connection conn)throws Exception;
	public List<User> splitQuery(int pageSize,int pageNo,Connection conn)throws Exception;
	public int getMaxPageNo(int pageSize,Connection conn)throws Exception;
	public List<User> selectUserByName(String name,Connection conn) throws Exception;
	public List<User> selectUserByGrade(String grade,Connection conn) throws Exception;
}
