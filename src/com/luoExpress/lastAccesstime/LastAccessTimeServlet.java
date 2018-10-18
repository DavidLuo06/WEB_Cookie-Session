package com.luoExpress.lastAccesstime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessTimeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.����Cookie ��¼��ǰ�����µķ���ʱ��
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = simpleDateFormat.format(date);
		Cookie cookie = new Cookie("lastAccessTime", currentTime);
		cookie.setMaxAge(60*10*500);
		response.addCookie(cookie);
		
		String lastAccessTime = null;
		//2.��ÿͻ���Я����cookie---lastAccessTime
		Cookie[] cookies = request.getCookies();
		if (cookies!=null) {
			for (Cookie coo : cookies) {
				if (coo.getName().equals("lastAccessTime")) {
					lastAccessTime= coo.getValue();
				}
			}
		}
		
		response.setContentType("text/html;charset=UTF-8");
		if (lastAccessTime == null) {
			response.getWriter().write("���ǵ�һ�η���");
		}else {
			response.getWriter().write("���ϴη���ʱ��:"+lastAccessTime);

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}