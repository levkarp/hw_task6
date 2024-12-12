import java.util.Random;

public class TurnMatr {
    public static final int SIZE = 8;
    public static int[][] colors = new int[SIZE][SIZE];
    public static int[][] rotatedColors = new int[SIZE][SIZE];

    public static void main(String[] args) {
        System.out.println("дана матрица");


        // Теперь заполним матрицу случайными значениями в диапазоне от 0 до 255:
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // для случайных значений воспользуемся готовым решением из библиотеки java.util.Random
                colors[i][j] = random.nextInt(256);
                // rotatedColors [i][j] =colors[j][i];
            }
        }

        printMatr(colors);
        rotateMatrix270(colors);
        printMatr(rotatedColors);
    }

    public static void printMatr(int[][] matrix) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // %4d означает, что мы под каждый номер резервируем 4 знака
                // (незанятые будут заполнены пробелами)
                // таким образом, у нас получится ровная таблица
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.println();
        }


    }

    public static void rotateMatrix270(int[][] matrix) {

        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                rotatedColors[matrix.length - 1 - j][i] = matrix[i][j];
            }
            System.out.println();
        }

    }

    public static void rotmatr90() {
        int[][] newMatrix90 = new int[SIZE][SIZE];
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                newMatrix90[j][colors.length-1-i]=colors[i][j]; // TODO на 180
            }
        }
    }
}
    /*
        Выводим матрицу на экран (оформите это в виде отдельного метода):

        Для повернутой матрицы создадим пустой массив той же размерности:
        int[][] rotatedColors = new int[SIZE][SIZE];
        Новая матрица должна принять значения ячеек первой матрицы, но с поворотом на 90 градусов
         часовой стрелке. Это значит, что значение первой ячейки rotatedColors[0][0] (
         ) новой матрицы должно быть равно первому значению ячейки последней строки матрицы colors
          (colors[SIZE-1][0]).
                Исходя из вышесказанного нужно:
        написать циклы, при помощи которых можно пробежаться по матрицам,
        каждому элементу новой матрицы rotatedColors присвоить соответствующее значение из имеющейся
        colors матрицы.
        Перебор элементов матрицы можно организовать встроенными циклами так же, как вы вывели значения
         на экран colors матрицы.

                Задача 1.1. Поворот матрицы на 90/180/270 градусов
        Добавьте в задачу #1 возможность вводить угол поворота (кратный 90) с клавиатуры.



*/



