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
		//1������cookie����
	
		Cookie cookie = new Cookie("name", "dal");
		//Cookie cookie1 = new Cookie("age", "20");
		//1.1Ϊcookie���ó־û�ʱ��---cookie��Ӳ���ϵı���ʱ��
		//cookie.setMaxAge(60*10);//10����
		//2������cookie���ͻ���---ͷ
		response.addCookie(cookie);
		//response.addCookie(cookie1);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}