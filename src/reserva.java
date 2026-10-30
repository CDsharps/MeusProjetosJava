import javax.swing.JOptionPane;

public class reserva {
    public static void main(String[] args) {

        
    }

    private static void write(String args) {

        JOptionPane.showMessageDialog(null, args);

    }

    private static String enter(String args) {

        return JOptionPane.showInputDialog(args);

    }

    private static int errorInt(String message, int min, int max) {

        while (true) {
            try {

                String answer = enter(message);
                if (answer == null) {

                    write("Programa encerrado!");
                    return Integer.MIN_VALUE;
                }

                int value = Integer.parseInt(answer);

                if (value >= min && value <= max) {

                    return value;
                }

                write("Digite um número entre " + min + " e " + max + "!");
            } catch (NumberFormatException e) {

                write("Digite algo válido no espaço destinado!!");
            }
        }
    }
}