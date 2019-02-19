package cn.yisou.hotel.web.form;

import cn.yisou.hotel.web.core.ActionForm;

public class OkForm extends ActionForm {
	private String adult;
	private String child;
	private String roomtype;
	private String inhotel;
	private String outhotel;
	private String gender;
	private String Pd_FrpId;
	public String getPd_FrpId() {
		return Pd_FrpId;
	}
	public void setPd_FrpId(String pd_FrpId) {
		Pd_FrpId = pd_FrpId;
	}
	private String uname;
	private String idcard;
	private String email;
	private String tel;
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getAdult() {
		return adult;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
	public String getInhotel() {
		return inhotel;
	}
	public void setInhotel(String inhotel) {
		this.inhotel = inhotel;
	}
	public String getOuthotel() {
		return outhotel;
	}
	public void setOuthotel(String outhotel) {
		this.outhotel = outhotel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
