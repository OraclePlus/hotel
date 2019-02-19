package cn.yisou.hotel.web.action;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.yisou.hotel.pojo.Check;
import cn.yisou.hotel.pojo.Room;
import cn.yisou.hotel.pojo.User;
import cn.yisou.hotel.service.RoomServiceH;
import cn.yisou.hotel.service.RoomServiceZ;
import cn.yisou.hotel.service.impl.CheckServiceHImplZ;
import cn.yisou.hotel.service.impl.RoomServiceHImplZ;
import cn.yisou.hotel.utils.PrimaryKeyUUID;
import cn.yisou.hotel.utils.SqlDateConvert;
import cn.yisou.hotel.web.core.ActionForm;
import cn.yisou.hotel.web.core.ActionForward;
import cn.yisou.hotel.web.core.DispatcherAction;
import cn.yisou.hotel.web.form.OkForm;

public class OkAction extends DispatcherAction {
@Override
public ActionForward excute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
		throws ServletException, IOException {
		long daysBetween=0;
		CheckServiceHImplZ cHImpl=new CheckServiceHImplZ();
		RoomServiceZ room=new RoomServiceHImplZ();
		OkForm okForm=(OkForm)form;
		Check check=new Check();
		
		check.setChecktime(SqlDateConvert.convert(okForm.getInhotel()));
		check.setLeavetime(SqlDateConvert.convert(okForm.getOuthotel()));
		String inhotel = okForm.getInhotel();
		String outhotel = okForm.getOuthotel();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yy");
		try {
			java.util.Date d1=sdf.parse(inhotel);
			java.util.Date d2=sdf.parse(outhotel);
			daysBetween=(d2.getTime()-d1.getTime()+1000000)/(60*60*24*1000);
			/*System.out.println("daysBetween"+daysBetween);*/
		} catch (ParseException e) {
			e.printStackTrace();
		}
		check.setName(okForm.getUname());
		check.setNumber(PrimaryKeyUUID.getPrimaryKey());
		System.out.println("11111111"+okForm.getRoomtype());
		
		Room findRoomByType = room.findRoomByType(okForm.getRoomtype());
		if(findRoomByType==null) {
			System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhh");
			return new ActionForward(true,"error");
		}
		System.out.println(findRoomByType.getRoomid()+"roomid");
		check.setRoomid(findRoomByType.getRoomid());
		check.setPeoplenum(new Integer(new Integer(okForm.getAdult()).intValue()+new Integer(okForm.getChild()).intValue()));
		User user = (User)request.getSession().getAttribute("user");
		check.setUid(user.getUid());
		check.setMoney(findRoomByType.getPrice()*daysBetween);
		
		cHImpl.saveInfo(check);
		return new ActionForward(true,"okh");
}
}
