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
