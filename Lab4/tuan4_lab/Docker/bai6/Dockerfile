# Stage 1: Build stage
FROM node:18 AS builder
WORKDIR /usr/src/app

# Chỉ copy package.json và cài đặt dependencies trước để tận dụng Docker cache
COPY package*.json ./
RUN npm install

# Copy toàn bộ mã nguồn vào image
COPY . .

# Stage 2: Production stage
FROM node:18-alpine
WORKDIR /usr/src/app

# Copy các file đã build và node_modules từ Stage 1 sang
COPY --from=builder /usr/src/app ./

# Mở cổng 3000
EXPOSE 3000

# Lệnh chạy ứng dụng
CMD ["npm", "start"]
