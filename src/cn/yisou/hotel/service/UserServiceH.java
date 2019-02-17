package cn.yisou.hotel.service;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.pojo.User;

public interface UserServiceH {
	public boolean saveUser(User user);
	public List<User> findAll() ;
	public User findUserByUid(String uid);
	public User findUserByIdcard(String idcard);
	public boolean changeGradeByUid(String uid,String grade);
	public boolean changeUtelByUid(String utel,String uid);
	public boolean changePswByUid(String uid,String psw);
	public List<User> splitQuery(int pageSize,int pageNo);
	public int getMaxPageNo(int pageSize);
	public List<User> findUserByName(String name);
	public List<User> findUserByGrade(String grade);
}
