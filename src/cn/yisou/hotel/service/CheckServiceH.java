package cn.yisou.hotel.service;

import java.sql.Connection;
import java.util.List;

import cn.yisou.hotel.pojo.Check;

public interface CheckServiceH {
	public boolean saveInfo(Check check);
	public boolean removeInfoByNumber(String number);
	public List<Check> findAll();
	public Check findCheckByNumber(String number);
	public List<Check> splitQuery1(int pageSize,int pageNo);
	public int getMaxPageNo1(int pageSize);
	public List<Check> splitQuery2(int pageSize,int pageNo);
	public int getMaxPageNo2(int pageSize);
	public List<Check> findByUid(String uid);
	public boolean  changeStateByNumber(String number,String state);
}
