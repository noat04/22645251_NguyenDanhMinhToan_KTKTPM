FROM nginx:latest

# Xóa các file mặc định của Nginx
RUN rm -rf /usr/share/nginx/html/*

# Copy file index.html từ máy host vào container
COPY index.html /usr/share/nginx/html/

# Expose cổng 80 ra ngoài
EXPOSE 80
