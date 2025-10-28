<h1 align="center">📱 ỨNG DỤNG QUẢN LÝ CỬA HÀNG BÁN ĐIỆN THOẠI</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue" />
  <img src="https://img.shields.io/badge/SpringBoot-3.3.1-green" />
  <img src="https://img.shields.io/badge/Database-MySQL-yellow" />
</p>

<p align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/1040/1040230.png" width="100" />
</p>

<p align="center"><strong>Hệ thống quản lý cửa hàng điện thoại – tiện lợi – hiện đại – chính xác</strong></p>

---

## 📘 Giới thiệu

Đây là ứng dụng quản lý cửa hàng bán điện thoại được phát triển bằng **Java Spring Boot** kết hợp với **Thymeleaf** cho giao diện người dùng.  
Cơ sở dữ liệu sử dụng **MySQL (hoặc Aiven Cloud)**, được thiết kế theo mô hình **MVC 3 lớp**, giúp dễ bảo trì và mở rộng.

Ứng dụng hỗ trợ các chức năng như:  
🛍️ Quản lý sản phẩm điện thoại,  
👨‍💼 Quản lý khách hàng,  
📦 Quản lý đơn hàng,  
💰 Thống kê doanh thu,  
và tích hợp kiểm thử tự động với **JUnit**.

---

## 🎯 Mục tiêu dự án

- Xây dựng hệ thống quản lý cửa hàng điện thoại chuyên nghiệp, trực quan.  
- Thiết kế kiến trúc rõ ràng theo mô hình **MVC 3 lớp**.  
- Thực hiện đầy đủ **CRUD**, kiểm tra đầu vào và ràng buộc dữ liệu.  
- Dễ mở rộng lên REST API hoặc thêm phân quyền quản trị viên.  
- Áp dụng công nghệ hiện đại: Spring Boot, JPA, Bootstrap.

---

## ⚙️ Chức năng chính

### 🧾 Quản lý Sản phẩm

- Thêm, sửa, xóa, tìm kiếm sản phẩm điện thoại.  
- Quản lý thông tin: mã, tên, hãng, giá, số lượng, bảo hành.  
- Kiểm tra đầu vào hợp lệ, tránh trùng mã sản phẩm.

### 👥 Quản lý Khách hàng

- Thêm, sửa, xóa, tìm kiếm khách hàng.  
- Kiểm tra định dạng email, số điện thoại, CCCD.  
- Liên kết khách hàng với đơn hàng.

### 🛒 Quản lý Đơn hàng

- Tạo đơn hàng mới, cập nhật, xóa hoặc tra cứu.  
- Tự động tính tổng tiền, giảm giá (nếu có).  
- Liên kết với bảng khách hàng và sản phẩm.

### 📈 Thống kê Doanh thu

- Thống kê doanh thu theo tháng/năm.  
- Lọc doanh thu theo hãng, loại sản phẩm.  
- Hiển thị biểu đồ bằng bảng hoặc chart.

---

## 💻 Công nghệ sử dụng

| Thành phần         | Công nghệ triển khai           |
| ------------------ | ------------------------------ |
| Ngôn ngữ           | Java 17                        |
| Backend Framework  | Spring Boot 3.3.1 + Spring MVC |
| Giao diện frontend | Thymeleaf + Bootstrap          |
| ORM                | Hibernate + Spring Data JPA    |
| Cơ sở dữ liệu      | MySQL / Aiven Cloud            |
| Kiểm thử           | JUnit 5, Mockito               |
| Build tool         | Maven                          |
| Quản lý mã nguồn   | Git + GitHub                   |

---

## 🧠 Kiến trúc & Thiết kế

Áp dụng mô hình **MVC 3 lớp**:

- **Controller** – xử lý request từ người dùng.  
- **Service** – xử lý logic nghiệp vụ.  
- **Repository** – giao tiếp với CSDL qua JPA.

Mẫu thiết kế (Design Pattern):

- `Singleton` – quản lý kết nối và cấu hình.  
- `Builder` – tạo đối tượng sản phẩm, đơn hàng.

