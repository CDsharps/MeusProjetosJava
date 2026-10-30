import java.util.Scanner;

public class useIt {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Animal animal1 = new Animal("Rodolfo", "Dobberman", 20, 15, 5);
        Animal animal2 = new Animal("Dominic", "Shitzu", 80, 74, 11);

        animal1.comer();
        animal2.comer();

        animal1.show();
        System.out.println();
        animal2.show();
    }
}