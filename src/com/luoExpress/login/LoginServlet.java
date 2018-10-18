package com.luoExpress.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//��֤��У��
		//���ҳ���������֤
		String checkCode_client = request.getParameter("checkCode");
		//System.out.println(checkCode_client);
		//�������ͼƬ�����ֵ���֤��
		String checkCode_session = (String) request.getSession().getAttribute("checkcode_session");
		//System.out.println(checkCode_session);
		//�ȶ�ҳ��ĺ�����ͼƬ�����ֵ���֤���Ƿ�һ��
		if(!checkCode_client.equals(checkCode_session)){
			request.setAttribute("loginInfo", "������֤�벻��ȷ");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		
		//���ҳ����û���������������ݿ��У��
		//......
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}