<h1 align="center">💻 ỨNG DỤNG QUẢN LÝ CỬA HÀNG BÁN LAPTOP</h1>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue" />
  <img src="https://img.shields.io/badge/SpringBoot-3.3.1-green" />
  <img src="https://img.shields.io/badge/Database-MySQL-yellow" />
</p>

<p align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/1040/1040230.png" width="100" />
</p>

<p align="center"><strong>Hệ thống quản lý cửa hàng Laptopshop – tiện lợi – hiện đại – chính xác</strong></p>

---

## 📘 Giới thiệu

Đây là ứng dụng quản lý cửa hàng bán laptop được phát triển bằng **Java Spring Boot** kết hợp với **Thymeleaf** cho giao diện người dùng.  
Cơ sở dữ liệu sử dụng **MySQL (hoặc Aiven Cloud)**, được thiết kế theo mô hình **MVC 3 lớp**, giúp dễ bảo trì và mở rộng.

Ứng dụng hỗ trợ các chức năng như:  
🛍️ Quản lý sản phẩm Laptop,  
👨‍💼 Quản lý khách hàng,  
📦 Quản lý đơn hàng,  
👨‍💼 Quản lý người dùng,  
và tích hợp kiểm thử tự động với **JUnit**.

---

## 🎯 Mục tiêu dự án

- Xây dựng hệ thống quản lý cửa hàng Laptop chuyên nghiệp, trực quan.  
- Thiết kế kiến trúc rõ ràng theo mô hình **MVC 3 lớp**.  
- Thực hiện đầy đủ **CRUD**, kiểm tra đầu vào và ràng buộc dữ liệu.  
- Dễ mở rộng lên REST API hoặc thêm phân quyền quản trị viên.  
- Áp dụng công nghệ hiện đại: Spring Boot, JPA, Bootstrap.

---

## ⚙️ Chức năng chính

### 🧾 Quản lý Sản phẩm

- Thêm, sửa, xóa, tạo mới một sản phẩm.  
- Quản lý thông tin: ID, Name,	Price, Factory,Target, Quantity. 
- Kiểm tra đầu vào hợp lệ, tránh trùng mã sản phẩm.

### 👥 Quản lý Khách hàng

- Thêm, sửa, xóa, tạo mới một người dùng.  
- Kiểm tra định dạng: ID, email, Full Name,Role.  
- Liên kết khách hàng với đơn hàng.

### 🛒 Quản lý Đơn hàng

- Thêm, sửa, xóa, tạo mới một đơn hàng.
-Quản lý thông tin: ID,Total Price (VNĐ),	User, Status. 
- Tự động tính tổng tiền đơn hàng.  
- Liên kết với bảng khách hàng và sản phẩm.


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
| Quản lý mã nguồn   | GitHub                         |

---

## 🧠 Kiến trúc & Thiết kế

Áp dụng mô hình **MVC 3 lớp**:

- **Controller** – xử lý request từ người dùng.  
- **Service** – xử lý logic nghiệp vụ.  
- **Repository** – giao tiếp với CSDL qua JPA.


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
git clone https://github.com/lamchamhuy/OOP_N04_25_26_PhamLam_DucHieu_BuiQuan/tree/master.git
```
Hoặc giải nén file .zip nếu tải từ LMS/Drive.
---

### 🔹 Bước 3: Cấu hình CSDL

Mở file:

```

C:\Users\ASUS\01.java-mvc\01-java-spring-laptopshop-starter-master\src\main\resources\application.properties
```

Thêm thông tin kết nối:

```properties

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/laptopshop
spring.datasource.username=root
spring.datasource.password=302004
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
```

### 🔹 Bước 4: Chạy ứng dụng

Mở file:
```

src/main/java/vn/lampham/laptopshop/LaptopshopApplication.java

```


Chạy bằng IDE hoặc lệnh:
```bash