---

## 🧪 Kiểm thử

- Dùng `JUnit 5` để kiểm thử lớp Service.  
- Dùng `Mockito` để mô phỏng Repository.  
- Validate dữ liệu trước khi ghi CSDL.  
- Có kiểm thử tự động CRUD cho từng module.

---

## 🚀 Hướng dẫn triển khai

### 🔹 Bước 1: Chuẩn bị môi trường

- Cài đặt **Java JDK 17+**  
- Cài đặt **IntelliJ IDEA / Eclipse**  
- Cài đặt **MySQL Server hoặc Aiven Cloud**  
- Cài đặt **Git** (nếu clone từ GitHub)

---

### 🔹 Bước 2: Tải mã nguồn

```bash
git clone https://github.com/yourusername/PhoneStoreManager.git
---
### 🔹 Bước 3: Cấu hình CSDL

Mở file:

src/main/resources/application.properties


Thêm thông tin kết nối:

spring.datasource.url=jdbc:mysql://localhost:3306/phonestore
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false

### 🔹 Bước 4: Chạy ứng dụng

Mở file:

src/main/java/com/example/phonestore/PhoneStoreApplication.java


Chạy bằng IDE hoặc lệnh:

mvn spring-boot:run

### 🔹 Bước 5: Truy cập hệ thống
http://localhost:8080/

Đường dẫn	Mô tả chức năng
/sanpham	Quản lý sản phẩm điện thoại
/khachhang	Quản lý khách hàng
/donhang	Quản lý đơn hàng
/thongke	Thống kê doanh thu
/ hoặc /home	Trang chủ hệ thống
📂 Cấu trúc thư mục dự án
PhoneStoreManager/
├── controller/             # Controller (SanPham, DonHang, KhachHang,...)
├── service/                # Business logic
├── repository/             # Tầng truy cập dữ liệu (JPA)
├── model/                  # Entity (SanPham, KhachHang, DonHang)
├── templates/              # Giao diện Thymeleaf
├── static/                 # CSS, JS, hình ảnh
├── PhoneStoreApplication.java
├── application.properties
└── README.md

📊 Sơ đồ & Thiết kế hệ thống

✅ UML Class Diagram
✅ Activity Diagram (Thêm/Sửa/Xóa)
✅ Sequence Diagram
✅ ERD (CSDL cửa hàng điện thoại)

📁 Các hình được lưu trong thư mục img/

👨‍💻 Nhóm thực hiện
MSSV	Họ và tên	Vai trò
23010772	Nguyễn Văn Tú	Thiết kế hệ thống, xây dựng chức năng chính
2301xxxx	Trần Văn A	Giao diện & xử lý logic đơn hàng
2301xxxx	Nguyễn Thị B	Xử lý thống kê & kiểm thử

📍 Trường: Đại học Phenikaa
📫 GitHub nhóm: https://github.com/yourusername/PhoneStoreManager

💐 Lời tri ân

Nhóm xin gửi lời cảm ơn chân thành tới Cô Nguyễn Lệ Thu đã hướng dẫn và hỗ trợ nhóm trong suốt quá trình thực hiện dự án.
Dự án giúp chúng em củng cố kiến thức về lập trình Java – Spring Boot, thiết kế hệ thống phần mềm và làm việc nhóm hiệu quả.

🌟 “Chúng em kính chúc Cô luôn mạnh khỏe, hạnh phúc và tiếp tục truyền cảm hứng học tập cho sinh viên.”

✅ Kết luận

✅ Hoàn thiện đầy đủ chức năng CRUD.

✅ Thiết kế chuẩn MVC.

✅ Giao diện trực quan, dễ sử dụng.

✅ Sẵn sàng mở rộng REST API, phân quyền, cloud.

📚 License

Dự án phục vụ mục đích học tập tại Đại học Phenikaa.
Không sử dụng cho mục đích thương mại nếu không có sự cho phép từ nhóm phát triển.

📩 Liên hệ: nguyenvantu@phenikaa-uni.edu.vn
