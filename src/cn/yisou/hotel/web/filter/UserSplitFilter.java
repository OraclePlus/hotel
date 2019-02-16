package cn.yisou.hotel.web.filter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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


public class UserSplitFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		UserServiceH us = new UserServiceHImpl();
		List<User> list = null;
		int maxPage=0;
		int pageNo=0;
		int pageSize = 10;
		String size = request.getParameter("userpageSize");
		  if(size!=null){
		  	pageSize = Integer.parseInt(size);
		  }
		  maxPage = us.getMaxPageNo(pageSize);
		  pageNo  = 1;
		  String no = request.getParameter("userpageNo");
		  if(no!=null){
		  	pageNo = Integer.parseInt(no);
		  	if(pageNo < 1){
		  		pageNo=1;
		  	}
		  	if(pageNo > maxPage){
		  		pageNo=maxPage;
		  	}
		  }
		list  = us.splitQuery(pageSize,pageNo);
		request.getSession().setAttribute("userlist",list);
		request.getSession().setAttribute("userpageNo",pageNo);
		request.getSession().setAttribute("usermaxPage",maxPage);
		request.getSession().setAttribute("userpageSize",pageSize);
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
