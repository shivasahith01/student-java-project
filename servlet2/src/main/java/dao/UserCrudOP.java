package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

import dto.User;

public class UserCrudOP {
	public Connection saveUser() throws SQLException, IOException {
		DriverManager.registerDriver(new Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?createDatabaseIfNotExist=true","root","root");
		Statement s = con.createStatement();
		s.execute(
				"create table if not exists user (id int primary key,name varchar(45),qualification varchar(45),email varchar(45) unique,phone bigint,age int,password varchar(45))");
		return con;
	}
	public int save(User u) throws SQLException, IOException{
		Connection con = saveUser();
		PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		ps.setInt(1, u.getId());
		ps.setString(2, u.getName());
		ps.setString(3, u.getQualification());
		ps.setString(4, u.getEmail());
		ps.setLong(5, u.getPhone());
		ps.setInt(6, u.getAge());
		ps.setString(7, u.getPassword());
		int r = ps.executeUpdate();
		return r;
	}

	public User fetchUser(String email) throws SQLException, IOException {
		Connection con = saveUser();
		PreparedStatement ps = con.prepareStatement("select * from user where email=?");
		ps.setString(1, email);
		ResultSet r = ps.executeQuery();
		User udto=null;
		if (r.next()) {
			 udto = new User(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getLong(5), r.getInt(6),r.getString(7));
			return udto;
		} else {
			return null;
		}
	}
}
