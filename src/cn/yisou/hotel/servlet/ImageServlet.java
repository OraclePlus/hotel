package cn.yisou.hotel.servlet;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	//ͼƬ�Ŀ�͸�
	private static int WIDTH = 140;
	private static int HEIGHT = 30;
	//����
	private String[] str = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",
			"S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
	private Random r = new Random();
	/**
	 * Constructor of the object.
	 */
	public ImageServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Ҫ���һ��ͼƬ
		BufferedImage bi = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		//׼��ͼƬ�ϵ�����
		//sb��Ҫ����ȥ������
		StringBuffer sb = new StringBuffer();
		//value�ǽ���Ҫ��֤������
		StringBuffer value = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			int index = r.nextInt(str.length);
			value.append(str[index]);
			sb.append(str[index]+" ");
		}
		//��Ҫ��֤��ֵ����session��
		request.getSession().setAttribute("code", value.toString());
		//��û���
		Graphics g = bi.getGraphics();
		//����
		//պīˮ
		g.setColor(Color.BLACK);
		//������
		g.drawRect(0, 0, WIDTH, HEIGHT);
		//պīˮ
		g.setColor(Color.YELLOW);
		//��䱳��
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//պīˮ
		g.setColor(Color.RED);
		//��������
		g.setFont(new Font("����",Font.BOLD,20));
		//д��
		g.drawString(sb.toString(), 10, 22);
		
		//��������
		g.drawLine(10, 10, 130, 10);
		g.drawLine(10, 15, 130, 20);
		g.drawLine(10, 30, 130, 0);
		
		//�����ŵ�
		for (int i = 0; i < 600; i++) {
			int x = r.nextInt(WIDTH)+1;
			int y = r.nextInt(HEIGHT)+1;
			g.drawLine(x, y, x, y);
		}
		
		ServletOutputStream sos = response.getOutputStream();
		//��ͼƬ���
		ImageIO.write(bi, "jpg", sos);
		sos.flush();
		sos.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
