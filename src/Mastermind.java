import java.util.Scanner;
import java.util.Random;

public class Mastermind {
    public static int[] generatePassword() {
        int[] password = new int[4];
        Random random = new Random();

        for (int i = 0; i < password.length; i++) {
            password[i] = random.nextInt(6) + 1;
        }

        return password;
    }

}
