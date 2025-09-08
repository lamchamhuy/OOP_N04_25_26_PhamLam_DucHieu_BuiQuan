package DUCHIEU_PHAMLAM_BUIQUAN.test;

import DUCHIEU_PHAMLAM_BUIQUAN.src.User;

public class TestUser {
    public static void main(String[] args) {

        User user1 = new User("lampham", "12345");

        System.out.println("Username: " + user1.getUsername());
        System.out.println("Password: " + user1.getPassword());

        user1.setUsername("newUser");
        user1.setPassword("67890");

        System.out.println("Updated Username: " + user1.getUsername());
        System.out.println("Updated Password: " + user1.getPassword());
        user1.forgotPassword();
    }
}
