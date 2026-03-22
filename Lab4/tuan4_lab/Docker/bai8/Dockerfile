# Sử dụng image PostgreSQL phiên bản 15
FROM postgres:15

# Thiết lập các biến môi trường cấu hình thông tin kết nối mặc định
ENV POSTGRES_USER=myuser
ENV POSTGRES_PASSWORD=mypassword
ENV POSTGRES_DB=main_db

# Chép file cấu trúc và dữ liệu SQL (init.sql) vào thư mục /docker-entrypoint-initdb.d/ trong container.
# Tất cả các files .sql trong thư mục này sẽ tự động được chạy khi container được khởi tạo lần đầu tiên.
COPY init.sql /docker-entrypoint-initdb.d/
