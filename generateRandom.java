import java.util.Random;

public class generateRandom {
    public static void main(String args[]) {
        generateRandom();
    }

    public static void generateRandom() {
        char[] chars = {'A', 'T', 'G', 'C'};

        Random x = new Random();
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += chars[x.nextInt(4)];
        }

        System.out.println(s);
    }
}
