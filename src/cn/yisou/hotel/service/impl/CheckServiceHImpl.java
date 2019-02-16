package cn.yisou.hotel.service.impl;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.dao.CheckDao;
import cn.yisou.hotel.dao.impl.CheckDaoImpl;
import cn.yisou.hotel.db.DBHelper;
import cn.yisou.hotel.pojo.Check;
import cn.yisou.hotel.pojo.User;
import cn.yisou.hotel.service.CheckServiceH;

public class CheckServiceHImpl implements CheckServiceH{
	private CheckDao cdao=new CheckDaoImpl();
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

	@Override
	public boolean removeInfoByNumber(String number) {
		boolean flag=false;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			flag=cdao.deleteInfoByNumber(number, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public List<Check> findAll() {
		
		return null;
	}

	@Override
	public Check findCheckByNumber(String number) {
		Check check=null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			check=cdao.selectCheckByNumber(number, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return check;
	}

	@Override
	public List<Check> splitQuery(int pageSize, int pageNo) {
		List<Check> list=null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			list=cdao.splitQuery(pageSize, pageNo, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return list;
	}

	@Override
	public int getMaxPageNo(int pageSize) {
		int max=0;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			max=cdao.getMaxPageNo(pageSize, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return max;
	}

}
