package cn.yisou.hotel.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yisou.hotel.pojo.User;
import cn.yisou.hotel.service.UserServiceH;
import cn.yisou.hotel.service.impl.UserServiceHImpl;


public class BlackUserSplitFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		UserServiceH us = new UserServiceHImpl();
		List<User> list = new ArrayList<User>();
		User user=new User();
		String name=request.getParameter("name");
		String uid=request.getParameter("uid");
		int maxPage=1;
		int pageNo=1;
		int pageSize = 10;
		if (name==null||uid==null||("".equals(uid)&&"".equals(name))) {
			String size = request.getParameter("blackuserpageSize");
			  if(size!=null){
			  	pageSize = Integer.parseInt(size);
			  }
			  maxPage = us.getMaxPageNo2(pageSize);
			  pageNo  = 1;
			  String no = request.getParameter("blackuserpageNo");
			  if(no!=null){
			  	pageNo = Integer.parseInt(no);
			  	if(pageNo < 1){
			  		pageNo=1;
			  	}
			  	if(pageNo > maxPage){
			  		pageNo=maxPage;
			  	}
			  }
			  list=us.splitQuery2(pageSize, pageNo);
		}else if (uid!=null&&!"".equals(uid)) {
			user=us.findUserByUid(uid);
			pageSize=1;
			list.add(user);
		}else {
			list=us.findUserByName(name);
			String size = request.getParameter("blackuserpageSize");
			  if(size!=null){
			  	pageSize = Integer.parseInt(size);
			  }
			  int count=list.size();
			  maxPage = count%pageSize==0 ? count/pageSize : count/pageSize+1;
			  pageNo  = 1;
			  String no = request.getParameter("blackuserpageNo");
			  if(no!=null){
			  	pageNo = Integer.parseInt(no);
			  	if(pageNo < 1){
			  		pageNo=1;
			  	}
			  	if(pageNo > maxPage){
			  		pageNo=maxPage;
			  	}
			  }
		}
		request.getSession().setAttribute("blackuserlist",list);
		request.getSession().setAttribute("blackuserpageNo",pageNo);
		request.getSession().setAttribute("blackusermaxPage",maxPage);
		request.getSession().setAttribute("blackuserpageSize",pageSize);
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
