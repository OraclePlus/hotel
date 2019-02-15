package cn.yisou.hotel.web.form;

import cn.yisou.hotel.web.core.ActionForm;

public class RegForm extends ActionForm{
	private String name;
	private String uid;
	private String regpassword;
	private String tel;
	private String idcard;
	private String sex;
	private String psw;
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRegpassword() {
		return regpassword;
	}
	public void setRegpassword(String regpassword) {
		this.regpassword = regpassword;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
