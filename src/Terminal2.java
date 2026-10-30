import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.NoSuchElementException;

public class Terminal2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        
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