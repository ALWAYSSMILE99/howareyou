package com.cg.lab2.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.lab2.bean.Author;

public interface AuthorService {
	public int insert(Author a) throws SQLException;
	public int update(int id, Long phonenumber) throws SQLException;
	public int delete(int id) throws SQLException;
	public ResultSet select(int id)throws SQLException;
}
