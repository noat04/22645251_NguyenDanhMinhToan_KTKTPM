-- Tạo thêm một database tùy chỉnh
CREATE DATABASE custom_db;

-- Chuyển context sang database vừa tạo
\c custom_db;

-- Tạo bảng mẫu để kiểm tra
CREATE TABLE example_table (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Thêm một số dữ liệu mẫu
INSERT INTO example_table (name) VALUES 
('Example Data 1'),
('Example Data 2');
