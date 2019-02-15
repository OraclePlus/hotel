package cn.yisou.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yisou.hotel.dao.UserDao;
import cn.yisou.hotel.pojo.User;
import sun.security.timestamp.TSRequest;

public class UserDaoImpl implements UserDao{
	@Override
	public boolean addUser(User user, Connection conn) throws Exception {
		boolean flag=false;
		String sql="insert into user (uid,name,psw,idcard,sex,utel,grade) values(?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, user.getUid());
		ps.setString(2, user.getName());
		ps.setBytes(3, user.getPsw());
		ps.setString(4, user.getIdcard());
		ps.setString(5, user.getSex());
		ps.setString(6, user.getUtel());
		ps.setString(7, user.getGrade());
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public List<User> selectAll(Connection conn) throws Exception {
		List<User>list=new ArrayList<User>();
		String sql="select * from user";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			User user=new User();
			user.setUid(rs.getString("uid"));
			user.setName(rs.getString("name"));
			user.setPsw(rs.getBytes("psw"));
			user.setIdcard(rs.getString("idcard"));
			user.setSex(rs.getString("sex"));
			user.setUtel(rs.getString("utel"));
			user.setGrade(rs.getString("grade"));
			list.add(user);
		}
		return list;
	}

	@Override
	public User selectUserByUid(String uid, Connection conn) throws Exception {
		User user=new User();
		String sql="select * from user where uid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			user.setUid(rs.getString("uid"));
			user.setName(rs.getString("name"));
			user.setPsw(rs.getBytes("psw"));
			user.setIdcard(rs.getString("idcard"));
			user.setSex(rs.getString("sex"));
			user.setUtel(rs.getString("utel"));
			user.setGrade(rs.getString("grade"));
		}
		return user;
	}

	@Override
	public boolean updateGradeByUid(String uid, String grade, Connection conn) throws Exception {
		boolean flag=false;
		String sql="update user set grade=? where uid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, grade);
		ps.setString(2, uid);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updateUtelByUid(String utel, String uid, Connection conn) throws Exception {
		boolean flag=false;
		String sql="update user set utel=? where uid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, utel);
		ps.setString(2, uid);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updatePswByUid(String uid, String psw, Connection conn) throws Exception {
		boolean flag=false;
		String sql="update user set psw=? where uid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, psw);
		ps.setString(2, uid);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public User selectUserByIdcard(String idcard, Connection conn) throws Exception {
		User user=new User();
		String sql="select * from user where idcard=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, idcard);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			user.setUid(rs.getString("uid"));
			user.setName(rs.getString("name"));
			user.setPsw(rs.getBytes("psw"));
			user.setIdcard(rs.getString("idcard"));
			user.setSex(rs.getString("sex"));
			user.setUtel(rs.getString("utel"));
			user.setGrade(rs.getString("grade"));
		}
		return user;
	}

}
