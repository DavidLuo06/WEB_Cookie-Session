package com.luoExpress.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1、创建cookie对象
	
		Cookie cookie = new Cookie("name", "dal");
		//Cookie cookie1 = new Cookie("age", "20");
		//1.1为cookie设置持久化时间---cookie在硬盘上的保存时间
		//cookie.setMaxAge(60*10);//10分钟
		//2、发送cookie到客户端---头
		response.addCookie(cookie);
		//response.addCookie(cookie1);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}