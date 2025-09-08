package DUCHIEU_PHAMLAM_BUIQUAN.test;

import DUCHIEU_PHAMLAM_BUIQUAN.src.User;

public class TestUser {
    public static void main(String[] args) {

        User customer = new User("lampham", "12345", "lam@example.com", "customer");

        customer.displayInfo();

        customer.setUsername("newCustomer");
        customer.setPassword("67890");
        customer.setEmail("newmail@example.com");

        System.out.println("\nSau khi cập nhật:");
        customer.displayInfo();

        System.out.println("\nDùng getter lấy mật khẩu: " + customer.getPassword());
    }
}
