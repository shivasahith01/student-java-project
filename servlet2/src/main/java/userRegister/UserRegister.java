package userRegister;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.UserCrudOP;
import dto.User;

@WebServlet("/user")
public class UserRegister extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String qualification = req.getParameter("qualification");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		int age = Integer.parseInt(req.getParameter("age"));
		String password = req.getParameter("password");
//		PrintWriter out = res.getWriter();
		User user = new User(id, name, qualification, email, phone, age, password);
		System.out.println(user);
		UserCrudOP crud=new UserCrudOP();
		try {
			crud.save(user);
			RequestDispatcher dispatch=req.getRequestDispatcher("login.html");
			dispatch.forward(req, res);
		} catch (SQLException e) {
			RequestDispatcher dispatch=req.getRequestDispatcher("user.html");
			dispatch.include(req, res);
		} catch (IOException e) {
			RequestDispatcher dispatch=req.getRequestDispatcher("user.html");
			dispatch.include(req, res);
		}
	}
}
