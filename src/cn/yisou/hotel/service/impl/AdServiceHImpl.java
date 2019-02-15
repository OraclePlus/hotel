package cn.yisou.hotel.service.impl;

import java.sql.Connection;

import cn.yisou.hotel.dao.AdministratorDao;
import cn.yisou.hotel.dao.impl.AdministratorDaoImpl;
import cn.yisou.hotel.db.DBHelper;
import cn.yisou.hotel.pojo.Administrator;
import cn.yisou.hotel.pojo.User;
import cn.yisou.hotel.service.AdServiceH;

public class AdServiceHImpl implements AdServiceH{
	private AdministratorDao addao=new AdministratorDaoImpl();
	@Override
	public boolean saveAd(Administrator ad) {
		boolean flag=false;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			flag=addao.addAdmini(ad, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return flag;
	}

	@Override
	public Administrator findUserById(String id) {
		Administrator ad=null;
		Connection conn=DBHelper.getConnection();
		try {
			conn.setAutoCommit(false);
			ad=addao.selectAdministratorById(id, conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConnection(conn);
		}
		return ad;
	}
}
