import java.util.Scanner;
import java.util.zip.CRC32;

public class CrossZeroLine5 {

    public static final int SIZE = 5;
    public static final char EMPTY = '_';
    public static final char CROSS = 'X';
    public static final char ZERO = '0';

    public static void main(String[] args) {


        char[][] field = new char[SIZE][SIZE];

        for (int lines = 0; lines < SIZE; lines++) {
            for (int column = 0; column < SIZE; column++) {
                field[lines][column] = EMPTY;
            }
        }

        Scanner scanner = new Scanner(System.in);
        boolean isCrossTurn = true;
        while (true) {

            System.out.println("Ходят" + (isCrossTurn ? " крестики" : " нолики") + "!");
            System.out.println("Введи координаты");
            printField(field);
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            int linesCoordinate = Integer.parseInt(parts[0]) - 1;
            int columnCoordinate = Integer.parseInt(parts[1]) - 1;
            if (field[linesCoordinate][columnCoordinate] != EMPTY) {
                continue;
            }
            field[linesCoordinate][columnCoordinate] = isCrossTurn ? CROSS : ZERO;
            if (isWin(field, isCrossTurn ? CROSS : ZERO)) {
                System.out.println("Выиграли " + (isCrossTurn ? "крестики" : " нолики") + "!");
                break;
            } else {
                isCrossTurn = !isCrossTurn;
            }

        }
    }

    public static boolean isWin(char[][] field, char player) {
// строки
        for (int i = 0; i < SIZE; i++) {
            int row = 0;

            for (int j = 0; j < SIZE; j++) {

                if (field[i][j] == player) {
                    row++;
                }
                if (row == SIZE) {
                    return true;
                }
            }
        }
        // столбцы
        for (int i = 0; i < SIZE; i++) {
            int columns = 0;

            for (int j = 0; j < SIZE; j++) {

                if (field[j][i] == player) {
                    columns++;
                }
                if (columns == SIZE) {
                    return true;
                }
            }
        }
        // диагональ 1
        int firstDiagonal = 0;
        for (int i = 0, j=0; i < SIZE & j<SIZE; i++, j++) {


            if (field[i][j] == player) {
                firstDiagonal++;
            }
            if (firstDiagonal == SIZE) {
                return true;
            }
        }

// диагональ 2
        int secondDiagonal = 0;
        for (int i = SIZE-1, j=0; i < SIZE & j<SIZE; i--, j++) {

            if (field[i][j] == player) {
                secondDiagonal++;
            }
            if (secondDiagonal == SIZE) {
                return true;
            }
        }
        return false;
    }

    public static void printField(char[][] field) {
        for (char[] lines : field) {
            for (char column : lines) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}

