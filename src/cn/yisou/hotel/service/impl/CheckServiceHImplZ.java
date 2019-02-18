package cn.yisou.hotel.service.impl;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.dao.CheckDao;
import cn.yisou.hotel.dao.CheckDaoZ;
import cn.yisou.hotel.dao.impl.CheckDaoImplZ;
import cn.yisou.hotel.db.DBHelper;
import cn.yisou.hotel.pojo.Check;
import cn.yisou.hotel.pojo.User;
import cn.yisou.hotel.service.CheckServiceH;
import cn.yisou.hotel.service.CheckServiceZ;

public class CheckServiceHImplZ implements CheckServiceZ{
	private CheckDaoZ cdao=new CheckDaoImplZ();
	@Override
	public boolean saveInfo(Check check) {
		boolean flag=false;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			flag=cdao.addInfo(check, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

}
