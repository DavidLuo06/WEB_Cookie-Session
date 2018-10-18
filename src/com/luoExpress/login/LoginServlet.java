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
		//验证码校验
		//获得页面输入的验证
		String checkCode_client = request.getParameter("checkCode");
		//System.out.println(checkCode_client);
		//获得生成图片的文字的验证码
		String checkCode_session = (String) request.getSession().getAttribute("checkcode_session");
		//System.out.println(checkCode_session);
		//比对页面的和生成图片的文字的验证码是否一致
		if(!checkCode_client.equals(checkCode_session)){
			request.setAttribute("loginInfo", "您的验证码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		
		//获得页面的用户名和密码进行数据库的校验
		//......
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}