package view;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao, opcao2;

        do {

            menuPrincipal();
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:

                    do {

                        System.out.println("CONTATOS");
                        menuSecundario();
                        opcao2 = sc.nextInt();

                        switch (opcao2) {

                            case 1:

                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                break;
                            default:

                                System.out.println("Opção inválida!");
                        }
                    } while (opcao2 != 6);

                    break;
                case 2:

                    do {

                        System.out.println("COMPROMISSOS");
                        menuSecundario();
                        opcao2 = sc.nextInt();

                        switch (opcao2) {

                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                break;
                            default:

                                System.out.println("Opção inválida!");
                        }
                    } while (opcao2 != 6);

                    break;
                case 3:

                case 4:

                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    public static void menuPrincipal() {

        System.out.println("--------------\n"
                + "1 - Contatos\n"
                + "2 - Compromissos\n"
                + "3 - Resetar\n"
                + "4 - Sair\n"
                + "--------------");
    }

    public static void menuSecundario() {

        System.out.println("--------------\n"
                + "1 - Cadastrar\n"
                + "2 - Listar\n"
                + "3 - Buscar\n"
                + "4 - Atualizar\n"
                + "5 - Deletar\n"
                + "6 - Voltar\n"
                + "--------------");
    }
}
