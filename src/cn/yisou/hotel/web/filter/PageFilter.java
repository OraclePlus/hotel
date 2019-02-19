package cn.yisou.hotel.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class PageFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest s1, ServletResponse s2, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)s1;
		HttpServletResponse response=(HttpServletResponse)s2;
		Object attribute = request.getSession().getAttribute("user");
		if(attribute!=null) {
			chain.doFilter(request, response);
			/*request.getRequestDispatcher("page.jsp").forward(request, response);*/
		}else {
			response.sendRedirect("register.jsp");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
