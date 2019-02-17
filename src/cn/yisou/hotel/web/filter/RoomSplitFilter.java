package cn.yisou.hotel.web.filter;

import java.io.IOException;
import java.util.ArrayList;
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
		List<Room> list = new ArrayList<Room>();
		Room room =new Room();
		String lc=request.getParameter("lc");
		String roomid=request.getParameter("room");
		String state=request.getParameter("state");
		int maxPage=1;
		int pageNo=1;
		int pageSize = 10;
		if (lc==null||roomid==null||state==null) {
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
		}else if (!"0".equals(roomid)) {
			room=rs.findRoomByRoomid(roomid);
			pageSize=1;
			list.add(room);
		}else if("0".equals(lc)){
			if ("0".equals(state)) {
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
			}else {
				list=rs.findRoomByState(state);
				String size = request.getParameter("roompageSize");
				  if(size!=null){
				  	pageSize = Integer.parseInt(size);
				  }
				  int count=list.size();
				  maxPage = count%pageSize==0 ? count/pageSize : count/pageSize+1;
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
			}
		}else {
			if ("0".equals(state)) {
				list=rs.findRoomByLC(lc);
				String size = request.getParameter("roompageSize");
				  if(size!=null){
				  	pageSize = Integer.parseInt(size);
				  }
				  int count=list.size();
				  maxPage = count%pageSize==0 ? count/pageSize : count/pageSize+1;
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
			}else {
				list=rs.findRoomByLC(lc);
				List<Room>list2=rs.findRoomByState(state);
				List<Room>list3=new ArrayList<Room>();
				for (int i = 0; i < list.size(); i++) {
					for (int j = 0; j < list2.size(); j++) {
						if (list2.get(j).getRoomid().equals(list.get(i).getRoomid())) {
							list3.add(list2.get(j));
						}
					}
				}
				list=list3;
				String size = request.getParameter("roompageSize");
				  if(size!=null){
				  	pageSize = Integer.parseInt(size);
				  }
				  int count=list.size();
				  maxPage = count%pageSize==0 ? count/pageSize : count/pageSize+1;
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
			}
		}
		
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
