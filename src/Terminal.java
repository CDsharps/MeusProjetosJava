import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.NoSuchElementException;

public class Terminal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    private static String printMatrix(int[][] matrix) {

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                text.append("[").append(matrix[i][j]).append("] ");
            }

            text.append("\n");
        }

        return text.toString();

    }

    private static boolean fillMatrix(int[][] matrix, int lines, int columns, String message) {

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {

                matrix[i][j] = errorInt(message + "[" + (i + 1) + "][" + (j + 1) + "]:");
                if (matrix[i][j] == Integer.MIN_VALUE) {

                    return false;
                }
            }
        }

        return true;

    }

    private static int[][] constructMatrix(String letter) {

        int[] parts = errorProportion("Digite a proporção da matriz " + letter + "(?x?): ");
        if (parts == null) {

            return null;
        }

        int lines = parts[0];
        int columns = parts[1];

        int[][] matrix = new int[lines][columns];
        if (!fillMatrix(matrix, lines, columns, "Digite o número da posíção ")) {

            return null;
        }

        return matrix;
    }

    private static int[] errorProportion(String message) {

        while (true) {

            String proportion = errorString(message);
            if (proportion == null) {

                return null;
            }

            String[] parts = proportion.toLowerCase().split("x");
            if (parts.length != 2) {

                write("Formato inválido. Digite no formato ?x?");
                continue;
            }

            try {

                int lines = Integer.parseInt(parts[0]);
                int columns = Integer.parseInt(parts[1]);

                if (lines > 0 && columns > 0) {

                    return new int[] { lines, columns };
                }

                write("A proporção da matriz deve ser maior que zero!");
            } catch (NumberFormatException e) {

                write("Formato Inválido. Digite no formato ?x?");
            }
        }
    }

    private static void write(String args) {

        System.out.print(args);

    }

    private static void skipLine(int quant) {
        for (int i = 0; i < quant; i++) {

            System.out.println();
        }
    }

    private static String enter(String args) {

        System.out.print(args);
        return sc.nextLine();

    }

    private static String formatNumber(long number) {

        NumberFormat formatador = NumberFormat.getInstance(Locale.of("pt", "BR"));
        return formatador.format(number);

    }

    private static String formatMoney(double number) {

        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        return formatador.format(number);

    }

    private static int errorInt(String mensage) {

        while (true) {
            try {

                String answer = enter(mensage);
                int value = Integer.parseInt(answer);

                if (value > 0) {

                    return value;
                }

                write("\nPor favor digite um número maior que 0\n\n");
            } catch (NumberFormatException e) {

                write("\nDigite algo válido no espaço destinado!!\n\n");
            } catch (NoSuchElementException e) {

                write("\nPrograma encerrado!");
                return -1;
            }
        }
    }

    private static String errorString(String message) {

        while (true) {

            String answer = enter(message);
            if (answer == null) {

                write("Programa encerrado!!");
                return null;
            }

            if (!answer.isBlank()) {

                return answer;
            }

            write("Por favor digite algo para ser analisado!!");
        }
    }
}