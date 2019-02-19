package cn.yisou.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import cn.yisou.hotel.pojo.Check;

public interface CheckDaoZ {
	public boolean addInfo(Check check,Connection conn )throws Exception;
	
}
