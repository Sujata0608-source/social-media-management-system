/**
 * This is a Social Media database Management System
 */
package dbms;
import java.sql.*;
import java.util.Scanner;
/**
 * @author Sujata
 *
 */


public class SocialMediaApp {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/social_media";
		String username ="root";
		String password="RajakSujata@0608";
		String query="select * from users";
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username,password);
		Statement statement=connection.createStatement();
		ResultSet resultSet;
		PreparedStatement std=connection.prepareStatement(query);;
		
		String options="Enter 0 to finish process. \n"
		+"Enter 1 to view Users. \n"
		+"Enter 2 to view Pages. \n"
		+"Enter 3 to add New User. \n"
		+"Enter 4 to delete User. \n"
		+"Enter 5 to update the User's Password. \n"
		+"Enter 6 to show Friends Count. \n"
		+"Enter 7 to show Comments Count. \n"
		+"Enter 8 to view User Profiles. \n"
		+"Enter 9 to view Post Details. \n"
		+"Enter 10 to see all comments using only post_id. \n"
		+"Enter 11 to see friends list, User ID and gender. \n"
		+"Enter 12 to see user details of all pages. \n"
		+"Enter 13 to delete any comment along with the likes on the comment.\n"
		+"Enter 14 to see user who liked any post comments.\n" +"Enter your choice: \n";
		boolean flag=true;
		int opt=0,cnt=0,id;
		while(flag) {
			System.out.println(options);
			opt=scanner.nextInt();
			switch(opt) {
			case 0:
				flag=false;
				break;
			case 1:
				try {
				query="select * from users";
				resultSet=statement.executeQuery(query);
				System.out.println("USER_ID | EMAIL_ID  | PHONE_NO  |  PASSWORD | FIRST_NAME | LAST_NAME | CITY | PINCODE |  DOB  | GENDER | AGE");
				while(resultSet.next()) {
				String userdata=resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getString(4)+" | "+resultSet.getString(5)+" | "+resultSet.getString(6)+" | "+resultSet.getString(7)+" | "+resultSet.getInt(8)+" | "+resultSet.getString(9)+" | "+resultSet.getString(10)+" | "+resultSet.getInt(11);
				System.out.println(userdata);
				}
				}
				catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 2:
				try {
				query="select * from pages";
				resultSet=statement.executeQuery(query);
				System.out.println("PAGE_ID | PAGE_NAME | PAGE_CONTENT");
				while(resultSet.next()) {
				String userdata=resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3);
				System.out.println(userdata);
				}
				}
				catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 3:
				try {
				query="insert into users(Email_ID,Phone_No,Pass_word,First_name,Last_name,City,PinCode,DOB,Gender) values (?,?,?,?,?,?,?,DATE ?,?)";
				std=connection.prepareStatement(query);
				String Emailid,phoneno,Password,firstname,lastname,city,dob,gender;
				int pincode;
				System.out.println("Enter user's email id. ");    Emailid=scanner.next();  ((PreparedStatement) std).setString(1,Emailid);
				System.out.println("Enter 10 digit phone no. ");    phoneno=scanner.next();   ((PreparedStatement) std).setString(2,phoneno);
				System.out.println("Enter user password. ");    Password=scanner.next();    ((PreparedStatement) std).setString(3,Password);
				System.out.println("Enter first name. ");    firstname=scanner.next();   ((PreparedStatement) std).setString(4,firstname);
				System.out.println("Enter last name. ");    lastname=scanner.next();   ((PreparedStatement) std).setString(5,lastname);
				System.out.println("Enter city. ");    city=scanner.next();    ((PreparedStatement) std).setString(6,city);
				System.out.println("Enter pincode. ");    pincode=scanner.nextInt();  ((PreparedStatement) std).setInt(7,pincode);
				System.out.println("Enter date of birth in yyyy-mm-dd format. ");    dob=scanner.next();  ((PreparedStatement) std).setString(8,dob);
				System.out.println("Enter gender 'M' or 'F'. ");    gender=scanner.next(); ((PreparedStatement) std).setString(9,gender);
				cnt= (int) ((PreparedStatement) std).executeUpdate();
				System.out.print(cnt+" row/s affected !!! \n");
				}
				catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 4:
				try {
				query ="delete from users where User_ID = ?";
				std=connection.prepareStatement(query);
				System.out.println("Enter user id which you want to delete");
			    id=scanner.nextInt();
				std.setInt(1, id);
				cnt= std.executeUpdate();
				System.out.print(cnt+" row/s affected !!! \n");
				}
				catch(Exception e) {
					System.out.println(e);
				}
				break;
				
			case 5:
				try {
				query ="update users set Pass_word= ? where User_ID = ?";
				std=connection.prepareStatement(query);
				System.out.println("Enter user id to change password");
				id=scanner.nextInt();
				System.out.println("Enter your new password. ");
				String p=scanner.next();
				std.setString(1, p);
				std.setInt(2, id);
				cnt= std.executeUpdate();
				System.out.print(cnt+" row/s affected !!! \n");
				}
				catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 6:
				try {
					query="CALL `social_media`.`number_of_friends`()";
					resultSet=statement.executeQuery(query);
					System.out.println("USER_ID | COUNT_OF_FRIENDS");
					while(resultSet.next()) {
					String userdata=resultSet.getInt(1)+"  |  "+resultSet.getInt(2);
					System.out.println(userdata);
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 7:
				try {
				     System.out.println("Enter a post_id for which you want to see the number of comments:");
				     String p=scanner.next();
					query="SELECT number_of_Comments("+p+")";
					resultSet=statement.executeQuery(query);
					while(resultSet.next()) {
						System.out.println("Number of comments on post_id "+p+" are "+resultSet.getInt(1));
					}
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
				
			case 8:
				try {
					query="SELECT * from full_profile_of_users";
					resultSet=statement.executeQuery(query);
					System.out.println("USER_ID | EMAIL_ID | FIRST_NAME | DOB | NUMBER_OF_FRIENDS | NUMBER_OF_PAGES | NUMBER_OF_POSTS");
					while(resultSet.next()) {
					String userdata=resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getString(4)+" | "+resultSet.getInt(5)+" | "+resultSet.getInt(6)+" | "+resultSet.getInt(7);
					System.out.println(userdata);
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
				break;
				
			case 9:
				try {
					query="SELECT * from full_posts_details";
					resultSet=statement.executeQuery(query);
					System.out.println("POST_ID | USER_ID | USER_NAME | USER_AGE | POSTED_DATE | POST_CONTENT | POST_LIKES | POST_SHARES | POST_COMMENTS ");
					while(resultSet.next()) {
					String userdata=resultSet.getInt(1)+" | "+resultSet.getInt(2)+" | "+resultSet.getString(3)+" | "+resultSet.getInt(4)+" | "+resultSet.getString(5)+" | "+resultSet.getString(6)+" | "+resultSet.getInt(7)+" | "+resultSet.getInt(8)+" | "+resultSet.getInt(9);
					System.out.println(userdata);
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
				break;
			case 10:
				try {
					query="SELECT po.Post_ID,po.Post_content,po.Post_Date,pc.Comment_ID,pc.Comment_Content,pc.Commented_Date from posts as po natural join post_comments as pc order by po.Post_ID asc,pc.Comment_ID asc";
					resultSet=statement.executeQuery(query);
					System.out.println("POST_ID | POST_CONTENT | POSTED_DATE | COMMENT_ID | COMMENT_CONTENT | COMMENT_DATE");
					while(resultSet.next()) {
						String userdata=resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getInt(4)+" | "+resultSet.getString(5)+" | "+resultSet.getString(6);
						System.out.println(userdata);
					}
					
				}
				catch(Exception e) {
					System.out.println();
				}
				break;
			case 11:
				try {
					query="select f1.User_ID,u1.First_name,u1.Gender,f1.Friend_ID,u2.First_name,u2.Gender from friends as f1 natural join users as u1,users as u2 where f1.Friend_ID=u2.User_ID order by f1.User_id asc,f1.friend_id asc";
					resultSet=statement.executeQuery(query);
					System.out.println("USER_ID | FIRST_NAME | GENDER | FRIEND_ID | FRIEND_NAME | FRIEND_GENDER");
					while(resultSet.next()) {
						String userdata=resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getInt(4)+" | "+resultSet.getString(5)+" | "+resultSet.getString(6);
						System.out.println(userdata);
					}
				}
				catch(Exception e) {
					System.out.println();
				}
				break;
			case 12:
				try {
					query="select pg.Page_ID,pg.Page_name,pg.Page_Content,u.User_ID,u.First_name,u.AGE from pages as pg natural join page_likes as pl,users as u where pl.Page_User_ID=u.User_ID order by pg.Page_ID asc,u.User_ID asc";
					resultSet=statement.executeQuery(query);
					System.out.println("PAGE_ID | PAGE_NAME | PAGE_CONTENT | USER_ID | FIRST_NAME | AGE");
					while(resultSet.next()) {
						String userdata=resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3)+" | "+resultSet.getInt(4)+" | "+resultSet.getString(5)+" | "+resultSet.getInt(6);
						System.out.println(userdata);
					}
				}
				catch(Exception e) {
					System.out.println();
				}
				break;
			case 13:
				try {
					query ="delete from post_comments where Comment_ID = ?";
					std=connection.prepareStatement(query);
					System.out.println("Enter the comment id which you want to delete.");
				    id=scanner.nextInt();
					std.setInt(1, id);
					cnt= std.executeUpdate();
					System.out.print(cnt+" row/s affected !!! \n");
					try {
						query="select * from comments_like order by comment_ID";
						resultSet=statement.executeQuery(query);
						System.out.println("COMMENT_ID | COMMENT_LIKED_USER_ID");
						while(resultSet.next()) {
							String userdata=resultSet.getInt(1)+" | "+resultSet.getString(2);
							System.out.println(userdata);
						}
					}
					catch(Exception e) {
						System.out.println();
					}
					}
					catch(Exception e) {
						System.out.println(e);
					}
				break;
			case 14:
				try {
					query="select co.Post_ID,co.Comment_ID,co.Comment_Content,cl.Comment_liked_User_ID,u.First_name from post_comments as co natural join comments_like as cl, users as u where cl.Comment_liked_User_ID=u.User_ID order by co.Post_ID asc,co.Comment_ID,cl.Comment_liked_User_ID;";
					resultSet=statement.executeQuery(query);
					System.out.println("POST_ID | COMMENT_ID | COMMENT_CONTENT | COMMENT_LIKED_USER_ID | FIRST_NAME");
					while(resultSet.next()) {
						String userdata=resultSet.getInt(1)+" | "+resultSet.getInt(2)+" | "+resultSet.getString(3)+" | "+resultSet.getInt(4)+" | "+resultSet.getString(5);
						System.out.println(userdata);
					}
				}
				catch(Exception e) {
					System.out.println();
				}
				break;
			case 15:
				try {
					query="select co.Post_ID,co.Comment_ID,co.Comment_Content,cl.Comment_liked_User_ID,u.First_name from post_comments as co natural join comments_like as cl, users as u where cl.Comment_liked_User_ID=u.User_ID order by co.Post_ID asc,co.Comment_ID,cl.Comment_liked_User_ID;";
					resultSet=statement.executeQuery(query);
					System.out.println("POST_ID | COMMENT_ID | COMMENT_CONTENT | COMMENT_LIKED_USER_ID | FIRST_NAME");
					while(resultSet.next()) {
						String userdata=resultSet.getInt(1)+" | "+resultSet.getInt(2)+" | "+resultSet.getString(3)+" | "+resultSet.getInt(4)+" | "+resultSet.getString(5);
						System.out.println(userdata);
					}
				}
				catch(Exception e) {
					System.out.println();
				}
				break;
				
			}
			
			System.out.println("\n******************** \n");
		}
		
		
		
		statement.close();
		connection.close();
	}
	
}