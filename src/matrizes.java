import javax.swing.JOptionPane;

public class matrizes {
    public static void main(String[] args) {
        int option;

        int[][] matrix = constructMatrix("");
        if (matrix == null)
            return;

        do {

            option = errorInt(
                    "O que deseja fazer com a matriz:\n\n" +
                            "1. Exibir maior elemento\n" +
                            "2. Buscar elemento e posição do elemento\n" +
                            "3. Imprimir diagonais\n" +
                            "4. Somar colunas\n" +
                            "5. Imprimir matriz\n" +
                            "6. Sair (ESC)");

            if (option == Integer.MIN_VALUE)
                break;

            switch (option) {

                case 1:

                    write("O maior valor da matriz é: " + biggerElement(matrix));
                    break;

                case 2:

                    int element = errorInt("Digite o elemento que deseja buscar:");
                    if (element == Integer.MIN_VALUE)
                        break;

                    write(searchElement(matrix, element));
                    break;

                case 3:

                    write(printDiagonals(matrix));
                    break;

                case 4:

                    write("Soma das colunas da matriz:\n\n" + sumColumns(matrix));
                    break;

                case 5:

                    int printOption = errorInt(
                            "De que maneira deseja exibir a matriz:\n\n" +
                                    "1. Normal\n" +
                                    "2. Em Zig Zag\n");

                    switch (printOption) {

                        case 1:
                            write(printMatrix(matrix));
                            break;

                        case 2:
                            write(printZigZag(matrix));
                            break;
                    }

                    break;

                case 6:

                    write("Obrigado pela preferência!!");
                    break;

                default:
                    write("Digite uma opção válida!");
            }
        } while (option != 6);
    }

    private static String sumColumns(int[][] matrix) {

        StringBuilder plus = new StringBuilder();

        for (int j = 0; j < matrix[0].length; j++) {

            int sum = 0;

            for (int i = 0; i < matrix.length; i++) {

                sum += matrix[i][j];
            }

            plus.append("Soma da coluna ").append(j + 1).append(": ").append(sum).append("\n");
        }

        return plus.toString();
    }

    private static String printZigZag(int[][] matrix) {

        StringBuilder zigzag = new StringBuilder();
        int end = 0, size = matrix.length;;
        int right = 0, downhill = 1, down = 2, uphill = 3;

        while(end < size){

            int j=0, i=0;

            if(j%2 == 0){

                zigzag.append("[").append(matrix[i][j]).append("] ");
                j++;
                i++;
            }
        }

        return zigzag.toString();
    }

    private static String printDiagonals(int[][] matrix) {

        StringBuilder diagonals = new StringBuilder();
        int lines = matrix.length;
        int columns = matrix[0].length;

        diagonals.append("Diagonal principal: ");
        for (int i = 0; i < Math.min(lines, columns); i++) {

            diagonals.append("[").append(matrix[i][i]).append("] ");
        }

        diagonals.append("\n\nDiagonal secundária: ");
        for (int i = 0; i < Math.min(lines, columns); i++) {

            diagonals.append("[").append(matrix[i][columns - 1 - i]).append("] ");
        }

        return diagonals.toString();

    }

    private static int biggerElement(int[][] matrix) {

        int bigger = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] > bigger) {

                    bigger = matrix[i][j];
                }
            }
        }

        return bigger;
    }

    private static String searchElement(int[][] matrix, int element) {

        StringBuilder result = new StringBuilder();
        int count = 0;
        String[] positions = new String[matrix.length * matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == element) {

                    count++;
                    positions[count - 1] = "[" + (i + 1) + "][" + (j + 1) + "]";
                }
            }
        }

        if (count == 0) {

            result.append("O elemento ").append(element).append(" não se encontra na matriz.");
        } else {

            result.append("O elemento ").append(element).append(" foi encontrado ").append(count)
                    .append(" vez(es) na(s) posição(ões): \n\n");

            for (int k = 0; k < count; k++) {

                result.append(positions[k]).append("\n");
            }
        }

        return result.toString();
    }

    private static String printMatrix(int[][] matrix) {

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                text.append("[").append(matrix[i][j]).append("] ");
            }

            text.append("\n");
        }

        return text.toString();

    }

    private static int[][] constructMatrix(String letter) {

        int[] parts = errorProportion("Digite a proporção da matriz " + letter + "(?x?): ");
        if (parts == null) {

            return null;
        }

        int lines = parts[0];
        int columns = parts[1];

        int[][] matrix = new int[lines][columns];
        if (!fillMatrix(matrix, lines, columns, "Digite o número da posíção ")) {

            return null;
        }

        return matrix;
    }

    private static boolean fillMatrix(int[][] matrix, int lines, int columns, String message) {

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {

                matrix[i][j] = errorInt(message + "[" + (i + 1) + "][" + (j + 1) + "]:");
                if (matrix[i][j] == Integer.MIN_VALUE) {

                    return false;
                }
            }
        }

        return true;

    }

    private static void write(String args) {

        JOptionPane.showMessageDialog(null, args);

    }

    private static String enter(String args) {

        return JOptionPane.showInputDialog(args);

    }

    private static int[] errorProportion(String message) {

        while (true) {

            String proportion = errorString(message);
            if (proportion == null) {

                return null;
            }

            String[] parts = proportion.toLowerCase().split("x");
            if (parts.length != 2) {

                write("Formato inválido. Digite no formato ?x?");
                continue;
            }

            try {

                int lines = Integer.parseInt(parts[0]);
                int columns = Integer.parseInt(parts[1]);

                if (lines > 0 && columns > 0) {

                    return new int[] { lines, columns };
                }

                write("A proporção da matriz deve ser maior que zero!");
            } catch (NumberFormatException e) {

                write("Formato Inválido. Digite no formato ?x?");
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

    private static int errorInt(String message) {

        while (true) {
            try {

                String answer = enter(message);
                if (answer == null) {

                    write("Programa encerrado!");
                    return Integer.MIN_VALUE;
                }

                int value = Integer.parseInt(answer);

                return value;

            } catch (NumberFormatException e) {

                write("Digite algo válido no espaço destinado!!");
            }
        }
    }
}