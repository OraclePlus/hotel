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
import cn.yisou.hotel.web.form.AdLogForm;
import cn.yisou.hotel.web.form.LogForm;

public class AdLogAction extends DispatcherAction{
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		UserServiceH us=new UserServiceHImpl();
		AdServiceH as=new AdServiceHImpl();
		AdLogForm adlogForm=(AdLogForm)form;
		System.out.println(adlogForm.getAdid());
		Administrator ad=as.findUserById(adlogForm.getAdid());
		if (ad.getId()!=null) {
			byte[] pass=ad.getAdpsw();
			byte[] pass1=GetMD5Byte.getMD5Byte(adlogForm.getAdlogpassword());
			boolean f=GetMD5Byte.isMD5Equals(pass, pass1);
			
			if (f) {
				System.out.println(f);
				return new ActionForward("hotel_index");
				
			}else {
				request.getSession().setAttribute("logmsg","密码错误");
				return new ActionForward(true,"adLogReg");
			}
		}else {
			System.out.println(5555);
			request.getSession().setAttribute("logmsg","没有此用户");
			return new ActionForward(true,"adLogReg");
		}
	}
}
