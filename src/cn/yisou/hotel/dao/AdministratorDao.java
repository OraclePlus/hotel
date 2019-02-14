package cn.yisou.hotel.dao;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.pojo.Administrator;

public interface AdministratorDao {
	public boolean addAdmini(Administrator ad,Connection conn)throws Exception;
	public boolean deleteAdminiById(String id,Connection conn)throws Exception;
	public boolean updateAdpswById(String id,byte[] adpsw,Connection conn)throws Exception;
	public boolean updatePowerById(String id,int power,Connection conn)throws Exception;
	public List<Administrator> selectAll(Connection conn)throws Exception;
	public Administrator selectAdministratorById(String id,Connection conn)throws Exception;
}
