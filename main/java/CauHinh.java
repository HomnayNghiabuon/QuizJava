import java.util.Random;

public class CauHinh {
    public static int random(int begin, int end) {
        if (begin >= end) {
            throw new IllegalArgumentException("Begin must be less than end");
        }

        Random rand = new Random();
        return rand.nextInt(end - begin) + begin;
    }

}
