package cn.yisou.hotel;

import java.util.Date;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		Connection conn=DBHelper.getConnection();
//		UserDao udao=new UserDaoImpl();
//		User user=new User();
//		byte[] b= {1,2,3,4};
//		user.setUid("123");
//		user.setName("张三");
//		user.setPsw(b);
//		user.setIdcard("789423135246");
//		user.setSex("男");
//		user.setGrade("vip1");
//		user.setUtel("123456789");
//		User user=udao.selectUserByUid("123", conn);
//		System.out.println(udao.updateGradeByUid("123", "vip2", conn));
//		RoomDao rd=new RoomDaoImpl();
//		Room room=new Room();
//		room.setRoomid("1002");
//		room.setPeoplemun(4);
//		room.setHourroom("yes");
//		room.setPrice(500d);
//		room.setRoomtel("45678");
//		room.setType("双人间");
//		room.setState(0);
//		System.out.println(rd.addRoom(room, conn));
		String dateStr1 = "2017-03-01";
		Date date1 = DateUtil.parse(dateStr1);
		String dateStr2 = "2017-04-01";
		Date date2 = DateUtil.parse(dateStr2);

		//相差一个月，31天
		long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
		System.out.println(betweenDay);
	}

}
