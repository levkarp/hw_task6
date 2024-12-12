import java.util.Scanner;
import java.util.zip.CRC32;
public class CrossZero {



        public static final int SIZE = 3;
        public static final char EMPTY = '_';
        public static final char CROSS = 'X';
        public static final char ZERO = '0';

        public static void main(String[] args) {
            //TODO поле 3х3
            //TODO ходят поочередно!
            // Побеждает тот, у кого полностью заполнена одна из диагоналей поля,
            // или одна из строк или столбцов
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

        //ВНИМАНИЕ!!! ТОЛЬКО ДЛЯ ПОЛЯ 3 НА 3
        public static boolean isWin(char[][] field, char player) {
            if (field[0][0] == player && field[0][1] == player && field[0][2] == player)
                return true;
            if (field[1][0] == player && field[1][1] == player && field[1][2] == player)
                return true;
            if (field[2][0] == player && field[2][1] == player && field[2][2] == player)
                return true;

            if (field[0][0] == player && field[1][0] == player && field[2][0] == player)
                return true;
            if (field[0][1] == player && field[1][1] == player && field[2][1] == player)
                return true;
            if (field[0][2] == player && field[1][2] == player && field[2][2] == player)
                return true;

            if (field[0][0] == player && field[1][1] == player && field[2][2] == player)
                return true;
            if (field[2][0] == player && field[1][1] == player && field[0][2] == player)
                return true;

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

