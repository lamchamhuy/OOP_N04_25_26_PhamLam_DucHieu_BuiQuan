package DUCHIEU_PHAMLAM_BUIQUAN.src;

public class PassObject {
    static void f(MyNumber m) {
        m.i = 15;
    }

    public static void main(String[] args) {
        MyNumber n = new MyNumber();
        n.i = 14;
        PassObject.f(n);
        System.out.println(n.i);
    }
}
