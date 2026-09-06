import javax.swing.JOptionPane;
import java.util.Random;

public class caixaTexto2 {

	public static void main(String[] args) {

		int rolls = errorInt("Digite quantas vezes deseja lançar o dado: ");

		if (rolls == -1) {
			return;
		}

		Random random = new Random();
		int[] count = new int[7];

		for (int i = 0; i < rolls; i++) {

			int roll = random.nextInt(1, 7);
			count[roll]++;
		}

		StringBuilder result = new StringBuilder("Resultado de " + rolls + " lançamentos:\n");

		for (int number = 1; number <= 6; number++) {

			result.append("Número " + number + " saiu " + count[number] + " vez(es)\n");
		}

		write(result.toString());
	}

	private static void write(String args) {

		JOptionPane.showMessageDialog(null, args);

	}

	private static String enter(String args) {

		return JOptionPane.showInputDialog(args);

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