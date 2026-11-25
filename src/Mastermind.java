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
    public static int[] checkPassword(int[] password, int[] attempts) {
        boolean[] checkedPass = new boolean[4];
        boolean[] checkedAttempt = new boolean[4];
        int exactMatches = 0;
        int misplaceds = 0;

        for (int i = 0; i < 4; i++) {
            if (password[i] == attempts[i]) {
                exactMatches++;
                checkedPass[i] = true;
                checkedAttempt[i] = true;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (!checkedAttempt[i]) {
                for (int j = 0; j < 4; j++) {
                    if (!checkedPass[j] && password[j] == attempts[i]) {
                        misplaceds++;
                        checkedPass[j] = true;
                        break;
                    }
                }
            }
        }

        return new int[] {exactMatches, misplaceds};
    }


}
