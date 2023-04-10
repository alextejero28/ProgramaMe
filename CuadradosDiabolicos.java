import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class CuadradosDiabolicos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            int[][] cuadrado = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cuadrado[i][j] = scanner.nextInt();
                }
            }

            System.out.println(verificarCuadrado(cuadrado, n));
        }

        scanner.close();
    }

    public static String verificarCuadrado(int[][] cuadrado, int n) {
        Set<Integer> numeros = new HashSet<>();
        int cm = 0;

        for (int i = 0; i < n; i++) {
            cm += cuadrado[0][i];
            for (int j = 0; j < n; j++) {
                numeros.add(cuadrado[i][j]);
            }
        }

        if (numeros.size() != n * n) {
            return "NO";
        }

        for (int i = 1; i <= n * n; i++) {
            if (!numeros.contains(i)) {
                return "NO";
            }
        }

        boolean esDiabolico = true;
        for (int i = 0; i < n && esDiabolico; i++) {
            int sumaFila = 0;
            int sumaColumna = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += cuadrado[i][j];
                sumaColumna += cuadrado[j][i];
            }
            if (sumaFila != cm || sumaColumna != cm) {
                esDiabolico = false;
            }
        }

        if (!esDiabolico) {
            return "NO";
        }

        // Verificar diagonales
        int diagonal1 = 0;
        int diagonal2 = 0;
        for (int i = 0; i < n; i++) {
            diagonal1 += cuadrado[i][i];
            diagonal2 += cuadrado[i][n - 1 - i];
        }
        if (diagonal1 != cm || diagonal2 != cm) {
            return "NO";
        }

        int cm2 = 4 * cm / n;
        int sumaEsquinas = cuadrado[0][0] + cuadrado[0][n - 1] + cuadrado[n - 1][0] + cuadrado[n - 1][n - 1];
        if (sumaEsquinas != cm2) {
            return "DIABOLICO";
        }

        if (n % 2 == 1) {
            int mitad = n / 2;
            int sumaLados = cuadrado[mitad][0] + cuadrado[mitad][n - 1] + cuadrado[0][mitad] + cuadrado[n - 1][mitad];
            int sumaCentro = 4 * cuadrado[mitad][mitad];

            if (sumaLados == cm2 && sumaCentro == cm2) {
                return "ESOTERICO";
            } else {
                return "DIABOLICO";
            }
        } else {
            int mitad = n / 2;
            int sumaLados = cuadrado[mitad - 1][0] + cuadrado[mitad][0] + cuadrado[mitad - 1][n - 1] + cuadrado[mitad][n - 1]
                          + cuadrado[0][mitad - 1] + cuadrado[0][mitad] + cuadrado[n - 1][mitad - 1] + cuadrado[n - 1][mitad];
            int sumaCentro = cuadrado[mitad - 1][mitad - 1] + cuadrado[mitad - 1][mitad]
                           + cuadrado[mitad][mitad - 1] + cuadrado[mitad][mitad];

            if (sumaLados == 2 * cm2 && sumaCentro == cm2) {
                return "ESOTERICO";
            } else {
                return "DIABOLICO";
            }
        }
    }
}    