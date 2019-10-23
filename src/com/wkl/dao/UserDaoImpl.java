package com.wkl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wkl.pojo.User;
import com.wkl.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean login(String uphone, String pwd) {
		boolean flag = false;
		String sql = "select * from user where phone ='" + uphone + "' and pwd = '" + pwd + "'";
		try{
			DBUtil.init();
			ResultSet rs = DBUtil.select(sql);
			while(rs.next()) {
				if(rs.getObject("uphone").equals(uphone) && rs.getObject("pwd").equals(pwd)) flag = true;// TODO 自动生成的方法存根
			}
		}catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
		DBUtil.closeConn();
		return flag;
	}

	@Override
	public boolean insertUser(User user) {
		boolean flag = false;
		String sql = "insert into user (name,phone,email,pwd,starId ) values('" 
		+ user.getUname() +"','" 
				+ user.getUphone() +"','" 
		+ user.getEmail() +"','" 
				+ user.getPwd() +"','" + user.getSid() + "')";
		try {
			DBUtil.init();
			int i = DBUtil.addDelUpd(sql);
			if(i>0) flag = true;
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		DBUtil.closeConn();
		// TODO 自动生成的方法存根
		return flag;
	}

	@Override
	public User findUserByPhone(String uphone) {
		User user = new User();
		String sql = "select * from user where phone = '" + uphone + "'";
		try{
			DBUtil.init();
			ResultSet rs = DBUtil.select(sql);
			while(rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setId(rs.getInt("id"));
				user.setPwd(rs.getString("pwd"));
				user.setSid(rs.getString("starId"));
				user.setUname(rs.getString("name"));
				user.setUphone(rs.getString("phone"));
				// TODO 自动生成的方法存根
			}
		}catch (SQLException e) {
			System.out.println("findUserByPhone出错！");
			e.printStackTrace();// TODO: handle exception
		}
		DBUtil.closeConn();
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		boolean flag = false;
		String sql = "update user set name = '" + user.getUname()
		+"', pwd = '" + user.getPwd() 
		+"', email = '" + user.getEmail()
		+"', phone = '" + user.getUphone()
		+"', starId = '" + user.getSid() + "' where id = " + user.getId();// TODO 自动生成的方法存根
		try {
			DBUtil.init();
			int i = DBUtil.addDelUpd(sql);
			if(i>0) flag = true;
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		DBUtil.closeConn();
		return flag;
	}

	@Override
	public boolean adoptStar(int id, int starId) {
		boolean flag = false;
		String sql = "update user set sid = '" + starId + "' where id = " + id;
		try{
			DBUtil.init();
			int i = DBUtil.addDelUpd(sql);
			if(i>0) flag = true;// TODO 自动生成的方法存根
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		DBUtil.closeConn();
		return flag;
	}

}
