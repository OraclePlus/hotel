package cn.yisou.hotel.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yisou.hotel.pojo.Message;
import cn.yisou.hotel.service.MessageServiceH;
import cn.yisou.hotel.service.impl.MessageServiceImplH;



public class MessageFilter implements Filter{

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest s1, ServletResponse s2, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)s1;
		HttpServletResponse response=(HttpServletResponse)s2;
		MessageServiceH ms=new MessageServiceImplH();
		List<Message> list=ms.findAll();
		request.getSession().setAttribute("messagelist",list);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	

}
