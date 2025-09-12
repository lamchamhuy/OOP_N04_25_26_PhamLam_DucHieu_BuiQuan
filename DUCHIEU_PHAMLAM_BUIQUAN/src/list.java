import java.util.ArrayList;

// Lớp Product đại diện cho sản phẩm
class Product {
    int id;          // mã sản phẩm
    String name;     // tên sản phẩm

    // Constructor
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {

    public static void main(String[] args) {
        // Tạo 2 sản phẩm
        Product p1 = new Product(1, "Áo thun");
        Product p2 = new Product(2, "Quần jean");

        // Tạo danh sách sản phẩm
        ArrayList<Product> productList = new ArrayList<Product>();
        productList.add(p1);
        productList.add(p2);

        // In ra thông tin sản phẩm đầu tiên
        System.out.println("Sản phẩm ID: " + productList.get(0).id);
        System.out.println("Tên sản phẩm: " + productList.get(0).name);
    }
}
