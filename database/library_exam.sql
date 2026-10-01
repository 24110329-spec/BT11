CREATE DATABASE IF NOT EXISTS library_exam_24110329
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE library_exam_24110329;

DROP TABLE IF EXISTS rating;
DROP TABLE IF EXISTS book_author;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(150) NOT NULL UNIQUE,
    fullName VARCHAR(150) NOT NULL,
    phone VARCHAR(30),
    passwd VARCHAR(255) NOT NULL,
    signup_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_login DATETIME NULL,
    is_admin BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE author (
    author_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(150) NOT NULL,
    date_of_birth DATE
);

CREATE TABLE books (
    bookid BIGINT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(30) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL,
    publisher VARCHAR(150),
    price DECIMAL(12,2) DEFAULT 0,
    description TEXT,
    publish_date DATE,
    cover_image VARCHAR(500),
    quantity INT NOT NULL DEFAULT 0
);

CREATE TABLE book_author (
    bookid BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    PRIMARY KEY (bookid, author_id),
    CONSTRAINT fk_ba_book FOREIGN KEY (bookid) REFERENCES books(bookid) ON DELETE CASCADE,
    CONSTRAINT fk_ba_author FOREIGN KEY (author_id) REFERENCES author(author_id) ON DELETE CASCADE
);

CREATE TABLE rating (
    userid BIGINT NOT NULL,
    bookid BIGINT NOT NULL,
    rating INT NOT NULL,
    review_text VARCHAR(1000),
    PRIMARY KEY (userid, bookid),
    CONSTRAINT fk_rating_user FOREIGN KEY (userid) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_rating_book FOREIGN KEY (bookid) REFERENCES books(bookid) ON DELETE CASCADE,
    CONSTRAINT ck_rating CHECK (rating BETWEEN 1 AND 10)
);

INSERT INTO users(email, fullName, phone, passwd, is_admin)
VALUES
('admin@gmail.com','Administrator','0900000001','123456',TRUE),
('user@gmail.com','Nguyen Van User','0900000002','123456',FALSE);

INSERT INTO author(author_name,date_of_birth) VALUES
('Robert C. Martin','1952-12-05'),
('Joshua Bloch','1961-08-28'),
('Martin Fowler','1963-12-18'),
('Eric Evans','1961-01-01'),
('Herbert Schildt','1951-05-23'),
('James Clear','1986-01-01'),
('Andrew Hunt','1964-12-25'),
('David Thomas','1956-01-01');

INSERT INTO books(isbn,title,publisher,price,description,publish_date,cover_image,quantity) VALUES
('9780132350884','Clean Code','Prentice Hall',350000,'A handbook of agile software craftsmanship.','2008-08-01','https://covers.openlibrary.org/b/isbn/9780132350884-L.jpg',10),
('9780134494166','Effective Java','Addison-Wesley',420000,'Best practices for the Java platform.','2018-01-06','https://covers.openlibrary.org/b/isbn/9780134494166-L.jpg',12),
('9780134757599','Refactoring','Addison-Wesley',390000,'Improving the design of existing code.','2018-11-19','https://covers.openlibrary.org/b/isbn/9780134757599-L.jpg',8),
('9780321125217','Domain-Driven Design','Addison-Wesley',450000,'Tackling complexity in the heart of software.','2003-08-30','https://covers.openlibrary.org/b/isbn/9780321125217-L.jpg',6),
('9780071808552','Java: The Complete Reference','McGraw-Hill',500000,'Comprehensive Java programming reference.','2014-12-01','https://covers.openlibrary.org/b/isbn/9780071808552-L.jpg',15),
('9780735211292','Atomic Habits','Avery',300000,'Tiny changes, remarkable results.','2018-10-16','https://covers.openlibrary.org/b/isbn/9780735211292-L.jpg',20),
('9780135957059','The Pragmatic Programmer','Addison-Wesley',430000,'Your journey to mastery.','2019-09-13','https://covers.openlibrary.org/b/isbn/9780135957059-L.jpg',9),
('9780134034287','Design Patterns','Addison-Wesley',470000,'Elements of reusable object-oriented software.','1994-10-21','https://covers.openlibrary.org/b/isbn/9780134034287-L.jpg',7);

INSERT INTO book_author(bookid,author_id) VALUES
(1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(7,8),(8,3);

INSERT INTO rating(userid,bookid,rating,review_text) VALUES
(2,1,9,'Nội dung thực tế và dễ áp dụng.'),
(2,2,10,'Sách Java rất hữu ích.');

DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 user_id BIGINT NOT NULL,
 total_amount DECIMAL(12,2) NOT NULL,
 payment_method VARCHAR(30) NOT NULL DEFAULT 'COD',
 status VARCHAR(30) NOT NULL DEFAULT 'PENDING',
 receiver_name VARCHAR(150) NOT NULL,
 receiver_phone VARCHAR(30) NOT NULL,
 receiver_address VARCHAR(500) NOT NULL,
 created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
 CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_items (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 order_id BIGINT NOT NULL,
 book_id BIGINT NOT NULL,
 quantity INT NOT NULL,
 unit_price DECIMAL(12,2) NOT NULL,
 CONSTRAINT fk_oi_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
 CONSTRAINT fk_oi_book FOREIGN KEY (book_id) REFERENCES books(bookid)
);


-- ============================================================
-- CẬP NHẬT CHỨC NĂNG LỊCH SỬ ĐẶT HÀNG + LỌC TRẠNG THÁI
-- Các trạng thái được dùng trong project:
-- PENDING    = Đơn hàng mới
-- CONFIRMED  = Đã xác nhận
-- PREPARING  = Chuẩn bị hàng
-- SHIPPING   = Vận chuyển
-- DELIVERING = Giao hàng
-- DELIVERED  = Đã giao
-- CANCELLED  = Đơn hàng hủy
-- RETURNED   = Đơn hàng hoàn
-- ============================================================

ALTER TABLE orders MODIFY status VARCHAR(30) NOT NULL DEFAULT 'PENDING';

CREATE INDEX idx_orders_user_status_created
ON orders(user_id, status, created_at);

-- ============================================================
-- DÙNG CÁC LỆNH DƯỚI ĐÂY ĐỂ ĐỔI TRẠNG THÁI KHI TEST
-- Ví dụ đơn hàng có id = 1
-- ============================================================

-- Đơn hàng mới
-- UPDATE orders SET status='PENDING' WHERE id=1;

-- Đã xác nhận
-- UPDATE orders SET status='CONFIRMED' WHERE id=1;

-- Chuẩn bị hàng
-- UPDATE orders SET status='PREPARING' WHERE id=1;

-- Vận chuyển
-- UPDATE orders SET status='SHIPPING' WHERE id=1;

-- Giao hàng
-- UPDATE orders SET status='DELIVERING' WHERE id=1;

-- Đã giao
-- UPDATE orders SET status='DELIVERED' WHERE id=1;

-- Đơn hàng hủy
-- UPDATE orders SET status='CANCELLED' WHERE id=1;

-- Đơn hàng hoàn
-- UPDATE orders SET status='RETURNED' WHERE id=1;

-- Kiểm tra trạng thái các đơn
-- SELECT id, user_id, total_amount, status, created_at
-- FROM orders ORDER BY id DESC;
