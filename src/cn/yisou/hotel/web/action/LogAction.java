package cn.yisou.hotel.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yisou.hotel.pojo.Administrator;
import cn.yisou.hotel.pojo.User;
import cn.yisou.hotel.service.AdServiceH;
import cn.yisou.hotel.service.UserServiceH;
import cn.yisou.hotel.service.impl.AdServiceHImpl;
import cn.yisou.hotel.service.impl.UserServiceHImpl;
import cn.yisou.hotel.utils.GetMD5Byte;
import cn.yisou.hotel.web.core.ActionForm;
import cn.yisou.hotel.web.core.ActionForward;
import cn.yisou.hotel.web.core.DispatcherAction;
import cn.yisou.hotel.web.form.LogForm;

public class LogAction extends DispatcherAction{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		UserServiceH us=new UserServiceHImpl();
		AdServiceH as=new AdServiceHImpl();
		LogForm logForm=(LogForm)form;
		User user=us.findUserByUid(logForm.getUserid());
		Administrator ad=as.findUserById(logForm.getUserid());
		User user2=us.findUserByIdcard(logForm.getUserid());
		if (user.getUid()!=null) {
			byte[] pass=user.getPsw();//查出当前的user信息
			String grade=user.getGrade();
			byte[] pass1=GetMD5Byte.getMD5Byte(logForm.getLogpassword());
			boolean f=GetMD5Byte.isMD5Equals(pass, pass1);
			if ("vip-1".equals(grade)) {
				request.getSession().setAttribute("logmsg","此人已被拉黑，无法登录");
				return new ActionForward(true,"register");
			}
			if (f) {
				request.getSession().setAttribute("logmsg","");
				request.getSession().setAttribute("user", user);
				return new ActionForward("show");
			}else {
				request.getSession().setAttribute("logmsg","密码错误");
				return new ActionForward(true,"register");
			}
		}else if(user2.getUid()!=null) {
			byte[] pass=user2.getPsw();//查出当前的user信息
			String grade=user2.getGrade();
			byte[] pass1=GetMD5Byte.getMD5Byte(logForm.getLogpassword());
			boolean f=GetMD5Byte.isMD5Equals(pass, pass1);
			if ("vip-1".equals(grade)) {
				request.getSession().setAttribute("logmsg","此人已被拉黑，无法登录");
				return new ActionForward(true,"register");
			}
			if (f) {
				request.getSession().setAttribute("logmsg","");
				request.getSession().setAttribute("user", user);
				return new ActionForward("show");
			}else {
				request.getSession().setAttribute("logmsg","密码错误");
				return new ActionForward(true,"register");
			}
		}else{
			request.getSession().setAttribute("logmsg","没有此用户");
			return new ActionForward(true,"register");
		}
		
	}
		
}
