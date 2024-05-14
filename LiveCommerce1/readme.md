drop table cart;
drop table categories;
drop table kakaopayments;
drop table payments;
drop table livechat;
drop table livestreams;
drop table orders;
drop table reviews;
DROP TABLE IF EXISTS Events;
drop table products;
drop table tbl_users_auth;
drop table users;

-- 사용자 정보 테이블
CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT, -- 사용자 ID
    Username VARCHAR(20) NOT NULL, -- 사용자 이름
    Email VARCHAR(50) NOT NULL, -- 사용자 이메일
    Password VARCHAR(100) NOT NULL, -- 사용자 비밀번호
    ShippingAddress VARCHAR(1000) NOT NULL, -- 배송 주소
    ShippingPostalCode VARCHAR(20) NOT NULL, -- 배송 우편번호
    enabled char(1) default '0'
);

-- 제품 정보 테이블
CREATE TABLE Products (
    ProductID INT PRIMARY KEY AUTO_INCREMENT, -- 제품 ID
    ProductName VARCHAR(50) NOT NULL, -- 제품명
    Description TEXT, -- 제품 설명
    Price INT NOT NULL, -- 제품 가격
    Photo VARCHAR(255) -- 제품 사진 경로
);

-- 주문 정보 테이블
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY AUTO_INCREMENT, -- 주문 ID
    UserID INT, -- 주문한 사용자의 ID (외래키)
    ProductID INT, -- 주문한 제품의 ID (외래키)
    Quantity INT, -- 주문 수량
    ShippingAddress VARCHAR(1000) NOT NULL, -- 배송 주소
    ShippingPostalCode VARCHAR(20) NOT NULL, -- 배송 우편번호
    OrderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 주문 일자
    FOREIGN KEY (UserID) REFERENCES Users(UserID), -- 사용자 테이블과의 외래키 관계
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID) -- 제품 테이블과의 외래키 관계
);

-- 결제 정보 테이블
CREATE TABLE Payments (
    PaymentID INT PRIMARY KEY AUTO_INCREMENT, -- 결제 ID
    OrderID INT, -- 주문 ID (외래키)
    PaymentMethod VARCHAR(50) NOT NULL, -- 결제 수단
    Amount INT NOT NULL, -- 결제 금액
    PaymentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 결제 일자
    Status VARCHAR(50), -- 결제 상태
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) -- 주문 테이블과의 외래키 관계
);

-- 라이브 채팅 테이블
CREATE TABLE LiveChat (
    ChatID INT PRIMARY KEY AUTO_INCREMENT, -- 채팅 ID
    UserID INT, -- 사용자 ID (외래키)
    Message TEXT, -- 채팅 메시지
    ChatTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 채팅 시간
    FOREIGN KEY (UserID) REFERENCES Users(UserID) -- 사용자 테이블과의 외래키 관계
);

-- 장바구니 테이블
CREATE TABLE Cart (
    CartID INT PRIMARY KEY AUTO_INCREMENT, -- 장바구니 ID
    UserID INT, -- 사용자 ID (외래키)
    ProductID INT, -- 제품 ID (외래키)
    Quantity INT, -- 제품 수량
    FOREIGN KEY (UserID) REFERENCES Users(UserID), -- 사용자 테이블과의 외래키 관계
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID) -- 제품 테이블과의 외래키 관계
);

-- 카카오톡 결제 정보 테이블
CREATE TABLE KakaoPayments (
    PaymentID INT PRIMARY KEY AUTO_INCREMENT, -- 결제 ID
    OrderID INT, -- 주문 ID (외래키)
    PaymentMethod VARCHAR(50) NOT NULL, -- 결제 수단
    Amount INT NOT NULL, -- 결제 금액
    PaymentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 결제 일자
    KakaoTransactionID VARCHAR(100) NOT NULL, -- 카카오 거래 ID
    Status VARCHAR(50), -- 결제 상태
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) -- 주문 테이블과의 외래키 관계
);

-- 이벤트 정보 테이블
CREATE TABLE Events (
    EventID INT PRIMARY KEY AUTO_INCREMENT, -- 이벤트 ID
    EventName VARCHAR(100) NOT NULL, -- 이벤트명
    Description TEXT, -- 이벤트 설명
    EventDate TIMESTAMP NOT NULL, -- 이벤트 일자
    Location VARCHAR(200) NOT NULL, -- 이벤트 장소
    Photo VARCHAR(255), -- 이벤트 사진 경로
    ProductID INT, -- 상품 ID (외래키)
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID) -- 제품 테이블과의 외래키 관계
);

