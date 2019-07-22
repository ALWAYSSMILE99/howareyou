package com.cg.lab3.dao;


import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.lab3.bean.Author;
import com.cg.lab3.bean.Book;
import com.cg.lab3.dbutil.DbUtil;

public class DaoImpl implements Dao {
	Connection connect=null;
	PreparedStatement ps=null;
	String string;
	int result;
	@Override
	public int createrecord(Book b, Author a) throws SQLException {
		// TODO Auto-generated method stub
		try {
			BigInteger isbn = null;
			int id = 0;
			connect=DbUtil.getConnection();
			Statement s=connect.createStatement();
			string="insert into book(title,price) values(?,?);";
			ps=connect.prepareStatement(string);			
			ps.setString(1, b.getTitle());
			ps.setDouble(2, b.getPrice());
			ps.executeUpdate();
			ResultSet key=s.executeQuery("select isbn from book where title='"+b.getTitle()+"';");
			if(key.next())
			{
				b.setIsbn(BigInteger.valueOf(key.getLong(1)));
				isbn=BigInteger.valueOf(key.getLong(1));
			}
			string="insert into author1(name) values('"+a.getName()+"')";
			ps=connect.prepareStatement(string);
			ps.executeUpdate();
			key=s.executeQuery("select id from author1 where name='"+a.getName()+"';");
			if(key.next())
			{
				a.setId(key.getInt(1));
				id=key.getInt(1);
			}
			result=s.executeUpdate("insert into bookauthor values("+isbn+","+id+");");
		}
		catch(SQLException e)
		{
			throw e;
		}
		return result;
	}
	@Override
	public ResultSet select(String name) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		try {
			connect=DbUtil.getConnection();
			Statement s=connect.createStatement();
			rs=s.executeQuery("select title from book where isbn in(select bisbn from bookauthor where aid in(select id from author1 where name='"+name+"'));");
		}
		catch(SQLException e)
		{
			throw e;
		}
		return rs;
	}
	@Override
	public int update(String author,String title, double price) throws SQLException {
		// TODO Auto-generated method stub
		try {
			connect=DbUtil.getConnection();
			Statement s=connect.createStatement();
			result=s.executeUpdate("update book set price="+price+" where title='"+title+"' and isbn in(select bisbn from bookauthor where aid=(select id from author1 where name='"+author+"'));");
		}
		catch(SQLException e)
		{
			throw e;
		}
		return result;
	}
	@Override
	public int addBook(String name, Book b) throws SQLException {
		// TODO Auto-generated method stub
		try {
			BigInteger isbn = null;
			int i = 0;
			connect=DbUtil.getConnection();
			Statement s=connect.createStatement();
			ResultSet rs=s.executeQuery("select id from author1 where name='"+name+"';");
			while(rs.next())
			{
				i=rs.getInt(1);
			}
			string="insert into book(title,price) values(?,?);";
			ps=connect.prepareStatement(string);			
			ps.setString(1, b.getTitle());
			ps.setDouble(2, b.getPrice());
			ps.executeUpdate();
			ResultSet key=s.executeQuery("select isbn from book where title='"+b.getTitle()+"';");
			if(key.next())
			{
				b.setIsbn(BigInteger.valueOf(key.getLong(1)));
				isbn=BigInteger.valueOf(key.getLong(1));
			}
			result=s.executeUpdate("insert into bookauthor values("+isbn+","+i+");");
		}
		catch(SQLException e)
		{
			throw e;
		}
		return result;
		
	}
	
}
