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
```

---

### 🔹 Bước 3: Cấu hình CSDL

Mở file:

```

src/main/resources/application.properties
```

Thêm thông tin kết nối:

```properties

spring.datasource.url=jdbc:mysql://localhost:3306/phonestore
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
```

### 🔹 Bước 4: Chạy ứng dụng

Mở file:
```

src/main/java/com/example/phonestore/PhoneStoreApplication.java
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
|   `/ sanpham	`  |  Quản lý sản phẩm điện thoại|
|  `/ khachhang` 	 |   Quản lý khách hàng        |
|   `/donhang` 	   |   Quản lý đơn hàng          |
|  `/  hoặc /home` |	 Trang chủ hệ thống        |

---

## 📂 Cấu trúc thư mục dự án

```
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

```

---

## 📊 Sơ đồ & Thiết kế hệ thống

✅ UML Class Diagram
✅ Activity Diagram (Thêm/Sửa/Xóa)
✅ Sequence Diagram
✅ ERD (CSDL cửa hàng điện thoại)

📁 Các hình được lưu trong thư mục img/

---

## 👨‍💻 Nhóm thực hiện
Phạm Tùng Lâm ăn cứt gà
Hiếu xấu trai bị LÂm cứt gà bôi cứt lên mặt

📍 Trường: **Đại học Phenikaa**
📫 GitHub nhóm: [https://github.com/lamchamhuy/OOP_N04_25_26_PhamLam_DucHieu_BuiQuan](https://github.com/lamchamhuy/OOP_N04_25_26_PhamLam_DucHieu_BuiQuan/tree/master)

---

## 📸 Hình ảnh hệ thống

| Giao diện & Biểu đồ                                                                              |
| ------------------------------------------------------------------------------------------------ |
| ![Sơ đồ lớp UML](img/sodolopUML.png)                                                             |
| Sơ đồ lớp UML                                                                                    |
| ![Sơ đồ quan hệ các lớp](img/Sodoquanhecaclop.png)                                               |
| Sơ đồ quan hệ các lớp                                                                            |
| ![Sơ đồ Activity đăng nhập](<img width="420" height="446" alt="Image" src="https://github.com/user-attachments/assets/7d54dfbc-b39b-4313-b65f-5e2e03da1d22" />)                                                |
| Sơ đồ Activity đăng nhập                                                                         |
| ![Sơ đồ Activity thêm chuyến bay](<img width="399" height="446" alt="Image" src="https://github.com/user-attachments/assets/75d73dc0-c045-4aa8-b785-549e49d0c821" />)                                      |
| Sơ đồ Activity thêm chuyến bay                                                                   |
| ![Sơ đồ Activity sửa chuyến bay](<img width="406" height="442" alt="Image" src="https://github.com/user-attachments/assets/d52fb2fb-049c-490c-ab6e-ab3c628de930" />)                                        |
| Sơ đồ Activity sửa chuyến bay                                                                    |
| ![Sơ đồ Activity xóa chuyến bay](<img width="405" height="435" alt="Image" src="https://github.com/user-attachments/assets/d3761828-16a9-4379-937d-517b72fb5d4c" />)                                        |
| Sơ đồ Activity xóa chuyến bay                                                                    |
| ![Sơ đồ Activity tìm kiếm chuyến bay](<img width="451" height="332" alt="Image" src="https://github.com/user-attachments/assets/6e711cd8-9b24-4616-9ef3-2a0d86d4f441" />)                               |
| Sơ đồ Activity tìm kiếm chuyến bay                                                               |
| ![Sơ đồ Activity thêm khách hàng](<img width="424" height="438" alt="Image" src="https://github.com/user-attachments/assets/60b95d9b-4a39-4349-8ba0-bfc0694cb5cf" />)                                        |
| Sơ đồ Activity thêm khách hàng                                                                   |
| ![Sơ đồ Activity sửa khách hàng](<img width="425" height="430" alt="Image" src="https://github.com/user-attachments/assets/b1fdbd34-8415-4cd5-8f30-ab9e0939dd97" />)                                          |
| Sơ đồ Activity sửa khách hàng                                                                    |
| ![Sơ đồ Activity xóa khách hàng](<img width="414" height="438" alt="Image" src="https://github.com/user-attachments/assets/eb1df6a1-d282-483d-8400-d19a0eaadc83" />)                                          |
| Sơ đồ Activity xóa khách hàng                                                                    |
| ![Sơ đồ Activity tìm kiếm khách hàng](<img width="505" height="378" alt="Image" src="https://github.com/user-attachments/assets/c4d6bcf6-d8cb-4bd4-b076-336ac1bdd8a9" />)                                 |
| Sơ đồ Activity tìm kiếm khách hàng                                                               |
| ![Sơ đồ Activity thêm đơn hàng](<img width="418" height="434" alt="Image" src="https://github.com/user-attachments/assets/3bbfae12-0d65-4085-8484-e0659a023e00" />)                                                |
| Sơ đồ Activity thêm đơn hàng                                                                          |
| ![Sơ đồ Activity sửa đơn hàng](<img width="430" height="429" alt="Image" src="https://github.com/user-attachments/assets/921ad8f9-b4dc-4226-86ab-83f6cb50a816" />)                                                  |
| Sơ đồ Activity sửa đơn hàng                                                                             |
| ![Sơ đồ Activity xóa đơn hàng ](<img width="412" height="433" alt="Image" src="https://github.com/user-attachments/assets/8e1887e2-31cb-4b86-9ece-e65f8a420d92" />)                                                  |
| Sơ đồ Activity xóa đơn hàng                                                                            |
| ![Sơ đồ Activity tìm kiếm đơn hàng ](***)                                         |
| Sơ đồ Activity tìm kiếm đơn hàng                                                                       |
| ![Biểu đồ ca sử dụng tổng quát](<img width="538" height="376" alt="Image" src="https://github.com/user-attachments/assets/8b8bc1cf-044c-4908-8492-2a4b00c1ca05" />)                                          |
| Biểu đồ ca sử dụng tổng quát                                                                     |
| ![Biểu đồ use-case quản lý chuyến bay](img/Bieudouse-caseqlcb.png)                               |
| Biểu đồ use-case quản lý chuyến bay                                                              |
| ![Biểu đồ use-case quản lý khách hàng](img/Bieudouse-caseqlkh.png)                               |
| Biểu đồ use-case quản lý khách hàng                                                              |
| ![Biểu đồ use-case quản lý vé](img/Bieudouse-caseqlve.png)                                       |
| Biểu đồ use-case quản lý vé                                                                      |
| ![Biểu đồ use-case thống kê doanh thu](img/Bieudouse-casetkdt.png)                               |
| Biểu đồ use-case thống kê doanh thu                                                              |
| ![Biểu đồ tuần tự chức năng đăng nhập](img/Bieudotuantucndn.png)                                 |
| Biểu đồ tuần tự chức năng đăng nhập                                                              |
| ![Biểu đồ tuần tự chức năng thêm chuyến bay](img/Bieudotuantucnthemcb.png)                       |
| Biểu đồ tuần tự chức năng thêm chuyến bay                                                        |
| ![Biểu đồ tuần tự chức năng sửa chuyến bay](img/Bieudotuantucnsuacb.png)                         |
| Biểu đồ tuần tự chức năng sửa chuyến bay                                                         |
| ![Biểu đồ tuần tự chức năng xóa chuyến bay](img/Bieudotuantucnxoacb.png)                         |
| Biểu đồ tuần tự chức năng xóa chuyến bay                                                         |
| ![Biểu đồ tuần tự chức năng tìm kiếm chuyến bay](img/Bieudotuantucntimkiemcb.png)                |
| Biểu đồ tuần tự chức năng tìm kiếm chuyến bay                                                    |
| ![Biểu đồ tuần tự chức năng thêm khách hàng](img/Bieudotuantucnthemkh.png)                       |
| Biểu đồ tuần tự chức năng thêm khách hàng                                                        |
| ![Biểu đồ tuần tự chức năng sửa khách hàng](img/Bieudotuantucnsuakh.png)                         |
| Biểu đồ tuần tự chức năng sửa khách hàng                                                         |
| ![Biểu đồ tuần tự chức năng xóa khách hàng](img/Bieudotuantucnxoakh.png)                         |
| Biểu đồ tuần tự chức năng xóa khách hàng                                                         |
| ![Biểu đồ tuần tự chức năng tìm kiếm khách hàng](img/Bieudotuantucntimkiemkh.png)                |
| Biểu đồ tuần tự chức năng tìm kiếm khách hàng                                                    |
| ![Biểu đồ tuần tự chức năng thêm vé](img/Bieudotuantucnthemve.png)                               |
| Biểu đồ tuần tự chức năng thêm vé                                                                |
| ![Biểu đồ tuần tự chức năng sửa vé](img/Bieudotuantucnsuave.png)                                 |
| Biểu đồ tuần tự chức năng sửa vé                                                                 |
| ![Biểu đồ tuần tự chức năng xóa vé](img/Bieudotuantucnxoave.png)                                 |
| Biểu đồ tuần tự chức năng xóa vé                                                                 |
| ![Biểu đồ tuần tự chức năng tìm kiếm vé](img/Bieudotuantucntimkiemve.png)                        |
| Biểu đồ tuần tự chức năng tìm kiếm vé                                                            |
| ![Sơ đồ thực thể liên kết](img/Sodothucthelienket.png)                                           |
| Sơ đồ thực thể liên kết                                                                          |
| ![Sơ đồ lớp và thiết kế lớp](img/Sodolopvathietkelop.png)                                        |
| Sơ đồ lớp và thiết kế lớp                                                                        |
| ![Try-catch-finally](review/thunghiem/src/main/java/com/example/veapp/img/try-catch-example.png) |
| Try-catch-finally                                                                                |
| ![UI quản lý vé](review/thunghiem/src/main/java/com/example/veapp/img/UI_quanlyve.png)           |
| UI quản lý vé                                                                                    |






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
