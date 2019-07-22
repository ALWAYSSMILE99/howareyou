package com.cg.lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.lab2.bean.Author;
import com.cg.lab2.dbutil.DbUtil;


public class AuthorDaoImpl implements AuthorDao {
	Connection connect=null;
	private int row;
	private String string;
	PreparedStatement ps=null;
	public int insert(Author a) throws SQLException {
		// TODO Auto-generated method stub
		try
		{
			connect=DbUtil.getConnection();
			string="insert into author values(?,?,?,?,?)";
			ps=connect.prepareStatement(string);
			ps.setInt(1, a.getAuthorId());
			ps.setString(2, a.getFirstName());
			ps.setString(3, a.getMiddleName());
			ps.setString(4, a.getLastName());
			ps.setLong(5, a.getPhoneNumber());
			row=ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			throw e;
		}
		return row;
	}
	public int update(int id, Long phonenumber) throws SQLException {
		// TODO Auto-generated method stub
		try {connect=DbUtil.getConnection();
			string="update author set phonenumber=? where authorid=?";
			ps=connect.prepareStatement(string);
			ps.setLong(1, phonenumber);
			ps.setInt(2, id);
			row=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			throw e;
		}
		return row;
	}
	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connect=DbUtil.getConnection();
			Statement s=connect.createStatement();
			row=s.executeUpdate("delete from author where authorid="+id);
		}
		catch(Exception e)
		{
			
		}
		return row;
	}
	public ResultSet select(int id) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet resultset=null;
		try {
			Statement s=connect.createStatement();
			connect=DbUtil.getConnection();
			resultset=s.executeQuery("select * from author where authorid="+id);
		}
		catch(SQLException e)
		{
			throw e;
		}
		return resultset;
	}
	

}
