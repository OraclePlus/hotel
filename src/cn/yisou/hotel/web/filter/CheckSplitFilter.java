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

import cn.yisou.hotel.pojo.Check;
import cn.yisou.hotel.pojo.User;
import cn.yisou.hotel.service.CheckServiceH;
import cn.yisou.hotel.service.UserServiceH;
import cn.yisou.hotel.service.impl.CheckServiceHImpl;
import cn.yisou.hotel.service.impl.UserServiceHImpl;


public class CheckSplitFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		CheckServiceH cs=new CheckServiceHImpl();
		List<Check> list = new ArrayList<Check>();
		String uid=request.getParameter("uid");
		int maxPage=1;
		int pageNo=1;
		int pageSize = 10;
		if (uid==null||"".equals(uid)){
			String size = request.getParameter("checkpageSize");
			  if(size!=null){
			  	pageSize = Integer.parseInt(size);
			  }
			  maxPage = cs.getMaxPageNo(pageSize);
			  pageNo  = 1;
			  String no = request.getParameter("checkpageNo");
			  if(no!=null){
			  	pageNo = Integer.parseInt(no);
			  	if(pageNo < 1){
			  		pageNo=1;
			  	}
			  	if(pageNo > maxPage){
			  		pageNo=maxPage;
			  	}
			  }
			  list=cs.splitQuery(pageSize, pageNo);
		}else {
			list=cs.findByUid(uid);
			String size = request.getParameter("checkpageSize");
			  if(size!=null){
			  	pageSize = Integer.parseInt(size);
			  }
			  int count=list.size();
			  maxPage = count%pageSize==0 ? count/pageSize : count/pageSize+1;
			  pageNo  = 1;
			  String no = request.getParameter("checkpageNo");
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
		
		request.getSession().setAttribute("checklist",list);
		request.getSession().setAttribute("checkpageNo",pageNo);
		request.getSession().setAttribute("checkmaxPage",maxPage);
		request.getSession().setAttribute("checkpageSize",pageSize);
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
