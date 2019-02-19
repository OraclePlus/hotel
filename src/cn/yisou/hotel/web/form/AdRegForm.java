package cn.yisou.hotel.web.form;

import cn.yisou.hotel.web.core.ActionForm;

public class AdRegForm extends ActionForm {
	private String adid;
	private String adpsw;
	private Integer power;


	public String getAdid() {
		return adid;
	}
	public void setAdid(String adid) {
		this.adid = adid;
	}
	public String getAdpsw() {
		return adpsw;
	}
	public void setAdpsw(String adpsw) {
		this.adpsw = adpsw;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	
	

}
