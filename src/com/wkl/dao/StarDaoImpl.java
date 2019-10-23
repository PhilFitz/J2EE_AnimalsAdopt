package com.wkl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wkl.pojo.Stars;
import com.wkl.util.DBUtil;

public class StarDaoImpl implements StarDao {

	@Override
	public List<Stars> findAllDog() {
		String sql = "select * from stars where type = '1' and isAdopt = '0'";//"1"表示已经被领养
		List<Stars> list = new ArrayList<Stars>();
		try {
			Stars s = new Stars();
			DBUtil.init();
			ResultSet rs = DBUtil.select(sql);
			while(rs.next()) {
				s = common(rs);
				list.add(s);
				
			}
		}catch (SQLException e) {
			System.out.println("findAllDog 出错！");
			e.printStackTrace();// TODO: handle exception
		}
		DBUtil.closeConn();
		return list;
	}

	@Override
	public List<Stars> findAllCat() {
		String sql = "select * from stars where type = '2' and isAdopt = '0'";//"0"表示已经被领养
		List<Stars> list = new ArrayList<Stars>();
		try {
			Stars s = new Stars();
			DBUtil.init();
			ResultSet rs = DBUtil.select(sql);
			while(rs.next()) {
				s = common(rs);
				list.add(s);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
		DBUtil.closeConn();
		return list;
	}

	@Override
	public List<Stars> findAllAdopt() {
		List<Stars> list = new ArrayList<Stars>();
		String sql = "select * from stars where isAdopt = 1";
		
		try {
			Stars s = new Stars();
			DBUtil.init();
			ResultSet rs = DBUtil.select(sql);
			while(rs.next()) {
				s = common(rs);
				list.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
		DBUtil.closeConn();// TODO 自动生成的方法存根
		return list;
	}

	@Override
	public List<Stars> findAllOther() {
		List<Stars> list = new ArrayList<Stars>();
		String sql = "select * from stars where type = '3' and isAdopt = '0'";
		
		try {
			Stars s = new Stars();
			DBUtil.init();
			ResultSet rs = DBUtil.select(sql);
			while(rs.next()) {
				s = common(rs);
				list.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
		DBUtil.closeConn();// TODO 自动生成的方法存根
		return list;
	}

	@Override
	public boolean insertStar(Stars s) {
		boolean flag = false;
		String sql = "insert into stars(id, photo, name, age, sex, address, phone, type, breed, isAdopt, momId) "
				+ "values('"+ s.getId() 
				+"','"+ s.getPhoto()
				+"','"+ s.getSname()
				+"','"+ s.getAge()
				+"','"+ s.getSex()
				+"','"+ s.getAddress()
				+"','"+ s.getSphone()
				+"','"+ s.getType()
				+"','"+ s.getBreed()
				+"','"+ s.getIsAdopt()
				+"','"+ s.getMomId() +"')";
		
		try {
			DBUtil.init();
			int i = DBUtil.addDelUpd(sql);
			if(i>0) flag = true;
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		DBUtil.closeConn();
		return flag;
		
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean adoptStar(int id, int momId) {
		boolean flag = false;
		String sql = "update stars set momId ='"+ momId +"', isAdopt = 1 where id = " + id;
		try {
			DBUtil.init();
			int i = DBUtil.addDelUpd(sql);
			if(i>0) flag = true;
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		DBUtil.closeConn();
		// TODO 自动生成的方法存根
		return flag;
		
	}

	@Override
	public Stars getStar(int id) {
		Stars s = new Stars();
		String sql = "select * from stars where id = "+ id;
		
		try {
			DBUtil.init();
			ResultSet rs = DBUtil.select(sql);
			while(rs.next()) {
				s = common(rs);
			}
		}catch (SQLException e) {
			e.printStackTrace();// TODO: handle exception
		}
		DBUtil.closeConn();
		// TODO 自动生成的方法存根
		return s;
	}
	
	private Stars common(ResultSet rs) throws SQLException {
		Stars s = new Stars();
		s.setAddress(rs.getString("address"));
		s.setAge(rs.getInt("age"));
		s.setBreed(rs.getString("breed"));
		s.setId(rs.getInt("id"));
		s.setIsAdopt(rs.getInt("isAdopt"));
		s.setPhoto(rs.getString("photo"));
		s.setSex(rs.getInt("sex"));
		s.setSname(rs.getString("name"));
		s.setSphone(rs.getString("phone"));
		s.setType(rs.getString("type"));
		s.setMomId(rs.getInt("momId"));
		return s;
	}
}
