package com.cg.lab2.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.lab2.bean.Author;
import com.cg.lab2.dao.AuthorDao;
import com.cg.lab2.dao.AuthorDaoImpl;

public class AuthorServiceImpl implements AuthorService{
	AuthorDao dao=new AuthorDaoImpl();

	public int insert(Author a) throws SQLException {
		// TODO Auto-generated method stub
		try {
			return dao.insert(a);
		}
		catch(SQLException e)
		{
			throw e;
		}
	}

	public int update(int id, Long phonenumber) throws SQLException {
		// TODO Auto-generated method stub
		try {
			return dao.update(id, phonenumber);
		}
		catch(SQLException e)
		{
			throw e;
		}
	}

	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		try {
			return dao.delete(id);
		}
		catch(SQLException e)
		{
			throw e;
		}
	}

	public ResultSet select(int id) throws SQLException {
		// TODO Auto-generated method stub
		try {
			return dao.select(id);
		}
		catch(SQLException e)
		{
			throw e;
		}
	}

}
