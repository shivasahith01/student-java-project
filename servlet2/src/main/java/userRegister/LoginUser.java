package userRegister;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserCrudOP;
import dto.User;

@WebServlet("/login2")
public class LoginUser extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username = req.getParameter("username");
	String password = req.getParameter("pwd");
	UserCrudOP u=new UserCrudOP();
	try {
		User us = u.fetchUser(username);
		System.out.println(us);
		if(us != null) {
			if((us.getPassword()).equals(password)) {
				req.setAttribute("us", us);
				RequestDispatcher dispatch = req.getRequestDispatcher("userdetails.jsp");
				dispatch.forward(req, resp);
			}else {
				req.setAttribute("msg", "password is wrong");
				RequestDispatcher dispatch = req.getRequestDispatcher("login.jsp");
				dispatch.include(req, resp);
			}
		}else {
			req.setAttribute("msg", "email is wrong");
			RequestDispatcher dispatch = req.getRequestDispatcher("login.jsp");
			dispatch.include(req, resp);
		}
		
	} catch (SQLException | IOException e) {
		System.out.println("password is wrong");
		RequestDispatcher dispatch = req.getRequestDispatcher("login.jsp");
		dispatch.include(req, resp);
	}
}
}


	
