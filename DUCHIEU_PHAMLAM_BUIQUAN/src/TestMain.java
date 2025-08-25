package DUCHIEU_PHAMLAM_BUIQUAN.src;

public class TestMain {
    public static void main(String[] args) {
        MyNumber n1 = new MyNumber();
        MyNumber n2 = new MyNumber();
        
        n1.i = 2;
        n2.i = 5;

        n1 = n2;         
        n2.i = 10;       
        System.out.println(n1.i); // in ra 10

        n1.i = 20;        
        System.out.println(n2.i); // in ra 20
    }
}
