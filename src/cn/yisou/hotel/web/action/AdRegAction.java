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
import cn.yisou.hotel.web.form.AdRegForm;
import cn.yisou.hotel.web.form.RegForm;

public class AdRegAction extends DispatcherAction{
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
			throws ServletException, IOException {
		AdServiceH as=new AdServiceHImpl();
		AdRegForm adregForm=(AdRegForm)form;
		Administrator ad=new Administrator();
		ad.setId(adregForm.getAdid());
		ad.setAdpsw(GetMD5Byte.getMD5Byte(adregForm.getAdpsw()));
		System.out.println(GetMD5Byte.getMD5Byte(adregForm.getAdpsw()));
		boolean f=as.saveAd(ad);
		if (f) {
			request.getSession().setAttribute("regmsg","");
			return new ActionForward("adLogReg");
		}else{
			request.getSession().setAttribute("regmsg","×¢²áÊ§°Ü");
			return new ActionForward(true,"adLogReg");
		}
	}

}
