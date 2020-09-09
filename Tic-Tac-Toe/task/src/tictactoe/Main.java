package tictactoe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        inputMas();

        while (!xWin && !oWin && !(xCount + oCount == 9)) {

            if ((xCount + oCount) % 2 == 0) {
                inputCoordinate('X');
            } else {
                inputCoordinate('O');
            }
            xCount = 0;
            oCount = 0;
            gameCheck();
            if (Math.abs(xCount - oCount) > 1 || xWin && oWin) {
                System.out.println("Impossible");
            } else if (xWin) {
                System.out.println("X wins");
            } else if (oWin) {
                System.out.println("O wins");
            } else if (xCount + oCount == 9) {
                System.out.println("Draw");
            }

        }
    }

    public static char[][] mas = new char[3][3];
    public static int xCount, oCount;
    public static boolean xWin, oWin;

    public static void gameCheck() {
        for (int i = 0; i < 3; i++) {
            if (mas[i][0] == mas[i][1] && mas[i][0] == mas[i][2]) {
                if (mas[i][0] == 'X') {
                    xWin = true;
                } else if (mas[i][0] == 'O') {
                    oWin = true;
                }
            }
            if (mas[0][i] == mas[1][i] && mas[0][i] == mas[2][i]) {
                if (mas[0][i] == 'X') {
                    xWin = true;
                } else if (mas[0][i] == 'O') {
                    oWin = true;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (mas[i][j] == 'X') {
                    xCount++;
                } else if (mas[i][j] == 'O') {
                    oCount++;
                }
            }
        }
        if (mas[0][2] == mas[1][1] && mas[0][2] == mas[2][0]) {
            if (mas[0][2] == 'X') {
                xWin = true;
            } else if (mas[0][2] == 'O') {
                oWin = true;
            }
        }
        if (mas[0][0] == mas[1][1] && mas[0][0] == mas[2][2]) {
            if (mas[0][0] == 'X') {
                xWin = true;
            } else if (mas[0][0] == 'O') {
                oWin = true;
            }
        }
    }

    public static Scanner scanner = new Scanner(System.in);

    public static void inputMas() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mas[i][j] = ' ';
            }

        }
        printMas();
    }

    public static void printMas() {
        System.out.println("---------");
        System.out.println("| " + mas[0][0] + " " + mas[0][1] + " " + mas[0][2] + " |");
        System.out.println("| " + mas[1][0] + " " + mas[1][1] + " " + mas[1][2] + " |");
        System.out.println("| " + mas[2][0] + " " + mas[2][1] + " " + mas[2][2] + " |");
        System.out.println("---------");
    }

    public static void inputCoordinate(char ticOrToc) {
        boolean check = true;
        String inputString;
        int x = -1, y = 1;
        while (check) {
            inputString = scanner.nextLine();
            switch (inputString) {
                case "1 1":
                    x = 2;
                    y = 0;
                    break;
                case "2 1":
                    x = 2;
                    y = 1;
                    break;
                case "3 1":
                    x = 2;
                    y = 2;
                    break;
                case "1 2":
                    x = 1;
                    y = 0;
                    break;
                case "2 2":
                    x = 1;
                    y = 1;
                    break;

                case "3 2":
                    x = 1;
                    y = 2;
                    break;

                case "1 3":
                    x = 0;
                    y = 0;
                    break;

                case "2 3":
                    x = 0;
                    y = 1;
                    break;

                case "3 3":
                    x = 0;
                    y = 2;
                    break;


            }
            if (x * y < 0) {
                check = false;
            } else {
                if (mas[x][y] == 'X' || mas[x][y] == 'O') {
                    check = false;
                }
            }
            if (!check) {
                System.out.println("You should enter numbers!");
                check = true;
            } else {
                mas[x][y] = ticOrToc;
                printMas();
                check = false;
            }
        }
    }
}
