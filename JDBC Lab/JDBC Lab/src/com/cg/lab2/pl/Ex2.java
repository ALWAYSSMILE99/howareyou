package com.cg.lab2.pl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Ex2 {
	public static void showMenu() {
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. View All");
		System.out.println("5. Exit");
		System.out.print("Enter Your Choice : ");
	}
	public static void main(String[] args) throws SQLException {
		Connection connect=DbUtil.getConnection();
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		int row;
		while(true)
		{
			showMenu();
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				String string="insert into author values(?,?,?,?,?)";
				PreparedStatement ps=connect.prepareStatement(string);
				System.out.println("Enter the authorid:");
				int id=scan.nextInt();
				ps.setInt(1, id);
				System.out.println("Enter the firstname:");
				String fname=scan.next();
				ps.setString(2, fname);
				System.out.println("Enter the middlename:");
				String mname=scan.next();
				ps.setString(3, mname);
				System.out.println("Enter the lastname:");
				String lname=scan.next();
				ps.setString(4, lname);
				System.out.println("Enter phone number");
				Long phno=scan.nextLong();
				ps.setLong(5, phno);
				row=ps.executeUpdate();
				System.out.println(row+" are inserted");
				break;
			case 2:
				System.out.println("Enter the authorid:");
				id=scan.nextInt();
				System.out.println("Enter the new phone number");
				phno=scan.nextLong();
				String string2="update table author set phoneno=phno where authorid=id";
				ps=connect.prepareStatement(string2);
				row=ps.executeUpdate();
				System.out.println(row+" are updated");
				break;
			case 3:
				System.out.println("Enter the authorid:");
				id=scan.nextInt();
				String string3="delete from author where authorid=id";
				ps=connect.prepareStatement(string3);
				row=ps.executeUpdate();
				System.out.println(row+" are updated");
				break;
			case 4:
				String string4="select * from author";
				ps=connect.prepareStatement(string4);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					System.out.println("id-"+rs.getInt(1));
				}
				break;
			case 5:
				System.exit(0);
				break;
			default:
				break;
				
					
			}
		}
	}

}
