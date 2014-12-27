<%@page import="java.util.Random"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.*"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page language="java" pageEncoding="UTF-8" %>
<%
	//生成验证码功能
	response.setHeader("Cache", "no-cache");
	//在内存中创建图像
	int width = 60,height = 24;	//设置验证码的长宽
	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	//获取画笔
	Graphics g = image.getGraphics();
	//设置背景色
	g.setColor(new Color(230,230,230));
	g.fillRect(0, 0, width, height);
	//取随机产生的验证码
	Random rnd = new Random();
	int randNum = rnd.nextInt(8999) + 1000;
	String randStr = String.valueOf(randNum);
	//将验证码放入session
	session.setAttribute("randStr", randStr);
	//将验证码显示在图像中
	g.setColor(Color.black);
	g.setFont(new Font("",Font.PLAIN,20));
	g.drawString(randStr, 10, 20);
	//随机产生100个干扰点，使图像中的验证码不容易被其他程序探测到
	for(int i = 0; i < 100; i++){
		int x = rnd.nextInt(width);
		int y = rnd.nextInt(height);
		g.drawOval(x, y, 1, 1);
	}
	//输出图像到页面
	ImageIO.write(image, "JPEG", response.getOutputStream());
	out.clear();
	out = pageContext.pushBody();
%>