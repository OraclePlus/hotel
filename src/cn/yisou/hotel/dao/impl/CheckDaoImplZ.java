package cn.yisou.hotel.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yisou.hotel.dao.CheckDao;
import cn.yisou.hotel.dao.CheckDaoZ;
import cn.yisou.hotel.db.DBHelper;
import cn.yisou.hotel.pojo.Check;

public class CheckDaoImplZ implements CheckDaoZ{

	@Override
	public boolean addInfo(Check check, Connection conn) throws Exception {
		boolean flag=false;

		String sql="insert into checke (number,roomid,uid,name,peoplenum,money,checktime,leavetime,state) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, check.getNumber());
		ps.setString(2, check.getRoomid());
		ps.setString(3, check.getUid());
		ps.setString(4, check.getName());
		ps.setInt(5, check.getPeoplenum());
		ps.setDouble(6, check.getMoney());
		ps.setDate(7,  check.getChecktime());
		ps.setDate(8, check.getLeavetime());
		ps.setString(9, "Î´ÍË");
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}


}
