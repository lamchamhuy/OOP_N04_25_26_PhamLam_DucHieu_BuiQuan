package DUCHIEU_PHAMLAM_BUIQUAN.test;

import DUCHIEU_PHAMLAM_BUIQUAN.src.Recursion;

public class TestRecursion {
    public static void main(String[] args) {
        Recursion r = new Recursion();

        // Test giai thừa
        int n = 5;
        System.out.println("Factorial of " + n + " = " + r.factorial(n));

        // Test Fibonacci
        int f = 7;
        System.out.println("Fibonacci of " + f + " = " + r.fibonacci(f));
    }
}
