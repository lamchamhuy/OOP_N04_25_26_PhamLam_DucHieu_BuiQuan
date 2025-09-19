# OOP_N04_25_26_PhamLam_DucHieu_BuiQuan


## 1. Giới thiệu
Ứng dụng **LaptopShop** được xây dựng để quản lý bán laptop online.  
Ứng dụng có các chức năng chính:
- Quản lý Laptop (CRUD).
- Quản lý Khách hàng.
- Quản lý Đơn hàng.


Mỗi thành viên trong nhóm phụ trách 01 đối tượng khác nhau:
- Phạm Lâm: Laptop
- Đức Hiếu: Customer
- Bùi Quân: Order

---

## 2. Class Diagram
Dưới đây là sơ đồ chức năng **Class Diagram** của hệ thống:

<img width="1196" height="660" alt="class_diagram" src="https://github.com/user-attachments/assets/852cc7c0-af23-4168-93da-ef6ac1561804" />


## 3. Laptop - CRUD Code

Ví dụ cho đối tượng **Laptop** (Spring Boot):

```java
@RestController
@RequestMapping("/laptops")
public class LaptopController {
    @Autowired
    private LaptopRepository repo;

    // CREATE
    @PostMapping
    public Laptop createLaptop(@RequestBody Laptop laptop) {
        return repo.save(laptop);
    }

    // READ
    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptop(@PathVariable Long id) {
        return repo.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable Long id, @RequestBody Laptop laptop) {
        return repo.findById(id).map(l -> {
            l.setName(laptop.getName());
            l.setBrand(laptop.getBrand());
            l.setPrice(laptop.getPrice());
            l.setDescription(laptop.getDescription());
            l.setStockQuantity(laptop.getStockQuantity());
            return ResponseEntity.ok(repo.save(l));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}


