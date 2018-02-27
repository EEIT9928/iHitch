DROP TABLE BlockList;
DROP TABLE ALERT;
DROP TABLE PassDetail;
DROP TABLE Faq;
DROP TABLE Chat;
DROP TABLE BlackList;
DROP TABLE Rate;
DROP TABLE Ride;
DROP TABLE Car;
DROP TABLE Member;




CREATE TABLE Member (
   mid				int IDENTITY (2,2),
   email			varchar(100) NOT NULL UNIQUE,
   pwd				varchar(20) NOT NULL,
   firstName		varchar(20),
   lastName			varchar(20),
   gender			char(1),
   country			varchar(50),
   birthYear		int,
   photo			varbinary(max),
   phone			varchar(20),
   bio				varchar(max),
   licensePhoto		varbinary(max),
   phoneVerified	bit DEFAULT 0,
   emailVerified	bit DEFAULT 0,
   licenseVerified	bit DEFAULT 0,
   account			varchar(30),
   prefPaPet		int DEFAULT 2,
   prefPaSmoke		int DEFAULT 2,
   prefPaTalk		int DEFAULT 2,
   prefPaMusic		int DEFAULT 2,
   prefDrPet		int DEFAULT 2,
   prefDrSmoke		int DEFAULT 2,
   prefDrTalk		int DEFAULT 2,
   prefDrMusic		int DEFAULT 2,
   currentLv		int DEFAULT 1,
   regisDate		date DEFAULT GETDATE(),
   lastLog			datetime,
   malPoint			int DEFAULT 0,
   rate				decimal,
   rateReceived		int,
   ridesOffered		int,
   CONSTRAINT PK_MEMBER Primary KEY CLUSTERED (mid),
);

CREATE TABLE Car(
	carId			int IDENTITY (880000,1),
	carNo			varchar(20) NOT NULL UNIQUE,
	carBrand		varchar(50),
	carType			varchar(100),
	color			varchar(20),
	carDocPhoto		varbinary(max),
	pcFriendly		bit DEFAULT 0,
	mid				int NOT NULL,
	CONSTRAINT PK_CARS PRIMARY KEY CLUSTERED (carId),
	CONSTRAINT FK_CARS_MEMBER FOREIGN KEY (mid) REFERENCES MEMBER (mid) ON DELETE CASCADE
);

CREATE TABLE Ride (
	rideId					int	IDENTITY (1,2),
	rideDate				date NOT NULL,
	rideTime				time NOT NULL,
	start					varchar(20) NOT NULL,
	dest					varchar(20) NOT NULL,
	pickUpZone				varchar(20) NOT NULL,
	dropOffZone				varchar(20) NOT NULL,
	duration				time NOT NULL,
	price					int NOT NULL,
	capacity				int NOT NULL,
	driverId				int NOT NULL,
	carId					int NOT NULL,
	note					varchar(max),
	history					bit DEFAULT 0,
	lugPref					int,
	CONSTRAINT PK_RIDE PRIMARY KEY CLUSTERED (rideId),
	CONSTRAINT FK_RIDE_MEMBER FOREIGN KEY (driverId) REFERENCES Member(mid) ON DELETE CASCADE,
	CONSTRAINT FK_RIDE_CAR FOREIGN KEY (carId) REFERENCES CAR(carId),
);

CREATE TABLE PassDetail(
detailId		int IDENTITY (990000,1),
mid				int NOT NULL,
rideId			int NOT NULL,
seatsBooked		int NOT NULL DEFAULT 1,
bookTime		datetime DEFAULT GETDATE(),
confirmed		bit DEFAULT 0,
CONSTRAINT PK_PASSDETAIL PRIMARY KEY CLUSTERED (detailId),
CONSTRAINT FK_PASSDETAIL_MEMBER FOREIGN KEY (mid) REFERENCES Member (mid),
CONSTRAINT FK_PASSDETAIL_RIDE FOREIGN KEY (rideId) REFERENCES Ride (rideId) ON DELETE CASCADE,
);

CREATE TABLE Alert(
	alertId			int IDENTITY (1190000,1),
	mid				int NOT NULL,
	start			varchar(20) NOT NULL,
	dest			varchar(20) NOT NULL,
	alertDate		date NOT NULL,
	alerted			bit DEFAULT 0
	CONSTRAINT PK_ALERT PRIMARY KEY CLUSTERED (alertId),
	CONSTRAINT FK_ALERT_MEMBER FOREIGN KEY (mid) REFERENCES Member (mid) ON DELETE CASCADE,
);

