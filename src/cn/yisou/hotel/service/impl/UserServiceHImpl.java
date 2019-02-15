package cn.yisou.hotel.service.impl;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.dao.UserDao;
import cn.yisou.hotel.dao.impl.UserDaoImpl;
import cn.yisou.hotel.db.DBHelper;
import cn.yisou.hotel.pojo.User;
import cn.yisou.hotel.service.UserServiceH;

public class UserServiceHImpl implements UserServiceH{
	private UserDao udao=new UserDaoImpl();
	@Override
	public boolean saveUser(User user) {
		boolean flag=false;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			flag=udao.addUser(user, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUid(String uid) {
		User user=null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			user=udao.selectUserByUid(uid, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return user;
	}

	@Override
	public boolean changeGradeByUid(String uid, String grade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeUtelByUid(String utel, String uid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePswByUid(String uid, String psw) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findUserByIdcard(String idcard) {
		User user=null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			user=udao.selectUserByIdcard(idcard, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return user;
	}

}
