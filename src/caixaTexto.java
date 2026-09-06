import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

public class caixaTexto {

	public static void main(String[] args) {

	}

	private static void write(String args) {

		JOptionPane.showMessageDialog(null, args);

	}

	private static String enter(String args) {

		return JOptionPane.showInputDialog(args);

	}

	private static String formatNumber(long number) {

		NumberFormat formater = NumberFormat.getInstance(Locale.of("pt", "BR"));
		return formater.format(number);

	}

	private static String formatMoney(double number) {

		NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
		return formatador.format(number);

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

	private static int errorInt(String message) {

		while (true) {
			try {

				String answer = enter(message);
				if (answer == null) {

					write("Programa encerrado!");
					return -1;
				}

				int value = Integer.parseInt(answer);

				if (value > 0) {

					return value;
				}

				write("Por favor digite um número maior que 0");
			} catch (NumberFormatException e) {

				write("Digite algo válido no espaço destinado!!");
			}
		}
	}
}