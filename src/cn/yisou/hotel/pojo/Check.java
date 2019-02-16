package cn.yisou.hotel.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Check implements Serializable{
	private String number;
	private String roomid;
	private String uid;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Date checktime;
	private Date leavetime;
	private Integer peoplenum;
	private Double money;
	private String state;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Date getChecktime() {
		return checktime;
	}
	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}
	public Date getLeavetime() {
		return leavetime;
	}
	public void setLeavetime(Date leavetime) {
		this.leavetime = leavetime;
	}
	public Integer getPeoplenum() {
		return peoplenum;
	}
	public void setPeoplenum(Integer peoplenum) {
		this.peoplenum = peoplenum;
	}
	
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
