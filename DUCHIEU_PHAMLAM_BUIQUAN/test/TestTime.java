package DUCHIEU_PHAMLAM_BUIQUAN.test;

import DUCHIEU_PHAMLAM_BUIQUAN.src.Time;

public class TestTime {
    public static void main(String[] args) {

        Time t1 = new Time(10, 30, 45);
        Time t2 = new Time(23, 59, 59);

        System.out.println("Time 1: " + t1);
        System.out.println("Time 2: " + t2);

        t1.setTime(12, 0, 0);
        System.out.println("Updated Time 1: " + t1);
    }
}
