# Sử dụng image golang chính thức chạy trên nền Alpine Linux (nhỏ gọn) làm môi trường build
FROM golang:1.21-alpine AS builder

# Thiết lập thư mục làm việc trong container
WORKDIR /app

# Copy file cấu hình module Go
COPY go.mod ./

# Tải các dependencies (nếu có, ở đây không có dependency ngoài)
RUN go mod download

# Copy lại toàn bộ mã nguồn vào image
COPY . .

# Build ứng dụng Go thành một file thực thi duy nhất lấy tên là 'main'
RUN go build -o main .

# Bắt đầu stage 2: Sử dụng image alpine cực kì nhỏ gọn để chạy ứng dụng (giảm dung lượng image cuối cùng)
FROM alpine:latest

# Cài đặt thư viện thực thi cần thiết
RUN apk --no-cache add ca-certificates

WORKDIR /app

# Copy file thực thi từ stage 'builder' sang stage này
COPY --from=builder /app/main .

# Khai báo port ứng dụng sử dụng
EXPOSE 8080

# Lệnh khởi chạy ứng dụng
CMD ["./main"]
