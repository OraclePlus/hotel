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
		List<User> list = new ArrayList<User>();
		User user=new User();
		String name=request.getParameter("name");
		String uid=request.getParameter("uid");
		String grade=request.getParameter("grade");
		int maxPage=1;
		int pageNo=1;
		int pageSize = 10;
		if (name==null||uid==null||grade==null||("".equals(uid)&&"".equals(name)&&"0".equals(grade))) {
			String size = request.getParameter("userpageSize");
			  if(size!=null){
			  	pageSize = Integer.parseInt(size);
			  }
			  maxPage = us.getMaxPageNo1(pageSize);
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
			  list=us.splitQuery1(pageSize, pageNo);
		}else if (uid!=null&&!"".equals(uid)) {
			user=us.findUserByUid(uid);
			pageSize=1;
			list.add(user);
		}else if("0".equals(grade)){
			list=us.findUserByName(name);
			String size = request.getParameter("userpageSize");
			  if(size!=null){
			  	pageSize = Integer.parseInt(size);
			  }
			  int count=list.size();
			  maxPage = count%pageSize==0 ? count/pageSize : count/pageSize+1;
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
		}else  if("".equals(name)){
			list=us.findUserByGrade(grade);
			String size = request.getParameter("userpageSize");
			  if(size!=null){
			  	pageSize = Integer.parseInt(size);
			  }
			  int count=list.size();
			  maxPage = count%pageSize==0 ? count/pageSize : count/pageSize+1;
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
		}else {
			list=us.findUserByName(name);
			List<User>list2=us.findUserByGrade(grade);
			List<User>list3=new ArrayList<User>();
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list2.size(); j++) {
					if (list2.get(j).getUid().equals(list.get(i).getUid())) {
						list3.add(list2.get(j));
					}
				}
			}
			list=list3;
			String size = request.getParameter("userpageSize");
			  if(size!=null){
			  	pageSize = Integer.parseInt(size);
			  }
			  int count=list.size();
			  maxPage = count%pageSize==0 ? count/pageSize : count/pageSize+1;
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
		}
		
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
