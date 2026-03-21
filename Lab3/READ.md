Buổi 3 — Architecture Styles (Layered, Microkernel)
1.	Vẽ sơ đồ Layered Architecture
<img width="975" height="531" alt="image" src="https://github.com/user-attachments/assets/dbc2c1e3-046d-4dc3-a3e2-3a2a665d5f84" />

2.	Vẽ sơ đồ Microkernel Architecture.
<img width="975" height="531" alt="image" src="https://github.com/user-attachments/assets/ee14796e-cf79-4e62-ac19-6cea4b37793a" />

3.	So sánh ưu/nhược điểm dựa trên sách.
a) Layered Architecture (Phân lớp):
•	Ưu điểm trong code: Mã nguồn cực kỳ đơn giản và dễ hiểu khi mới bắt đầu. Luồng code đi theo đường thẳng: Giao diện gọi Nghiệp vụ, Nghiệp vụ gọi Dữ liệu. Ai mới học lập trình cũng có thể đọc hiểu luồng code này.
•	Nhược điểm trong code: Khi CMS phát triển và mở rộng, các tệp tin ở Lớp Nghiệp Vụ (BLL) sẽ trở nên khổng lồ (hàng ngàn dòng code). Nếu muốn thêm một tính năng mới, buộc phải mở các tệp tin code cũ ra để sửa chữa, dễ gây ra lỗi (bug) làm sập các tính năng đang chạy ổn định.
b) Microkernel Architecture (Plugin/Lõi):
•	Ưu điểm trong code: Khả năng mở rộng mã nguồn tuyệt vời. Khi thêm tính năng mới, không cần chạm vào mã nguồn cũ. Chỉ cần tạo một thư mục mới, viết các tệp tin code mới (Plugin) và cắm vào hệ thống. Lỗi ở Plugin mới sẽ không làm sập Lõi CMS.
•	Nhược điểm trong code: Việc viết code giai đoạn đầu rất phức tạp. Phải thiết kế các Interface (Giao diện), Hệ thống Sự kiện (Event Bus), và cơ chế quản lý vòng đời của Plugin trước khi có thể viết các tính năng thực tế.

4.	Chọn style thích hợp nhất cho CMS và giải thích.

Xây dựng một hệ thống "Plugin-based CMS" (CMS dựa trên plugin), kiến trúchoàn hảo và thích hợp nhất là Microkernel Architecture (Kiến trúc Plugin/Lõi).
Lý do lựa chọn:
1. Khớp hoàn toàn với yêu cầu "Plugin-based": Bản thân cái tên "Microkernel" đã đại diện cho việc xây dựng một lõi nhỏ và mở rộng bằng plugin. Mọi yêu cầu của bạn (Quản lý nội dung, Quản lý phương tiện, Quản lý người dùng) sẽ không bị nhồi nhét vào một tệp tin khổng lồ. Thay vào đó, chúng ta sẽ code chúng thành các module (plugin) riêng biệt, hoàn toàn độc lập với nhau.
2. Tránh xung đột code và dễ dàng gỡ lỗi (Debugging): Giả sử bạn đang viết code để nâng cấp tính năng "Quản lý Phương tiện" (thêm chức năng nén ảnh). Nếu có lỗi xảy ra (bug), nó sẽ chỉ làm hỏng tính năng ảnh. Lõi CMS, tính năng "Quản lý Bài viết" hay "Quản lý Người dùng" vẫn sẽ chạy bình thường vì mã nguồn của chúng nằm ở các tệp tin và thư mục khác nhau.
3. Làm việc nhóm dễ dàng: Sau này, nếu có nhiều lập trình viên cùng tham gia, mỗi người có thể được giao viết code cho một Plugin riêng biệt mà không lo bị "đụng code" (merge conflict) của nhau.