mvn spring-boot:run
```
---

### 🔹 Bước 5: Truy cập hệ thống
```
http://localhost:8080/
```

| Đường dẫn        | Chức năng                   |
| ---------------- | --------------------------- |
|   `/ admin  	`  |  Quản lý sản phẩm laptop|
|  `/ admin/user`  |   Quản lý người dùng        |
|  `/admin/product`|   Quản lý sản phẩm          |
|  `/admin/order`  |	 Quản lý đơn hàng          |
|  `      /      ` |	 Trang chủ hệ thống        |


---

## 📂 Cấu trúc thư mục dự án

```
laptopshop/
├── controller/admin        # Controller (SanPham, DonHang, KhachHang,...)
├── service/                # Business logic
├── repository/             # Tầng truy cập dữ liệu (JPA)
├── model/                  # Entity (SanPham, KhachHang, DonHang)
├── templates/              # Giao diện Thymeleaf
├── static/                 # CSS, JS, hình ảnh
├── PhoneStoreApplication.java
├── application.properties
└── README.md

```

---

## 📊 Sơ đồ & Thiết kế hệ thống
- Các biểu đồ đã hoàn thành:

✅ UML Class Diagram

✅ Activity Diagram (Thêm/Sửa/Xóa)

✅ Sequence Diagram

✅ ERD (CSDL cửa hàng laptop)

📁 Các hình được lưu trong thư mục img/

---

## 👨‍💻 Nhóm thực hiện
| MSSV      | Họ và Tên                | Vai trò chi tiết                                                                                      |
| --------  | -------------------------| ----------------------------------------------------------------------------------------------        |
| 23010820  | **Phạm Tùng Lâm**       |Thiết kế Xây dựng giao diện web laptop chính , xây dựng chức năng quản lý user, order,viết README       |
| 23010725  | **Bùi Minh Quân**       | Xây dựng chức năng quản lý product,  viết README, làm báo cáo bài tập nhóm                             |
| 23010726  | **Nguyễn Đức Hiếu**     | validate dữ liệu đầu vào, làm báo cáo bài tập nhóm, viết README                                        |

📍 Trường: **Đại học Phenikaa** 

📫 GitHub nhóm: 
[https://github.com/lamchamhuy/OOP_N04_25_26_PhamLam_DucHieu_BuiQuan](https://github.com/lamchamhuy/OOP_N04_25_26_PhamLam_DucHieu_BuiQuan/tree/master)

---

## 📸 Hình ảnh hệ thống

| Giao diện & Biểu đồ                                                                              |
| ------------------------------------------------------------------------------------------------ |
| ![Sơ đồ lớp UML](https://github.com/user-attachments/assets/a3614ee5-2bd5-44ac-afff-b191f2576194)                                                             |
| Sơ đồ lớp UML                                                                                    |
| ![Sơ đồ Activity đăng nhập](https://github.com/user-attachments/assets/7d54dfbc-b39b-4313-b65f-5e2e03da1d22)           |
| Sơ đồ Activity đăng nhập                                                                         |
| ![Sơ đồ Activity thêm sản phẩm](https://github.com/user-attachments/assets/75d73dc0-c045-4aa8-b785-549e49d0c821)      |
| Sơ đồ Activity thêm sản phẩm                                                                  |
| ![Sơ đồ Activity sửa sản phẩm](https://github.com/user-attachments/assets/d52fb2fb-049c-490c-ab6e-ab3c628de930)        |
| Sơ đồ Activity sửa sản phẩm                                                                   |
| ![Sơ đồ Activity xóa sản phẩm](https://github.com/user-attachments/assets/d3761828-16a9-4379-937d-517b72fb5d4c)        |
| Sơ đồ Activity xóa sản phẩm                                                                    |
| ![Sơ đồ Activity tìm kiếm sản phẩm](https://github.com/user-attachments/assets/6e711cd8-9b24-4616-9ef3-2a0d86d4f441)    |
| Sơ đồ Activity tìm kiếm sản phẩm                                                              |
| ![Sơ đồ Activity thêm khách hàng](https://github.com/user-attachments/assets/60b95d9b-4a39-4349-8ba0-bfc0694cb5cf)                                        |
| Sơ đồ Activity thêm khách hàng                                                                   |
| ![Sơ đồ Activity sửa khách hàng](https://github.com/user-attachments/assets/b1fdbd34-8415-4cd5-8f30-ab9e0939dd97)                                          |
| Sơ đồ Activity sửa khách hàng                                                                    |
| ![Sơ đồ Activity xóa khách hàng](https://github.com/user-attachments/assets/eb1df6a1-d282-483d-8400-d19a0eaadc83)                                          |
| Sơ đồ Activity xóa khách hàng                                                                    |
| ![Sơ đồ Activity tìm kiếm khách hàng](https://github.com/user-attachments/assets/c4d6bcf6-d8cb-4bd4-b076-336ac1bdd8a9)                                 |
| Sơ đồ Activity tìm kiếm khách hàng                                                               |
| ![Sơ đồ Activity thêm đơn hàng](https://github.com/user-attachments/assets/3bbfae12-0d65-4085-8484-e0659a023e00)                                                |
| Sơ đồ Activity thêm đơn hàng                                                                          |
| ![Sơ đồ Activity sửa đơn hàng](https://github.com/user-attachments/assets/921ad8f9-b4dc-4226-86ab-83f6cb50a816)                                                  |
| Sơ đồ Activity sửa đơn hàng                                                                             |
| ![Sơ đồ Activity xóa đơn hàng ](https://github.com/user-attachments/assets/8e1887e2-31cb-4b86-9ece-e65f8a420d92)                                                  |
| Sơ đồ Activity xóa đơn hàng                                                                            |
| ![Biểu đồ ca sử dụng tổng quát](https://github.com/user-attachments/assets/8b8bc1cf-044c-4908-8492-2a4b00c1ca05)                                          |
| Biểu đồ ca sử dụng tổng quát                                                                     |
| ![Biểu đồ use-case quản lý sản phẩm](https://github.com/user-attachments/assets/a29eb62c-f58f-4647-9287-ece2afa70964)                               |
| Biểu đồ use-case quản lý sản phẩm                                                              |
| ![Biểu đồ use-case quản lý khách hàng](https://github.com/user-attachments/assets/243d0768-9f34-44aa-8159-af636db61d65)                               |
| Biểu đồ use-case quản lý khách hàng                                                              |
| ![Biểu đồ use-case quản lý đơn hàng](https://github.com/user-attachments/assets/da889f4f-7bdc-4f22-9b54-c4d2f0980041)                                       |
| Biểu đồ use-case quản lý đơn hàng                                                                     |
| ![Biểu đồ use-case thống kê doanh thu](https://github.com/user-attachments/assets/b99ab2c5-8367-4704-84df-1ab67523fad5)                               |
| Biểu đồ use-case thống kê doanh thu                                                              |
| ![Biểu đồ tuần tự chức năng đăng nhập](https://github.com/user-attachments/assets/0a91a0f2-9df7-478d-8bba-b906b0bb9a01)                                 |
| Biểu đồ tuần tự chức năng đăng nhập                                                              |
| ![Biểu đồ tuần tự chức năng thêm sản phẩm](https://github.com/user-attachments/assets/dff938d2-f6d0-4ec3-b17e-9241c50c89e4)                       |
| Biểu đồ tuần tự chức năng thêm sản phẩm                                                        |
| ![Biểu đồ tuần tự chức năng sửa sản phẩm  ](https://github.com/user-attachments/assets/c97e5644-c6e3-437e-82e1-988c62fdf6e0)                         |
| Biểu đồ tuần tự chức năng sửa sản phẩm                                                          |
| ![Biểu đồ tuần tự chức năng xóa sản phẩm  ](https://github.com/user-attachments/assets/50adf1e0-770e-449e-8d86-8ab8a08196d5)                         |
| Biểu đồ tuần tự chức năng xóa sản phẩm                                                         |
| ![Biểu đồ tuần tự chức năng tìm kiếm sản phẩm  ](https://github.com/user-attachments/assets/f3cde4f1-46ba-4a0a-b94f-d2ff30f74c22)                |
| Biểu đồ tuần tự chức năng tìm kiếm sản phẩm                                                      |
| ![Biểu đồ tuần tự chức năng thêm khách hàng](https://github.com/user-attachments/assets/030aec41-4f10-4311-ad00-8ca7bee350b8)                       |
| Biểu đồ tuần tự chức năng thêm khách hàng                                                        |
| ![Biểu đồ tuần tự chức năng sửa khách hàng](https://github.com/user-attachments/assets/720cb536-7277-4c75-8334-af5f8b3cc629)                         |
| Biểu đồ tuần tự chức năng sửa khách hàng                                                         |
| ![Biểu đồ tuần tự chức năng xóa khách hàng](https://github.com/user-attachments/assets/1349f95b-3640-48de-bfdf-acd9976ad6e1)                         |
| Biểu đồ tuần tự chức năng xóa khách hàng                                                         |
| ![Biểu đồ tuần tự chức năng tìm kiếm khách hàng](https://github.com/user-attachments/assets/2a8394b3-5af3-49e9-a31b-5d16563f4c2b)                |
| Biểu đồ tuần tự chức năng tìm kiếm khách hàng                                                    |
| ![Biểu đồ tuần tự chức năng thêm đơn hàng](https://github.com/user-attachments/assets/b7c6f3a4-9a31-47d0-863a-c999f82663b4)                               |
| Biểu đồ tuần tự chức năng thêm đơn hàng                                                               |
| ![Biểu đồ tuần tự chức năng sửa đơn hàng](https://github.com/user-attachments/assets/21302a12-73a9-4309-adc1-8de65f605284)                                 |
| Biểu đồ tuần tự chức năng sửa đơn hàng                                                                 |
| ![Biểu đồ tuần tự chức năng xóa đơn hàng](https://github.com/user-attachments/assets/02ea5f77-aeb9-4d78-8c48-f0e087e8f3c0)                                 |
| Biểu đồ tuần tự chức năng xóa đơn hàng                                                                |
| ![Biểu đồ tuần tự chức năng tìm kiếm đơn hàng](https://github.com/user-attachments/assets/c6b924f5-2b6b-4328-aaad-a57b89c96832)                        |
| Biểu đồ tuần tự chức năng tìm kiếm đơn hàng                                                            |
| ![Sơ đồ thực thể liên kết](https://github.com/user-attachments/assets/165cd1c8-0127-49a6-a441-f6a26207577f)                                           |
| Sơ đồ thực thể liên kết                                                                          |
                                                                                
## 🗂️ Sơ đồ cơ sở dữ liệu (ERD)

### 1. 🔹 Sơ đồ hệ thống cơ bản

Hệ thống cửa hàng bán laptop được xây dựng với các bảng chính như:

- `sanpham`: lưu thông tin các sản phẩm laptop
- `khachhang`: lưu thông tin người mua hàng
- `donhang`: lưu thông tin các đơn hàng được đặt
- `account`: lưu thông tin tài khoản đăng nhập của khách hàng

![Sơ đồ ERD cơ bản](https://github.com/user-attachments/assets/71308f84-6d87-4744-a669-51370ac3bbd4)

- Một khách hàng có thể đặt nhiều đơn hàng (`1 - n`)
- Mỗi đơn hàng có thể chứa nhiều sản phẩm, và mỗi sản phẩm có thể xuất hiện trong nhiều đơn hàng  (`n - n`)
- Bảng `account` có quan hệ 1-1 với bảng `khachhang` để phân quyền người dùng

---





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

📩 Liên hệ: 23010820@st.phenikaa-uni.edu.vn
