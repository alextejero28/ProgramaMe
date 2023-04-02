import java.util.Arrays;
import java.util.Scanner;

public class ConstanteKaprekar {
    public static int kaprekarIterations(int num) {
        if (num == 6174)
            return 0;

        int iterations = 0;
        while (num != 6174) {
            iterations++;

            // Obtener dígitos del número y ordenarlos
            int[] digits = new int[4];
            for (int i = 0; i < 4; i++) {
                digits[i] = num % 10;
                num /= 10;
            }
            Arrays.sort(digits);

            // Obtener números ascendente y descendente
            int ascendingNum = 0;
            int descendingNum = 0;
            for (int i = 0; i < 4; i++) {
                ascendingNum = ascendingNum * 10 + digits[i];
                descendingNum = descendingNum * 10 + digits[3 - i];
            }

            // Restar menor al mayor y actualizar el número
            num = descendingNum - ascendingNum;
            if (num == 0)
                return 8; // Caso repdigits
        }

        return iterations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCasos = scanner.nextInt();

        for (int i = 0; i < numCasos; i++) {
            int num = scanner.nextInt();
            System.out.println(kaprekarIterations(num));
        }

        scanner.close();
    }
}