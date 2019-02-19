package cn.yisou.hotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yisou.hotel.dao.AdministratorDao;
import cn.yisou.hotel.pojo.Administrator;

public class AdministratorDaoImpl implements AdministratorDao{

	@Override
	public boolean addAdmini(Administrator ad, Connection conn) throws Exception {
		boolean flag=false;
		String sql="insert into administrator (id,adpsw,power) values(?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, ad.getId());
		ps.setBytes(2, ad.getAdpsw());
		ps.setInt(3, 1);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean deleteAdminiById(String id, Connection conn) throws Exception {
		boolean flag=false;
		String sql="delete from administrator where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, id);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updateAdpswById(String id, byte[] adpsw, Connection conn) throws Exception {
		boolean flag=false;
		String sql="update administrator set adpsw=? where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setBytes(1, adpsw);
		ps.setString(2, id);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean updatePowerById(String id, int power, Connection conn) throws Exception {
		boolean flag=false;
		String sql="update administrator set power=? where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, power);
		ps.setString(2, id);
		int n=ps.executeUpdate();
		if (n>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public List<Administrator> selectAll(Connection conn) throws Exception {
		List<Administrator> list =new ArrayList<Administrator>();
		String sql="select * from administrator";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Administrator ad=new Administrator();
			ad.setId(rs.getString("id"));
			ad.setAdpsw(rs.getBytes("adpsw"));
			ad.setPower(rs.getInt("power"));
			list.add(ad);
		}
		return list;
	}

	@Override
	public Administrator selectAdministratorById(String id, Connection conn) throws Exception {
		Administrator ad=new Administrator();
		String sql="select * from administrator where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			ad.setId(rs.getString("id"));
			ad.setAdpsw(rs.getBytes("adpsw"));
		}
		return ad;
	}

}
