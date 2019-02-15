package cn.yisou.hotel.web.form;

import cn.yisou.hotel.web.core.ActionForm;

public class LogForm extends ActionForm{
	private String userid;
	private String logpassword;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLogpassword() {
		return logpassword;
	}
	public void setLogpassword(String logpassword) {
		this.logpassword = logpassword;
	}
	
}
