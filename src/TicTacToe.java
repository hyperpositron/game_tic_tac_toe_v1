public class TicTacToe {
    private static final char DOT_HUMAN = 'X';    // 2) Игрок №1 человек
    private static final char DOT_AI = 'O';       // 3) Игрок №2 Искусственный интеллект (Artificial intelligence)
    private static final char DOT_EMPTY = '_';    // 5.1) Заполнить пустоту
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

    // humanTurn              7) нужно действие , ход игрока
    // isValidCell           11) попал ли человек или AI в ячейку
    // isValidCell           12) попал ли человек или AI в пустую ячейку
    // aiTurn                 8) нужно действие , ход AI
    // checkWin (char DOT)    9) проверка выйграл или нет
    // isDraw                10) FieldFull есть ли вообще свободные поля(Ничья),
    // main                  13)
    public static void main(String[] args) {
        initField();
        printField();
    }


}