//用户信息表（id，名字，电话，密码）
CREATE TABLE USER(
	uid INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	phone INT(20),
	 PASSWORD VARCHAR(20)
);
ALTER TABLE USER ADD openid VARCHAR(50)
ALTER TABLE USER ADD wxname VARCHAR(50)
ALTER TABLE USER ADD wxphoto VARCHAR(50)

//房源信息基本表（id，地址，图片，价格，面积，类型（几室几厅），房源的预约量，房源简介）
CREATE TABLE house(
	hid INT PRIMARY KEY AUTO_INCREMENT,
	address VARCHAR(100),
	photo VARCHAR(300),	
	money DOUBLE,
	ared DOUBLE,
	TYPE VARCHAR(50),
	layaway INT(100),
	intro VARCHAR(300)
);

//预约表（id,预约人姓名，性别，电话，看房时间，当前时间）
CREATE TABLE order1(
	oid INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(100),
	sex VARCHAR(20),	
	phone INT(20),
	htime VARCHAR(500),
	ptime VARCHAR(500)	
);


//时间段
CREATE TABLE TIME(
	tid INT PRIMARY KEY AUTO_INCREMENT,
	times VARCHAR(200)	
);

//向表数据添加预约的时间段
INSERT INTO TIME VALUES(NULL,'8:00--10:00'),
			(NULL,'10:00--12:00'),
			(NULL,'14:00--16:00') ,
			(NULL,'16:00--18:00')
