package com.cg.lab2.pl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.cg.lab2.bean.Author;
import com.cg.lab2.service.AuthorService;
import com.cg.lab2.service.AuthorServiceImpl;

public class start {
	public static void showMenu() {
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. View Details");
		System.out.println("5. Exit");
		System.out.print("Enter Your Choice : ");
	}
	public static void main(String[] args) throws SQLException {
		Author a=new Author();
		AuthorService service=new AuthorServiceImpl();
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		int row,id;
		while(true)
		{
			showMenu();
			int choice=scan.nextInt();
			switch(choice)
			{
			case 1:
				try
				{
					System.out.println("Enter the authorid:");
					a.setAuthorId(scan.nextInt());
					System.out.println("Enter the firstname:");
					a.setFirstName(scan.next());
					System.out.println("Enter the middlename:");
					a.setMiddleName(scan.next());
					System.out.println("Enter the lastname:");
					a.setLastName(scan.next());
					System.out.println("Enter phone number");
					a.setPhoneNumber(scan.nextLong());
					row=service.insert(a);
					if(row==0)
					{
						System.out.println("error in details");
					}
					else if(row==1)
					{
						System.out.println("Successfully Inserted");
					}
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
				break;
			case 2:
				try
				{
					System.out.println("Enter the authorid:");
					id=scan.nextInt();
					System.out.println("Enter the new phone number");
					Long phno=scan.nextLong();
					row=service.update(id, phno);
					if(row==0)
					{
						System.out.println("The author id is not valid");
					}
					else if(row==1)
					{
						System.out.println("Successfully Updated");
					}
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
				break;
			case 3:
				try
				{
					System.out.println("Enter the authorid:");
					id=scan.nextInt();
					row=service.delete(id);
					if(row==0)
					{
						System.out.println("The author id is not valid");
					}
					else if(row==1)
					{
						System.out.println("Successfully Deleted");
					}
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
				
				break;
			case 4:
				try
				{
					System.out.println("Enter the authorid:");
					id=scan.nextInt();
					ResultSet rs=service.select(id);
					System.out.println("Details:\n");
					while(rs.next())
					{
						System.out.println("id="+rs.getInt(1)+"\nfirst name="+rs.getString(2)+"\nmiddle name="+rs.getString(3)+"\nlast name="+rs.getString(4)+"\nphone number="+rs.getString(5));
					}
				}
				catch(SQLException e)
				{
					System.out.println(e);
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

