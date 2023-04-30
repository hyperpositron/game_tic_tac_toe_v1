public class TicTacToe {
    private static final char DOT_HUMAN = 'X';    // 2) Игрок №1 человек
    private static final char DOT_AI = 'O';       // 3) Игрок №2 Искусственный интеллект (Artificial intelligence)
    private static final char DOT_EMPTY = '_';    // 3.1) Заполнить пустоту
    private static int fieldSizeX;                // 4) размер по оси X
    private static int fieldSizeY;                // 5) размер по оси Y
    private static char[][] field;                // 1) нужно поле

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
    }


}