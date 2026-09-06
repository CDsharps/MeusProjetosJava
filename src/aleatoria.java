import javax.swing.JOptionPane;

public class aleatoria {

    public static void main(String[] args) {

        int age = Integer.parseInt(JOptionPane.showInputDialog("Qual sua idade?"));

        if (age >= 18) {

            JOptionPane.showMessageDialog(null, "Você é maior de idade.");
        } else {

            JOptionPane.showMessageDialog(null, "Você é menor de idade.");
        }
    }
}
