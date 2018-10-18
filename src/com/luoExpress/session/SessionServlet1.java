package com.luoExpress.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//�������ڸÿͻ���(�Ự)��˽�е�session����
		/* request.getSession()�����ڲ����ж� �ÿͻ����Ƿ��ڷ��������Ѿ�����session
		 * ����ÿͻ����ڴ˷�����������session ��ô�ͻᴴ��һ���µ�session����
		 * ����ÿͻ����ڴ˷������Ѿ�����session ����Ѿ����ڵĸ�session����
		 */
		HttpSession session = request.getSession();
		
		session.setAttribute("name", "jerry");
		
		String id = session.getId();//��session����ı��id
		
		//�ֶ�����һ���洢JSESSIONID��Cookie Ϊ��cookie���ó־û�ʱ��
		Cookie cookie = new Cookie("JSESSIONID",id);
		cookie.setPath("/WEB_Cookie&Session/");
		cookie.setMaxAge(60*10);
		
		response.addCookie(cookie);
		
		
		response.getWriter().write("JSESSIONID:"+id);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}