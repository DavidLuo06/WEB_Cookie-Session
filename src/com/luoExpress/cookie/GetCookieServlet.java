package com.luoExpress.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取客户端携带的cookie数据
		Cookie[] cookies = request.getCookies();
		if (cookies!= null) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if (cookieName.equals("age")) {
					String cookieValue = cookie.getValue();
					System.out.println(cookieValue);
				}
			}
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}