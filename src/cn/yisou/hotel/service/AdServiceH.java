package cn.yisou.hotel.service;

import cn.yisou.hotel.pojo.Administrator;

public interface AdServiceH {
	public boolean saveAd(Administrator ad);
	public Administrator findUserById(String id);
}
