package cn.yisou.hotel.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yisou.hotel.pojo.Message;
import cn.yisou.hotel.service.MessageServiceH;
import cn.yisou.hotel.service.impl.MessageServiceImplH;
import cn.yisou.hotel.web.core.Action;
import cn.yisou.hotel.web.core.ActionForm;
import cn.yisou.hotel.web.core.ActionForward;
import cn.yisou.hotel.web.form.MessageForm;

public class MessageAction implements Action {
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		MessageServiceH ms=new MessageServiceImplH();
		MessageForm mForm=(MessageForm)form;
		Message message=new Message();
		message.setMname(mForm.getMname());
		message.setEmail(mForm.getE_mail());
		message.setMessages(mForm.getMessages());
		boolean f=ms.saveMessage(message);
		if (f) {
			return new ActionForward("show");
		}else {
			return new ActionForward("contact");
		}
	}

}