-- 카테고리 정보 테이블
CREATE TABLE Categories (
    CategoryID INT PRIMARY KEY AUTO_INCREMENT, -- 카테고리 ID
    CategoryName VARCHAR(50) NOT NULL -- 카테고리명
);

-- 후기 정보 테이블
CREATE TABLE Reviews (
    ReviewID INT PRIMARY KEY AUTO_INCREMENT, -- 후기 ID
    UserID INT, -- 사용자 ID (외래키)
    ProductID INT, -- 제품 ID (외래키)
    Rating INT NOT NULL, -- 평점
    Comment TEXT, -- 후기 내용
    ReviewDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 후기 작성 일자
    FOREIGN KEY (UserID) REFERENCES Users(UserID), -- 사용자 테이블과의 외래키 관계
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID) -- 제품 테이블과의 외래키 관계
);

CREATE TABLE tbl_users_auth (
    userid INT NOT NULL,
    auth VARCHAR(100) NOT NULL,
    CONSTRAINT fk_users_auth FOREIGN KEY (userid) REFERENCES Users(UserID)
);
CREATE TABLE LiveStreams (
    StreamID INT PRIMARY KEY AUTO_INCREMENT, -- 스트리밍 ID
    Title VARCHAR(100) NOT NULL, -- 제목
    VideoID VARCHAR(50) NOT NULL, -- 비디오 ID
    Description TEXT, -- 설명
    StartTime TIMESTAMP NOT NULL, -- 시작 시간
    EndTime TIMESTAMP, -- 종료 시간
    Photo VARCHAR(255), -- 사진의 경로를 저장할 열
    ProductID INT, -- 외래 키: 상품 ID
    ChatID INT, -- 외래 키: 채팅 ID
    FOREIGN KEY (ProductID) REFERENCES products(ProductID),
    FOREIGN KEY (ChatID) REFERENCES livechat(ChatID)
);

INSERT INTO Products (ProductName, Description, Price, Photo) VALUES
('Product 1', 'Description of Product 1', 100, 'https://wallpapers.com/images/hd/1080x1920-ugd930ckdcujq44s.jpg'),
('Product 2', 'Description of Product 2', 150, 'https://wallpapers.com/images/hd/1080x1920-ugd930ckdcujq44s.jpg'),
('Product 3', 'Description of Product 3', 200, 'https://wallpapers.com/images/hd/1080x1920-ugd930ckdcujq44s.jpg'),
('Product 4', 'Description of Product 4', 120, 'https://wallpapers.com/images/hd/1080x1920-ugd930ckdcujq44s.jpg'),
('Product 5', 'Description of Product 5', 180, 'https://wallpapers.com/images/hd/1080x1920-ugd930ckdcujq44s.jpg'),
('Product 6', 'Description of Product 6', 90, 'https://wallpapers.com/images/hd/1080x1920-ugd930ckdcujq44s.jpg'),
('Product 7', 'Description of Product 7', 160, 'https://wallpapers.com/images/hd/1080x1920-ugd930ckdcujq44s.jpg'),
('Product 8', 'Description of Product 8', 220, 'https://wallpapers.com/images/hd/1080x1920-ugd930ckdcujq44s.jpg'),
('Product 9', 'Description of Product 9', 130, 'https://wallpapers.com/images/hd/1080x1920-ugd930ckdcujq44s.jpg'),
('Product 10', 'Description of Product 10', 170, 'https://wallpapers.com/images/hd/1080x1920-ugd930ckdcujq44s.jpg');



select * from cart;
select * from  categories;
select * from  events;
select * from  kakaopayments;
select * from  livechat;
select * from  livestreams;
select * from  orders;
select * from  payments;
select * from  products;
select * from  reviews;
select * from  tbl_users_auth;
select * from users;

SELECT * FROM Cart WHERE UserID = 3;
SELECT userID FROM Users WHERE username = 'testa';

INSERT INTO Users (Username, Email, Password, ShippingAddress, ShippingPostalCode, enabled) 
VALUES ('admin', 'admin@example.com', '$2a$10$06qnVd94XtZDPTiPz13bOegmExXVYx7Qe0Olj8SD/dy0n0mV2pe3m', 'Admin Address', '12345', '1');



select * from  products;
select * from cart;

SELECT c.*, p.productName, p.price
FROM cart c
JOIN products p ON c.productID = p.productID
WHERE c.userID = 8;


select *, p.productname

from cart c join products p
on c.ProductID = p.ProductID
where c.CartID = 7;

