package cn.yisou.hotel.web.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yisou.hotel.pojo.User;
import cn.yisou.hotel.service.UserServiceH;
import cn.yisou.hotel.service.impl.UserServiceHImpl;
import cn.yisou.hotel.utils.GetMD5Byte;
import cn.yisou.hotel.utils.PrimaryKeyUUID;
import cn.yisou.hotel.web.core.ActionForm;
import cn.yisou.hotel.web.core.ActionForward;
import cn.yisou.hotel.web.core.DispatcherAction;
import cn.yisou.hotel.web.form.RegForm;

public class RegAction extends DispatcherAction{
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		UserServiceH us=new UserServiceHImpl();
		RegForm regForm=(RegForm)form;
		User user=new User();
		user.setUid(regForm.getUid());
		user.setName(regForm.getName());
		user.setPsw(GetMD5Byte.getMD5Byte(regForm.getRegpassword()));
		user.setUtel(regForm.getTel());
		user.setGrade("vip0");
		user.setIdcard(regForm.getIdcard());
		user.setSex(regForm.getSex());
		boolean f=us.saveUser(user);
		if (f) {
			request.getSession().setAttribute("regmsg","");
			return new ActionForward("register");
		}else{
			request.getSession().setAttribute("regmsg","×¢²áÊ§°Ü");
			return new ActionForward(true,"register");
		}
	}
}
