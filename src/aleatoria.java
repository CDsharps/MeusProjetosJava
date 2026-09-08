import javax.swing.JOptionPane;

public class aleatoria {

    public static void main(String[] args) {

        String name = enter("Qual é o seu nome?");
        int age = Integer.parseInt(enter("E a sua idade?"));

        if (age >= 18) {

            write("Olá " + name + " você já é maior de idade.");
        } else {

            write("Olá " + name + " você ainda é menor de idade.");
        }

    }

    private static void write(String message) {

        JOptionPane.showMessageDialog(null, message);

    }

    private static String enter(String message) {

        return JOptionPane.showInputDialog(message);

    }
}
