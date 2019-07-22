package com.cg.lab1.pl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) throws SQLException {
		Connection connect=DbUtil.getConnection();
		Statement s=connect.createStatement();
		System.out.println("Enter Number of Elements:-");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		try {
			s.executeUpdate("delete from db1;");
			for(int i = 0; i<n;i++)
			{
				System.out.println("Enter id of "+i+" Element");
				int id = scan.nextInt();
				System.out.println("Enter name of "+i+" Element");
				String data = scan.next();

				s.executeUpdate("insert into db1 values("+id+",'"+data+"');");
			}
			ResultSet rs=s.executeQuery("select * from db1 order by id");
			while(rs.next())
			{
				System.out.println(rs.getString(2)+"\n");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally {
			connect.close();
		}
		scan.close();
	}

}
