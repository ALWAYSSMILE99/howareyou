package com.cg.lab3.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.cg.lab3.bean.Author;
import com.cg.lab3.bean.Book;
import com.cg.lab3.dao.Dao;
import com.cg.lab3.dao.DaoImpl;

public class ServiceImpl implements Service{
	Dao dao=new DaoImpl();
	int row;
	@Override
	public int createrecord(Book b, Author a) throws SQLException {
		// TODO Auto-generated method stub
		try {
			row=dao.createrecord(b, a);
		}
		catch(SQLException e){
			throw e;
		}
		return row;
	}
	@Override
	public ResultSet select(String name) throws SQLException {
		// TODO Auto-generated method stub
		try {
			return dao.select(name);
		}
		catch(SQLException e){
			throw e;
		}
	}
	@Override
	public int update(String author,String title, double price) throws SQLException {
		// TODO Auto-generated method stub
		try {
			row=dao.update(author,title, price);;
		}
		catch(SQLException e){
			throw e;
		}
		return row;
	}
	@Override
	public int addBook(String name, Book b) throws SQLException {
		// TODO Auto-generated method stub
		try {
			row=dao.addBook(name, b);
		}
		catch(SQLException e)
		{
			throw e;
		}
		return row;
	}

}
