package DUCHIEU_PHAMLAM_BUIQUAN.src;

import java.util.concurrent.ThreadLocalRandom;

public class RandNumBetter {
    public static int rand1to999() {
        return ThreadLocalRandom.current().nextInt(1, 1000);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(rand1to999());
        }
    }
}
