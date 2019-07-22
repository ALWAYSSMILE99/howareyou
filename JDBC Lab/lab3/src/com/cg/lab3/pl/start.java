package com.cg.lab3.pl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.lab3.bean.Author;
import com.cg.lab3.bean.Book;
import com.cg.lab3.service.Service;
import com.cg.lab3.service.ServiceImpl;

public class start {
	public static void showMenu() {
		System.out.println("1. Insert");
		System.out.println("2. Insert book for existing author");
		System.out.println("3. Shows Books Written by Author");
		System.out.println("4. Update Price of a Book");
		System.out.println("5. Exit");
		System.out.println("Enter your choice");
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Service service=new ServiceImpl();
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			showMenu();
			int choice=scan.nextInt();
			int row = 0;
			switch(choice) {
			case 1:
				try {
					Book b=new Book();
					Author a=new Author();
					System.out.println("enter the title of the book");
					b.setTitle(scan.next());
					System.out.println("enter the price");
					b.setPrice(scan.nextDouble());
					System.out.println("Enter the author name");
					a.setName(scan.next());
					row=service.createrecord(b, a);
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
				if(row==0)
				{
					System.out.println("error in details");
				}
				else if(row==1)
				{
					System.out.println("Successfully Inserted");
				}
				break;
			case 2:
				try {
					Book b=new Book();
					System.out.println("enter the name of the author");
					String name=scan.next();
					System.out.println("enter the title of the book");
					b.setTitle(scan.next());
					System.out.println("enter the price");
					b.setPrice(scan.nextDouble());
					row=service.addBook(name, b);
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
				if(row==0)
				{
					System.out.println("Author not found");
				}
				else if(row==1)
				{
					System.out.println("Successfully Inserted");
				}
				break;
			case 3:
				int i=0;
				try{
					System.out.println("Enter the name of the author");
					String name=scan.next();
					ResultSet rs=service.select(name);
					i=0;
					while(rs.next())
					{
						i=i+1;
						System.out.println(+i+"- "+rs.getString(1));
					}
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
				if(i==0)
				{
					System.out.println("Author not found");
				}
				break;
			case 4:
				try {
					System.out.println("Enter the name of the author");
					String name=scan.next();
					System.out.println("Enter the book name:");
					String title=scan.next();
					System.out.println("Enter the new price:");
					double price=scan.nextDouble();
					row=service.update(name,title,price);
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
				if(row==0)
				{
					System.out.println("Author not found");
				}
				else if(row==1)
				{
					System.out.println("Successfully Inserted");
				}
				break;
			case 5:
				System.exit(0);
			default:
				break;
			}
		}
	}

}
