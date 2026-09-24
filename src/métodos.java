import javax.swing.JOptionPane;

public class métodos {
    public static void main(String[] args) {
        int option;

        do {

            option = errorInt(
                    "O que deseja fazer com a(s) matriz(es):\n\n" +
                            "1. Multiplicar duas matrizes\n" +
                            "2. Somar duas matrizes\n" +
                            "3. Informar se é uma matriz identidade\n" +
                            "4. Transpor uma matriz\n" +
                            "5. Imprimir a matriz\n" +
                            "6. Sair");

            if (option == Integer.MIN_VALUE) {

                break;

            }

            switch (option) {

                case 1:
                    int[][] timesA = constructMatrix("A");
                    if(timesA == null){

                        break;
                    }

                    int[][] timesB = constructMatrix("B");
                    if(timesB == null){

                        break;
                    }

                    multiplyMatrix(timesA, timesB);
                    break;

                case 2:
                    int[][] plusA = constructMatrix("A");
                    if(plusA == null){

                        break;
                    }

                    int[][] plusB = constructMatrix("B");
                    if(plusB == null){

                        break;
                    }

                    sumMatrix(plusA, plusB);
                    break;

                case 6:
                    write("Obrigado pela preferência!");
                    break;
            }
        } while (option != 6);
    }

    private static void sumMatrix(int[][] matrixA, int[][] matrixB) {

    }

    private static void multiplyMatrix(int[][] matrixA, int[][] matrixB) {

        int linesA = matrixA.length;
        int columnsA = matrixA[0].length;
        int linesB = matrixB.length;
        int columnsB = matrixB[0].length;

        if (columnsA != linesB) {

            write("Não é possível efetuar a multiplicação. O número de colunas de A deve ser igual ao número de linhas de B!");
            return;
        }

        int[][] result = new int[linesA][columnsB];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {

                int plus = 0;

                for (int k = 0; k < columnsA; k++) {

                    plus += matrixA[i][k] * matrixB[k][j];
                }

                result[i][j] = plus;
            }
        }

        write("MATRIZ C\n\n" + matrixToAnswer(result));
    }

    private static String matrixToAnswer(int[][] matrix) {

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                text.append("[").append(matrix[i][j]).append("]");
            }

            text.append("\n");
        }

        return text.toString();

    }

    private static int[][] constructMatrix(String letter) {

        int[] parts = errorProportion("Digite a proporção da matriz " + letter + " (?x?): ");
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