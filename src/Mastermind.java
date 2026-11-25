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
    public static int[] checkPassword(int[] password, int[] attempt) {
        boolean[] checkedPass = new boolean[4];
        boolean[] checkedAttempt = new boolean[4];
        int exactMatches = 0;
        int misplaceds = 0;

        for (int i = 0; i < 4; i++) {
            if (password[i] == attempt[i]) {
                exactMatches++;
                checkedPass[i] = true;
                checkedAttempt[i] = true;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (!checkedAttempt[i]) {
                for (int j = 0; j < 4; j++) {
                    if (!checkedPass[j] && password[j] == attempt[i]) {
                        misplaceds++;
                        checkedPass[j] = true;
                        break;
                    }
                }
            }
        }

        return new int[] {exactMatches, misplaceds};
    }

    public static int[] readAttempt(Scanner sc) {
        int[] attempt = new int[4];
        boolean valid = false;

        while (!valid){
            System.out.print("Digite 4 números de 1 a 6 separados por espaco: ");
            valid = true;

            for (int i = 0; i < 4; i++) {
                attempt[i] = sc.nextInt();
                if (attempt[i] < 1 || attempt[i] > 6) {
                    valid = false;
                }
            }

            if (!valid) {
                System.out.println("Entrada inválida. Use apenas números de 1 a 6.");
            }
        }
        return attempt;
    }
}
