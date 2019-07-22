package com.cg.lab3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.cg.lab3.bean.Author;
import com.cg.lab3.bean.Book;

public interface Dao {
	public int createrecord(Book b, Author a) throws SQLException;
	public int addBook(String name,Book b) throws SQLException;
	public ResultSet select(String name) throws SQLException;
	public int update(String author,String title,double price)throws SQLException;
}
