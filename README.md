# 23110197_BuiHaiDuong_BTH2
CREATE DATABASE BTH02;
GO

USE BTH02;
GO

CREATE TABLE [Users] (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username NVARCHAR(50) NOT NULL UNIQUE,
    password NVARCHAR(255) NOT NULL,
    email NVARCHAR(100) NOT NULL UNIQUE,
    fullname NVARCHAR(100) NULL,
    phone NVARCHAR(20) NULL UNIQUE,
    avatar NVARCHAR(255) NULL,
    roleid INT DEFAULT 2,
    createdDate DATETIME DEFAULT GETDATE()
);
GO

CREATE TABLE Category (
    cate_id INT IDENTITY(1,1) PRIMARY KEY,
    cate_name NVARCHAR(100) NOT NULL,
    icons NVARCHAR(255) NULL
);

INSERT INTO [Users] (username, password, email, fullname, phone, roleid)
VALUES 
('admin', '123456', 'admin@example.com', N'Quản Trị Viên', '0909000001', 1),
('user01', '123456', 'user01@example.com', N'Người Dùng 01', '0909000002', 2);
