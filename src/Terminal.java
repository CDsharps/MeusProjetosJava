import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.NoSuchElementException;

public class Terminal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double Nsal;

        String name = errorString("Qual o nome do funcionário?\n");
        skipLine(1);

        double sal = Double.parseDouble(errorString("Qual o salário do funcionário?\nR$ "));
        skipLine(1);

        int dep = errorInt("Quantos dependentes o funcionário possui?\n");
        skipLine(1);

        switch (dep) {

            case '0':
                Nsal = sal + (sal * 5 / 100);
                break;

            case '1', '2', '3':
                Nsal = sal + (sal * 10 / 100);
                break;

            case '4', '5', '6':
                Nsal = sal + (sal * 15 / 100);
                break;

            default:
                Nsal = sal + (sal * 18 / 100);
                break;
        }

        write("O novo salário de " + name + " é de " + formatMoney(Nsal));
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

    private static String formatMoney(double number){

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