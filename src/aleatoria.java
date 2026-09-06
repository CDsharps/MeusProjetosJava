import javax.swing.JOptionPane;

public class aleatoria {

    public static void main(String[] args) {

        int age = Integer.parseInt(enter("Qual a sua idade?"));

        if (age >= 18) {

            write("Você é maior de idade");
        } else {

            write("Você é menor de idade");
        }
    }

    private static void write(String message) {

        JOptionPane.showMessageDialog(null, message);

    }

    private static String enter(String message) {

        return JOptionPane.showInputDialog(message);

    }
}