CREATE TABLE Rate(
	rateId		int IDENTITY (6660000,1),
	fromMid		int NOT NULL DEFAULT -2,
	toMid		int NOT NULL,
	star		int NOT NULL,
	comment		varchar(max),
	rateDate	datetime DEFAULT GETDATE(),
	rated		bit default 0,
	rideId		int NOT NULL,
	CONSTRAINT PK_RATE PRIMARY KEY CLUSTERED (rateId),
	CONSTRAINT FK_RATE_RIDE FOREIGN KEY (rideId) REFERENCES Ride (rideId),
	CONSTRAINT FK_RATE_FROM FOREIGN KEY (fromMid) REFERENCES MEMBER (mid) ON DELETE SET DEFAULT,
	CONSTRAINT FK_RATE_TO FOREIGN KEY (toMid) REFERENCES MEMBER (mid) --ON DELETE CASCADE,
);

CREATE TABLE Faq(
qid				int IDENTITY (220000,1),
rideId			int NOT NULL,
fromMid			int NOT NULL,
qtype			int NOT NULL,
content			varchar(max) NOT NULL,
response		varchar(max),
isResponsed	bit DEFAULT 0,
CONSTRAINT PK_FAQ PRIMARY KEY CLUSTERED (qid),
CONSTRAINT FK_FAQ_RIDE FOREIGN KEY(rideId) REFERENCES RIDE (rideId)	ON DELETE CASCADE,
CONSTRAINT FK_FAQ_FROM FOREIGN KEY(fromMid) REFERENCES MEMBER (mid) --ON DELETE SET NULL,
);

CREATE TABLE Chat(
chatId			int IDENTITY(770000,1),
fromMid			int NOT NULL,
toMid			int NOT NULL,
chatDatetime	datetime DEFAULT GETDATE() NOT NULL,
content			varchar(max),
photo			varbinary(max),
isRead			bit DEFAULT 0,
CONSTRAINT PK_CHAT PRIMARY KEY CLUSTERED (chatId),
CONSTRAINT FK_CHAT_FROM FOREIGN KEY(fromMid) REFERENCES MEMBER (mid) ,
CONSTRAINT FK_CHAT_TO FOREIGN KEY(toMid) REFERENCES MEMBER (mid),
);

CREATE TABLE BlackList(
blackId				int IDENTITY (440000,1), 
fromMid				int NOT NULL DEFAULT -2,
toMid				int NOT NULL,
rideId				int NOT NULL,
reportType			int NOT NULL,
content				varchar(max),
isDealed			bit DEFAULT 0,
CONSTRAINT PK_BLACK_LIST PRIMARY KEY CLUSTERED (blackId),
CONSTRAINT FK_BLACK_LIST_RIDE FOREIGN KEY(rideId) REFERENCES RIDE (rideId),
CONSTRAINT FK_BLACK_LIST_FROM FOREIGN KEY(fromMid) REFERENCES MEMBER (mid) ON DELETE SET DEFAULT,
CONSTRAINT FK_BLACK_LIST_TO FOREIGN KEY(toMid) REFERENCES MEMBER (mid) --ON DELETE CASCADE,
);

CREATE TABLE BlockList(
blockId		int IDENTITY (4040000,1),
fromMid		int NOT NULL,
toMid		int NOT NULL,
CONSTRAINT PK_BLOCK_LIST PRIMARY KEY CLUSTERED (blockId),
CONSTRAINT FK_BLOCK_LIST_FROM FOREIGN KEY(fromMid) REFERENCES MEMBER (mid) ,
CONSTRAINT FK_BLOCK_LIST_TO FOREIGN KEY(toMid) REFERENCES MEMBER (mid) ON DELETE CASCADE,
);


INSERT INTO MEMBER (email,pwd) values ('aaa@aaa','aaa');
INSERT INTO MEMBER (email,pwd) values ('bbb@bbb','bbb');
INSERT INTO MEMBER (email,pwd) values ('ccc@ccc','ccc');
INSERT INTO MEMBER (email,pwd) values ('ddd@ddd','ddd');
INSERT INTO MEMBER (email,pwd) values ('eee@eee','eee');
INSERT INTO MEMBER (email,pwd) values ('fff@fff','fff');
INSERT INTO MEMBER (email,pwd) values ('ggg@ggg','ggg');
INSERT INTO MEMBER (email,pwd) values ('hhh@hhh','hhh');
INSERT INTO MEMBER (email,pwd) values ('iii@iii','iii');
INSERT INTO MEMBER (email,pwd) values ('jjj@jjj','jjj');


