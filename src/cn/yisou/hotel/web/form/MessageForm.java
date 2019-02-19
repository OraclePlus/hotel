package cn.yisou.hotel.web.form;

import cn.yisou.hotel.web.core.ActionForm;

public class MessageForm extends ActionForm{
	private String mname;
	private String e_mail;
	private String messages;
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	
}
