package cn.yisou.hotel.web.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.yisou.hotel.pojo.Check;
import cn.yisou.hotel.pojo.User;
import cn.yisou.hotel.service.RoomServiceZ;
import cn.yisou.hotel.service.impl.CheckServiceHImplZ;
import cn.yisou.hotel.service.impl.RoomServiceHImplZ;
import cn.yisou.hotel.utils.PaymentUtil;
import cn.yisou.hotel.utils.PrimaryKeyUUID;
import cn.yisou.hotel.utils.SqlDateConvert;
import cn.yisou.hotel.web.core.ActionForm;
import cn.yisou.hotel.web.core.ActionForward;
import cn.yisou.hotel.web.core.DispatcherAction;
import cn.yisou.hotel.web.form.OkForm;

public class OkAction extends DispatcherAction {
	String oid=PrimaryKeyUUID.getPrimaryKey();
@Override
public ActionForward excute(HttpServletRequest request, HttpServletResponse response, ActionForm form)
		throws ServletException, IOException {
		long daysBetween=0;
		CheckServiceHImplZ cHImpl=new CheckServiceHImplZ();
		RoomServiceZ room=new RoomServiceHImplZ();
		OkForm okForm=(OkForm)form;
		Check check=new Check();
		System.out.println(okForm.getParam()+"okForm.getParam()");
		check.setChecktime(SqlDateConvert.convert(okForm.getInhotel()));
		check.setLeavetime(SqlDateConvert.convert(okForm.getOuthotel()));
		
		String inhotel = okForm.getInhotel();
		String outhotel = okForm.getOuthotel();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yy");
		try {
			java.util.Date d1=sdf.parse(inhotel);
			java.util.Date d2=sdf.parse(outhotel);
			daysBetween=(d2.getTime()-d1.getTime()+1000000)/(60*60*24*1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String uname = okForm.getUname();
		byte[] b = uname.getBytes("ISO8859-1");
		uname = new String(b,"UTF-8");
		
		check.setName(uname);
		check.setNumber(PrimaryKeyUUID.getPrimaryKey());
		check.setName(okForm.getUname());
		check.setNumber(oid);
		//System.out.println("11111111"+okForm.getRoomtype());
		
		check.setPeoplenum(new Integer(new Integer(okForm.getAdult()).intValue()+new Integer(okForm.getChild()).intValue()));
		
		User user = (User)request.getSession().getAttribute("user");
		check.setUid(user.getUid());
		
		cHImpl.saveInfo(check);
		
		try {
			pay(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new ActionForward(true,"okh");
		
}


//付款
	public String pay(HttpServletRequest request,HttpServletResponse respone) throws Exception{
			//接受参数
		System.out.println("我在pay");
			String address=request.getParameter("uname");
			String name=request.getParameter("idcard");
			String telephone=request.getParameter("email");
			//String oid=request.getParameter("oid");
			
			
			//通过id获取order
			/*OrderService s=(OrderService) BeanFactory.getBean("OrderService");
			Order order = s.getOrderByOid(oid);
			*/
			/*order.setAddress(address);
			order.setName(name);
			order.setTelephone(telephone);*/
			
			//更新order
			//s.updateOrder(order);
			

			// 组织发送支付公司需要哪些数据
			String pd_FrpId = request.getParameter("pd_FrpId");
			String p0_Cmd = "Buy";
			String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
			String p2_Order = oid;
			String p3_Amt = "0.01";
			String p4_Cur = "CNY";
			String p5_Pid = "";
			String p6_Pcat = "";
			String p7_Pdesc = "";
			// 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
			// 第三方支付可以访问网址
			String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("responseURL");
			String p9_SAF = "";
			String pa_MP = "";
			String pr_NeedResponse = "1";
			// 加密hmac 需要密钥
			String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
			String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
					p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
					pd_FrpId, pr_NeedResponse, keyValue);
		
			
			//发送给第三方
			StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
			sb.append("p0_Cmd=").append(p0_Cmd).append("&");
			sb.append("p1_MerId=").append(p1_MerId).append("&");
			sb.append("p2_Order=").append(p2_Order).append("&");
			sb.append("p3_Amt=").append(p3_Amt).append("&");
			sb.append("p4_Cur=").append(p4_Cur).append("&");
			sb.append("p5_Pid=").append(p5_Pid).append("&");
			sb.append("p6_Pcat=").append(p6_Pcat).append("&");
			sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
			sb.append("p8_Url=").append(p8_Url).append("&");
			sb.append("p9_SAF=").append(p9_SAF).append("&");
			sb.append("pa_MP=").append(pa_MP).append("&");
			sb.append("pd_FrpId=").append(pd_FrpId).append("&");
			sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
			sb.append("hmac=").append(hmac);
			
			respone.sendRedirect(sb.toString());
			
			return null;
		}
		
		//回调
		
		public ActionForward callback(HttpServletRequest request,HttpServletResponse response) throws Exception{
			String p1_MerId = request.getParameter("p1_MerId");
			String r0_Cmd = request.getParameter("r0_Cmd");
			String r1_Code = request.getParameter("r1_Code");
			String r2_TrxId = request.getParameter("r2_TrxId");
			String r3_Amt = request.getParameter("r3_Amt");
			String r4_Cur = request.getParameter("r4_Cur");
			String r5_Pid = request.getParameter("r5_Pid");
			String r6_Order = request.getParameter("r6_Order");
			String r7_Uid = request.getParameter("r7_Uid");
			String r8_MP = request.getParameter("r8_MP");
			String r9_BType = request.getParameter("r9_BType");
			String rb_BankId = request.getParameter("rb_BankId");
			String ro_BankOrderId = request.getParameter("ro_BankOrderId");
			String rp_PayDate = request.getParameter("rp_PayDate");
			String rq_CardNo = request.getParameter("rq_CardNo");
			String ru_Trxtime = request.getParameter("ru_Trxtime");
			// 身份校验 --- 判断是不是支付公司通知你
			String hmac = request.getParameter("hmac");
			String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
					"keyValue");

			// 自己对上面数据进行加密 --- 比较支付公司发过来hamc
			boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
					r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
					r8_MP, r9_BType, keyValue);
			if (isValid) {
				// 响应数据有效
				if (r9_BType.equals("1")) {
					// 浏览器重定向
					System.out.println("111");
					request.setAttribute("msg", "您的订单号为:"+r6_Order+",金额为:"+r3_Amt+"已经支付成功,等待发货~~");
					
				} else if (r9_BType.equals("2")) {
					// 服务器点对点 --- 支付公司通知你
					System.out.println("付款成功！222");
					// 修改订单状态 为已付款
					// 回复支付公司
					response.getWriter().print("success");
				}
				
				//修改订单状态
				/*OrderService s=(OrderService) BeanFactory.getBean("OrderService");
				Order order = s.getOrderByOid(r6_Order);
				order.setState(1);
				s.updateOrder(order);*/
				
				
			} else {
				// 数据无效
				System.out.println("数据被篡改！");
			}
			
			
			return new ActionForward(false, "ok.jsp");
			
		}
}
