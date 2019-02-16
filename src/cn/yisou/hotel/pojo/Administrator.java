package cn.yisou.hotel.pojo;

import java.io.Serializable;

public class Administrator implements Serializable{
	private String id;
	private byte[] adpsw;
	private Integer power;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte[] getAdpsw() {
		return adpsw;
	}
	public void setAdpsw(byte[] adpsw) {
		this.adpsw = adpsw;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	
}
