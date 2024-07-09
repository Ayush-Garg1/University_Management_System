use universitymanagementsystem;

show tables;

select * from student;

create table if not exists login(
	username varchar(25),
    password varchar(25)
);

create table if not exists student(
	name varchar(40),
    fname varchar(40),
    rollno varchar(20),
    dob varchar(40),
    address varchar(100),
    phone varchar(20),
    email varchar(40),
    class_x varchar(20),
    class_xii varchar(20),
    adhaar varchar(20),
    course varchar(40),
    branch varchar(40)
);

create table if not exists teacher(
	name varchar(40),
    fname varchar(40),
    empid varchar(20),
    dob varchar(40),
    address varchar(100),
    phone varchar(20),
    email varchar(40),
    class_x varchar(20),
    class_xii varchar(20),
    adhaar varchar(20),
    qualification varchar(40),
    department varchar(40)
);

create table if not exists studentleave(
	rollno varchar(20),
    date varchar(50),
    duration varchar(20)
);

create table if not exists teacherleave(
	empid varchar(20),
    date varchar(50),
    duration varchar(20)
);

create table if not exists subject(
	rollno varchar(20), 
    semester varchar(20),
    subject1 varchar(50),
    subject2 varchar(50),
    subject3 varchar(50),
    subject4 varchar(50),
    subject5 varchar(50)
);

create table if not exists marks(
	rollno varchar(20), 
    semester varchar(20),
    marks1 varchar(50),
    marks2 varchar(50),
    marks3 varchar(50),
    marks4 varchar(50),
    marks5 varchar(50)
);

create table if not exists fee(
	course varchar(50),
    semester1 varchar(10),
    semester2 varchar(10),
    semester3 varchar(10),
    semester4 varchar(10),
    semester5 varchar(10),
    semester6 varchar(10),
    semester7 varchar(10),
    semester8 varchar(10)
);

create table if not exists collegefee(
	rollno varchar(20),
    course varchar(20),
    branch varchar(20),
    semester varchar(20),
    total varchar(20)
);

show tables;

set SQL_SAFE_UPDATES = 0;

insert into login values('admin', '12345');

insert into fee values("B.Tech", "90000", "92000", "89000", "92000", "87000", "86000", "88000", "88000");
insert into fee values("B.Sc", "80000", "70000", "70000", "70000", "70000", "70000", "", "");
insert into fee values("M.Tech", "80000", "75000", "75000", "75000", "", "", "", "");
insert into fee values("BCA", "77000", "70000", "70000", "70000", "70000", "70000", "", "");
insert into fee values("MCA", "65000", "60000", "60000", "60000", "", "", "", "");

