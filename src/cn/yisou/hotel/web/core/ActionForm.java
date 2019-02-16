package cn.yisou.hotel.web.core;

import java.io.Serializable;

public abstract class ActionForm implements Serializable{
	private String param;

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
}
