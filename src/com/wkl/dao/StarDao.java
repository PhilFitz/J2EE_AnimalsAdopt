package com.wkl.dao;

import java.util.List;

import com.wkl.pojo.Stars;

public interface StarDao {
	public List<Stars> findAllDog();// 查找所有没有被领养的汪星人
	public List<Stars> findAllCat();// 查找所有没有被领养的喵星人
	public List<Stars> findAllAdopt();// 查找所有已经被领养的星人
	public List<Stars> findAllOther();// 查找其他没有被领养的星人
	public boolean insertStar(Stars s);// 添加一个星人
	public boolean adoptStar(int id, int momId);// 领养一个星人
	public Stars getStar(int id);// 查找一个星人
}
