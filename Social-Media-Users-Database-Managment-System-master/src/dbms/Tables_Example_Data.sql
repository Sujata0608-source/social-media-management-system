insert into users (Email_ID,Phone_No,Pass_word,First_name,Last_name,City,PinCode,DOB,Gender) values ('sujata.rajak@gmail.com','7895546456','Sujata@123','sujata','rajak','mumbai',400051,DATE '2001-08-15','F');
insert into users (Email_ID,Phone_No,Pass_word,First_name,Last_name,City,PinCode,DOB,Gender) values ('priya.sharma@gmail.com','9795546456','Priya@123','priya','sharma','pune',411001,DATE '2001-09-06','F');
insert into users (Email_ID,Phone_No,Pass_word,First_name,Last_name,City,PinCode,DOB,Gender) values ('rahul.verma@gmail.com','9725546456','Rahul@123','rahul','verma','bangalore',560001,DATE '2004-01-15','M');
insert into users (Email_ID,Phone_No,Pass_word,First_name,Last_name,City,PinCode,DOB,Gender) values ('ananya.das@gmail.com','9745546456','Ananya@123','ananya','das','kolkata',743126,DATE '2000-02-02','F');
insert into users (Email_ID,Phone_No,Pass_word,First_name,Last_name,City,PinCode,DOB,Gender) values ('arjun.mehta@gmail.com','9785546456','Arjun@123','arjun','mehta','delhi',110025,DATE '2006-12-15','M');
select * from users;


insert into friends values(1,2);
insert into friends values(1,3);
insert into friends values(1,4);
insert into friends values(2,3);
insert into friends values(5,3);
insert into friends values(4,3);
insert into friends values(1,5);
select * from friends;


insert into pages(Page_Name,Page_Content) values("Java Developers India","Programming Community");
insert into pages(Page_Name,Page_Content) values("Mumbai Food Lovers","Restaurant Reviews");
insert into pages(Page_Name,Page_Content) values("Travel Diaries","Travel Experiences");
insert into pages(Page_Name,Page_Content) values("Fitness Freaks","Health & Workout");
insert into pages(Page_Name,Page_Content) values("Photography Club","Nature Photography");
insert into pages(Page_Name,Page_Content) values("Dance Club","Contemporary Lessons");
insert into pages(Page_Name,Page_Content) values("Music Group","Classical Music");
select * from pages;


insert into page_likes values(1,1);
insert into page_likes values(3,1);
insert into page_likes values(4,2);
insert into page_likes values(5,4);
insert into page_likes values(7,2);
insert into page_likes values(3,3);
insert into page_likes values(2,1);
insert into page_likes values(1,5);
select * from page_likes;


insert into posts(Posted_User_ID,Post_Date,Post_Content) values(2,DATE '2020-09-19','Started learning JDBC today!');
insert into posts(Posted_User_ID,Post_Date,Post_Content) values(3,DATE '2019-08-20','Weekend trip to Lonavala was amazing!');
insert into posts(Posted_User_ID,Post_Date,Post_Content) values(4,DATE '2018-07-21','Finally completed my database project.');
insert into posts(Posted_User_ID,Post_Date,Post_Content) values(5,DATE '2017-06-22','Coffee + Coding = Perfect Evening');
insert into posts(Posted_User_ID,Post_Date,Post_Content) values(1,DATE '2016-05-23','Learning SQL joins is actually fun!');
insert into posts(Posted_User_ID,Post_Date,Post_Content) values(2,DATE '2015-04-24','Happy to be free');
insert into posts(Posted_User_ID,Post_Date,Post_Content) values(3,DATE '2014-03-25','Dancing for peace and mental health');
insert into posts(Posted_User_ID,Post_Date,Post_Content) values(4,DATE '2013-02-26','Life couldnt be more better');
select * from posts;


insert into post_likes values(1,2);
insert into post_likes values(2,5);
insert into post_likes values(3,1);
insert into post_likes values(4,3);
insert into post_likes values(5,4);
insert into post_likes values(3,4);
insert into post_likes values(2,4);
insert into post_likes values(1,4);
select * from post_likes;


insert into post_shares values(1,2);
insert into post_shares values(4,5);
insert into post_shares values(3,3);
insert into post_shares values(2,4);
insert into post_shares values(5,3);
insert into post_shares values(5,2);
insert into post_shares values(6,1);
insert into post_shares values(6,3);
select * from post_shares;


insert into post_comments(Post_id,Commented_Date,Comment_Content,Commented_User_ID) values(4,DATE '2020-05-14','Great post!',3);
insert into post_comments(Post_id,Commented_Date,Comment_Content,Commented_User_ID) values(3,DATE '2019-03-23','Congratulations! ',4);
insert into post_comments(Post_id,Commented_Date,Comment_Content,Commented_User_ID) values(2,DATE '2018-04-22','Looks amazing!',5);
insert into post_comments(Post_id,Commented_Date,Comment_Content,Commented_User_ID) values(4,DATE '2017-05-11','Keep sharing! ',2);
insert into post_comments(Post_id,Commented_Date,Comment_Content,Commented_User_ID) values(5,DATE '2014-06-15','Very informative. ',3);
insert into post_comments(Post_id,Commented_Date,Comment_Content,Commented_User_ID) values(3,DATE '2013-07-21','Happy for you.',1);
insert into post_comments(Post_id,Commented_Date,Comment_Content,Commented_User_ID) values(2,DATE '2012-08-17','God Bless You.',1);
insert into post_comments(Post_id,Commented_Date,Comment_Content,Commented_User_ID) values(3,DATE '2011-09-01','This is the best',4);
select * from post_comments;


insert into comments_like values(2,1);
insert into comments_like values(4,2);
insert into comments_like values(3,3);
insert into comments_like values(6,4);
insert into comments_like values(2,5);
insert into comments_like values(3,4);
insert into comments_like values(4,3);
insert into comments_like values(5,2);
insert into comments_like values(6,1);
select * from comments_like;

