import javax.swing.JOptionPane;

public class caixaTexto {

	public static void main(String[] args) {
		StringBuilder capsLock = new StringBuilder();

		String phrase = errorString("Digite a frase/palavra a ser convertida");
		if (phrase == null) {

			return;
		}

		for (int i = 0; i < phrase.length(); i++) {

			char letter = phrase.charAt(i);
			int plus = 'A' - 'a';
			if (letter>='a' && letter<='z'){

				char finalLetter = (char) (letter + plus);
				capsLock.append(finalLetter);
			} else {

				capsLock.append(letter);
			}
		}

		write("Conversão para maiúscula: " + capsLock);
	}

	private static void write(String args) {

		JOptionPane.showMessageDialog(null, args);

	}

	private static String enter(String args) {

		return JOptionPane.showInputDialog(args);

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