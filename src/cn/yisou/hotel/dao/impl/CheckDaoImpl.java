package cn.yisou.hotel.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yisou.hotel.dao.CheckDao;
import cn.yisou.hotel.pojo.Check;

public class CheckDaoImpl implements CheckDao{

	@Override
	public boolean addInfo(Check check, Connection conn) throws Exception {
		boolean flag=false;
		String sql="insert into checke (number,roomid,uid,name,peoplenum,money,checktime,leavetime) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, check.getNumber());
		ps.setString(2, check.getRoomid());
		ps.setString(3, check.getUid());
		ps.setString(4, check.getName());
		ps.setInt(5, check.getPeoplenum());
		ps.setDouble(6, check.getMoney());
		ps.setDate(7,  check.getChecktime());
		ps.setDate(8, check.getLeavetime());
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean deleteInfoByNumber(String number, Connection conn) throws Exception {
		boolean flag=false;
		String sql="delete from checke where number=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, number);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public List<Check> selectAll(Connection conn) throws Exception {
		List<Check> list=new ArrayList<Check>();
		String sql="select * from checke";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Check check=new Check();
			check.setNumber(rs.getString("number"));
			check.setRoomid(rs.getString("roomid"));
			check.setUid(rs.getString("uid"));
			check.setName(rs.getString("name"));
			check.setPeoplenum(rs.getInt("peoplenum"));
			check.setMoney(rs.getDouble("money"));
			check.setChecktime(rs.getDate("checktime"));
			check.setLeavetime(rs.getDate("leavetime"));
			list.add(check);
		}
		return list;
	}

	@Override
	public boolean updateCheckTimeByNumber(Date checktime, String number, Double money, Connection conn)
			throws Exception {
		boolean flag=false;
		String sql="update checke set checktime=?,money=? where number=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setDate(1, checktime);
		ps.setDouble(2, money);
		ps.setString(3, number);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updateLeaveTimeByNumber(Date leavetime, String number, Double money, Connection conn)
			throws Exception {
		boolean flag=false;
		String sql="update checke set leavetime=?,money=? where number=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setDate(1, leavetime);
		ps.setDouble(2, money);
		ps.setString(3, number);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public Check selectCheckByNumber(String number, Connection conn) throws Exception {
		Check check=new Check();
		String sql="select * from checke where number=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, number);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			check.setNumber(rs.getString("number"));
			check.setRoomid(rs.getString("roomid"));
			check.setUid(rs.getString("uid"));
			check.setName(rs.getString("name"));
			check.setPeoplenum(rs.getInt("peoplenum"));
			check.setMoney(rs.getDouble("money"));
			check.setChecktime(rs.getDate("checktime"));
			check.setLeavetime(rs.getDate("leavetime"));
			check.setState(rs.getString("state"));
		}
		return check;
	}

	@Override
	public List<Check> splitQuery(int pageSize, int pageNo, Connection conn) throws Exception {
		List<Check> list = new ArrayList<Check>();
		String sql = "select * from checke limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNo-1)*pageSize);
		ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Check check = new Check();
			check.setNumber(rs.getString("number"));
			check.setRoomid(rs.getString("roomid"));
			check.setUid(rs.getString("uid"));
			check.setName(rs.getString("name"));
			check.setPeoplenum(rs.getInt("peoplenum"));
			check.setMoney(rs.getDouble("money"));
			check.setChecktime(rs.getDate("checktime"));
			check.setLeavetime(rs.getDate("leavetime"));
			list.add(check);
		}
		return list;
	}

	@Override
	public int getMaxPageNo(int pageSize, Connection conn) throws Exception {
		int count = 0;
		String sql = "select count(*) from checke";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		return count%pageSize==0 ? count/pageSize : count/pageSize+1;
	}

	@Override
	public List<Check> selectByUid(String uid, Connection conn) throws Exception {
		List<Check> list = new ArrayList<Check>();
		String sql = "select * from checke where uid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Check check = new Check();
			check.setNumber(rs.getString("number"));
			check.setRoomid(rs.getString("roomid"));
			check.setUid(rs.getString("uid"));
			check.setName(rs.getString("name"));
			check.setPeoplenum(rs.getInt("peoplenum"));
			check.setMoney(rs.getDouble("money"));
			check.setChecktime(rs.getDate("checktime"));
			check.setLeavetime(rs.getDate("leavetime"));
			list.add(check);
		}
		return list;
	}

}
