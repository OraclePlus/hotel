package cn.yisou.hotel.pojo;

import java.util.Date;

public class Room {
	private String roomid;
	private String type;
	private Double price;
	private Integer state;
	private String hourroom;
	private Integer peoplemun;
	private String roomtel;
	private String delete;
	private String remark;
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getHourroom() {
		return hourroom;
	}
	public void setHourroom(String hourroom) {
		this.hourroom = hourroom;
	}
	public Integer getPeoplemun() {
		return peoplemun;
	}
	public void setPeoplemun(Integer peoplemun) {
		this.peoplemun = peoplemun;
	}
	public String getRoomtel() {
		return roomtel;
	}
	public void setRoomtel(String roomtel) {
		this.roomtel = roomtel;
	}
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
