import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char DOT_HUMAN = 'X';    // 2) Игрок №1 человек
    private static final char DOT_AI = 'O';       // 3) Игрок №2 Искусственный интеллект (Artificial intelligence)
    private static final char DOT_EMPTY = '_';    // 3.1) Заполнить пустоту
    private static int fieldSizeX;                // 4) размер по оси X
    private static int fieldSizeY;                // 5) размер по оси Y
    private static char[][] field;                // 1) нужно поле
    private static final Scanner SCANNER = new Scanner(System.in);
    // 6) нужен для ввода в консоль (позволяет работать с консолью)
    // что бы запросил пользовательский ввод
    private static final Random RANDOM = new Random(); // нужен для генерации случайных чисел


    private static void initField() {
        fieldSizeY = 3;
        fieldSizeX = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    // 6)printField   рисование поя
    private static void printField() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("______");
    }

    /* Как проверить попал ли текущтий игрок чел или AI в наше поле
     * каждая координата должна быть, если значение "<" заданных и ">" 0 и "<" размера поля.
     * Но только ">="0 и "<" fieldSizeX, потому что [0] ячейка тоже должна существовать.
     * вернуть истину *
     *
     *вот у нас проврка поля по всем 4-м сторонам. По X значит слева справа, По Y значит
     * сверху снизу, проверили со всех 4-х сторон*/
    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /*Как проверить что мы попали в пустую ячейку? Что бы не путать что у нас там
     * пробел ,нижнее подчеркивание у нас есть специальная константа DOT_EMPTY
     * что бы не путаться, такие вещи лучше выделять в константы
     *
     * Если "==" вернеться "true" , если "!=" вернеться "false"*/
    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел >>>");
            x = SCANNER.nextInt() - 1; // если буква вернет 0 или -1
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));// если не валидная ячейка ,переспрашиваем или если не пустая то тоже спросить
        field[y][x] = DOT_HUMAN;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private static boolean isFieldFull() {                //проверка на ничью
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY)         // если видим хотя бы одну пустую ячейку возвращаем false
                    return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char c) {
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][2] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][0] == c && field[2][0] == c) return true;
        return false;
    }


    // humanTurn              7) нужно действие , ход игрока
    // isValidCell           11) попал ли человек или AI в ячейку ,попадание в поле впринципе
    // isEmptyCell           12) попал ли человек или AI в пустую ячейку
    // aiTurn                 8) нужно действие , ход AI
    // checkWin (char DOT)    9) проверка выйграл или нет
    // isDraw                10) FieldFull есть ли вообще свободные поля(Ничья),
    // main                  13)
    public static void main(String[] args) {
        initField();
        printField();
        while (true) {
            humanTurn(); // ходит человек
            printField(); // напечатать
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Выйграл игрок!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printField();
            while (true) {
                aiTurn(); // ходит ИИ
                printField(); // напечатать
                if (checkWin(DOT_AI)){
                    System.out.println("Выйграл компьютер!");
                    break;
            }
                if (isFieldFull()) {
                    System.out.println("Ничья");
                    break;
                }
                }
        }
    }


}