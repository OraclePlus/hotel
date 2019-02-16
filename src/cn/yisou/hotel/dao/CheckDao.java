package cn.yisou.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import cn.yisou.hotel.pojo.Check;

public interface CheckDao {
	public boolean addInfo(Check check,Connection conn )throws Exception;
	public boolean deleteInfoByNumber(String number,Connection conn)throws Exception;
	public List<Check> selectAll(Connection conn)throws Exception;
	public Check selectCheckByNumber(String number ,Connection conn)throws Exception;
	public boolean updateCheckTimeByNumber(Date checktime,String number,Double money,Connection conn)throws Exception;
	public boolean updateLeaveTimeByNumber(Date leavetime,String number,Double money,Connection conn)throws Exception;
	public List<Check> splitQuery(int pageSize,int pageNo,Connection conn)throws Exception;
	public int getMaxPageNo(int pageSize,Connection conn)throws Exception;
}
