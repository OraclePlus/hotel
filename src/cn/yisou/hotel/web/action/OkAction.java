package cn.yisou.hotel.web.action;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.naming.factory.BeanFactory;
import org.ietf.jgss.Oid;

import com.sun.xml.internal.ws.api.pipe.Tube;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.db.sql.Order;
import cn.yisou.hotel.pojo.Check;
import cn.yisou.hotel.pojo.Room;
import cn.yisou.hotel.pojo.User;
import cn.yisou.hotel.service.RoomServiceH;
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
			/*System.out.println("daysBetween"+daysBetween);*/
		} catch (ParseException e) {
			e.printStackTrace();
		}
		check.setName(okForm.getUname());
		check.setNumber(oid);
		//System.out.println("11111111"+okForm.getRoomtype());
		
		Room findRoomByType = room.findRoomByType(okForm.getRoomtype());
		if(findRoomByType==null) {
			System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhh");
			return new ActionForward(true,"error");
		}
		/*System.out.println(findRoomByType.getRoomid()+"roomid");*/
		check.setRoomid(findRoomByType.getRoomid());
		check.setPeoplenum(new Integer(new Integer(okForm.getAdult()).intValue()+new Integer(okForm.getChild()).intValue()));
		
		User user = (User)request.getSession().getAttribute("user");
		check.setUid(user.getUid());
		check.setMoney(findRoomByType.getPrice()*daysBetween);
		
		cHImpl.saveInfo(check);
		return new ActionForward(true,"okh");
}


//����
	public String pay(HttpServletRequest request,HttpServletResponse respone) throws Exception{
			//���ܲ���
		System.out.println("����pay");
			String address=request.getParameter("uname");
			String name=request.getParameter("idcard");
			String telephone=request.getParameter("email");
			//String oid=request.getParameter("oid");
			
			
			//ͨ��id��ȡorder
			/*OrderService s=(OrderService) BeanFactory.getBean("OrderService");
			Order order = s.getOrderByOid(oid);
			*/
			/*order.setAddress(address);
			order.setName(name);
			order.setTelephone(telephone);*/
			
			//����order
			//s.updateOrder(order);
			

			// ��֯����֧����˾��Ҫ��Щ����
			String pd_FrpId = request.getParameter("pd_FrpId");
			String p0_Cmd = "Buy";
			String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
			String p2_Order = oid;
			String p3_Amt = "0.01";
			String p4_Cur = "CNY";
			String p5_Pid = "";
			String p6_Pcat = "";
			String p7_Pdesc = "";
			// ֧���ɹ��ص���ַ ---- ������֧����˾����ʡ��û�����
			// ������֧�����Է�����ַ
			String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("responseURL");
			String p9_SAF = "";
			String pa_MP = "";
			String pr_NeedResponse = "1";
			// ����hmac ��Ҫ��Կ
			String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
			String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
					p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
					pd_FrpId, pr_NeedResponse, keyValue);
		
			
			//���͸�������
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
		
		//�ص�
		
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
			// ���У�� --- �ж��ǲ���֧����˾֪ͨ��
			String hmac = request.getParameter("hmac");
			String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
					"keyValue");

			// �Լ����������ݽ��м��� --- �Ƚ�֧����˾������hamc
			boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
					r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
					r8_MP, r9_BType, keyValue);
			if (isValid) {
				// ��Ӧ������Ч
				if (r9_BType.equals("1")) {
					// ������ض���
					System.out.println("111");
					request.setAttribute("msg", "���Ķ�����Ϊ:"+r6_Order+",���Ϊ:"+r3_Amt+"�Ѿ�֧���ɹ�,�ȴ�����~~");
					
				} else if (r9_BType.equals("2")) {
					// ��������Ե� --- ֧����˾֪ͨ��
					System.out.println("����ɹ���222");
					// �޸Ķ���״̬ Ϊ�Ѹ���
					// �ظ�֧����˾
					response.getWriter().print("success");
				}
				
				//�޸Ķ���״̬
				/*OrderService s=(OrderService) BeanFactory.getBean("OrderService");
				Order order = s.getOrderByOid(r6_Order);
				order.setState(1);
				s.updateOrder(order);*/
				
				
			} else {
				// ������Ч
				System.out.println("���ݱ��۸ģ�");
			}
			
			
			return new ActionForward(false, "ok.jsp");
			
		}
}
