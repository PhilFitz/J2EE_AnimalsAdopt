package com.wkl.dao;

import com.wkl.pojo.User;

public interface UserDao {
	public boolean login(String uphone, String pwd);
	public boolean insertUser(User user);
	public User findUserByPhone(String uphone);
	public boolean updateUser(User user);
	public boolean adoptStar(int id, int starId);
}