INSERT INTO CAR (carNo,mid) values ('999-AAA',4);
INSERT INTO CAR (carNo,mid) values ('888-BBB',6);
INSERT INTO CAR (carNo,mid) values ('777-CCC',8);
INSERT INTO CAR (carNo,mid) values ('666-DDD',10);
INSERT INTO CAR (carNo,mid) values ('555-EEE',12);
INSERT INTO CAR (carNo,mid) values ('444-FFF',14);



INSERT INTO Ride (rideDate,rideTime,start,dest,pickUpZone,dropOffZone,duration,price,capacity,driverId,carId)
values ('2018-02-14','3:30','台北','高雄','信義區','三民區','3:30',150,4,6,880003)
INSERT INTO Ride (rideDate,rideTime,start,dest,pickUpZone,dropOffZone,duration,price,capacity,driverId,carId)
values ('2018-02-15','1:30','新北','台南','三峽區','仁武區','1:30',150,4,8,880004)
INSERT INTO Ride (rideDate,rideTime,start,dest,pickUpZone,dropOffZone,duration,price,capacity,driverId,carId)
values ('2018-02-15','1:30','桃園','台中','大溪區','南屯區','1:30',150,4,8,880005)
INSERT INTO Ride (rideDate,rideTime,start,dest,pickUpZone,dropOffZone,duration,price,capacity,driverId,carId)
values ('2018-02-14','3:30','台北','高雄','信義區','三民區','3:30',150,4,6,880003)
INSERT INTO Ride (rideDate,rideTime,start,dest,pickUpZone,dropOffZone,duration,price,capacity,driverId,carId)
values ('2018-02-15','1:30','新北','台南','三峽區','仁武區','1:30',150,4,8,880004)
INSERT INTO Ride (rideDate,rideTime,start,dest,pickUpZone,dropOffZone,duration,price,capacity,driverId,carId)
values ('2018-02-15','1:30','桃園','台中','大溪區','南屯區','1:30',150,4,8,880005)


INSERT INTO PassDetail (mid,rideId,seatsBooked) values (6,7,1)
INSERT INTO PassDetail (mid,rideId,seatsBooked) values (6,7,1)
INSERT INTO PassDetail (mid,rideId,seatsBooked) values (8,9,2)

INSERT INTO Alert (mid,start,dest,alertDate) values (6,'台北','台東','2018-2-12')
INSERT INTO Alert (mid,start,dest,alertDate) values (8,'台北','屏東','2018-2-16')
INSERT INTO Alert (mid,start,dest,alertDate) values (10,'新竹','台中','2018-2-16')

INSERT INTO Rate (fromMid,toMid,star,rideId) values (6,8,5,7)
INSERT INTO Rate (fromMid,toMid,star,rideId) values (6,10,5,11)
INSERT INTO Rate (fromMid,toMid,star,rideId) values (8,10,5,9)

INSERT INTO Faq (rideId,fromMid,qtype,content) values (7,6,99,'初始資料')
INSERT INTO Faq (rideId,fromMid,qtype,content) values (7,8,99,'初始資料')
INSERT INTO Faq (rideId,fromMid,qtype,content) values (7,10,99,'初始資料')

INSERT INTO Chat (fromMid,toMid,chatDatetime) values (6,8,'2020-2-29')
INSERT INTO Chat (fromMid,toMid,chatDatetime) values (8,10,'2020-2-29')
INSERT INTO Chat (fromMid,toMid,chatDatetime) values (10,6,'2020-2-29')

INSERT INTO BlackList (fromMid,toMid,rideId,reportType) values (6,8,7,5)
INSERT INTO BlackList (fromMid,toMid,rideId,reportType) values (6,10,9,3)
INSERT INTO BlackList (fromMid,toMid,rideId,reportType) values (6,12,9,5)
INSERT INTO BlackList (fromMid,toMid,rideId,reportType) values (6,10,5,3)

INSERT INTO BlockList (fromMid,toMid) values (6,10)
INSERT INTO BlockList (fromMid,toMid) values (6,8)
INSERT INTO BlockList (fromMid,toMid) values (8,10)