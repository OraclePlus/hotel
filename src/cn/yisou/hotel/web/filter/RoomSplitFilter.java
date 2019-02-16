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

import cn.yisou.hotel.pojo.Room;
import cn.yisou.hotel.service.RoomServiceH;
import cn.yisou.hotel.service.impl.RoomServiceHImpl;


public class RoomSplitFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		RoomServiceH rs = new RoomServiceHImpl();
		List<Room> list = null;
		int maxPage=0;
		int pageNo=0;
		int pageSize = 10;
		String size = request.getParameter("roompageSize");
		  if(size!=null){
		  	pageSize = Integer.parseInt(size);
		  }
		  maxPage = rs.getMaxPageNo(pageSize);
		  pageNo  = 1;
		  String no = request.getParameter("roompageNo");
		  if(no!=null){
		  	pageNo = Integer.parseInt(no);
		  	if(pageNo < 1){
		  		pageNo=1;
		  	}
		  	if(pageNo > maxPage){
		  		pageNo=maxPage;
		  	}
		  }
		list  = rs.splitQuery(pageSize,pageNo);
		request.getSession().setAttribute("roomlist",list);
		request.getSession().setAttribute("roompageNo",pageNo);
		request.getSession().setAttribute("roommaxPage",maxPage);
		request.getSession().setAttribute("roompageSize",pageSize);
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
