package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackTracking6 {

    static int[][] board;

    static void func(int start) {

        if (start > 80){
            start = start;
        }


        boolean check = true;
        for (int i = start; i < 81; i++) {

            int row = i / 9;
            int col = i % 9;
            if (board[row][col] == 0) {
                check = false;
//                int[][] arr_copy = new int[9][9]; //깊은 복사
//                for(int ii=0;ii<9;ii++) {
//                    for (int jj = 0; jj < 9; jj++) {
//                        arr_copy[ii][jj] = board[ii][jj];
//                    }
//                }

                for (int j = 1; j <= 9; j++) {
                    if (checkBoard(row, col, j)) {
//                        arr_copy[check][i] = j;
                        board[row][col] = j;
                        func(i + 1);
                        board[row][col] = 0;
                    }
                }

                return;
            }
        }

        if (check) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0); //반례 : 전부 다 0을 넣어봐!
        }
        return;
    }

    static boolean checkBoardHelper2(int x1, int x2, int y, int input) {

        if (0 <= y && y < 3) {
            for (int i = x1; i < x2; i++) {
                if (board[i][0] == input || board[i][1] == input || board[i][2] == input)
                    return false;
            }
        } else if (3 <= y && y < 6) {
            for (int i = x1; i < x2; i++) {
                if (board[i][3] == input || board[i][4] == input || board[i][5] == input)
                    return false;
            }
        } else {
            for (int i = x1; i < x2; i++) {
                if (board[i][6] == input || board[i][7] == input || board[i][8] == input)
                    return false;
            }
        }
        return true;

    }

    static boolean checkBoard(int x, int y, int input) {

        if (0 <= x && x < 3) {
            if (!checkBoardHelper2(0, 3, y, input))
                return false;
        } else if (3 <= x && x < 6) {
            if (!checkBoardHelper2(3, 6, y, input))
                return false;
        } else {
            if (!checkBoardHelper2(6, 9, y, input))
                return false;
        }
        for (int i = 1; i < 9; i++) {
            if (!checkBoardHelper(x + i, y, input))
                return false;
            if (!checkBoardHelper(x - i, y, input))
                return false;
            if (!checkBoardHelper(x, y + i, input))
                return false;
            if (!checkBoardHelper(x, y - i, input))
                return false;
//            if (!checkBoardHelper( x + i, y + i, input))
//                return false;
//            if (!checkBoardHelper( x + i, y - i, input))
//                return false;
//            if (!checkBoardHelper( x - i, y + i, input))
//                return false;
//            if (!checkBoardHelper( x - i, y - i, input))
//                return false;
        }
        return true;
    }

    static boolean checkBoardHelper(int x, int y, int input) {
        if (x < 0 || x >= 9) return true;
        if (y < 0 || y >= 9) return true;

        if (board[x][y] == input)
            return false;
        return true;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String tmp = bf.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(tmp.split(" ")[j]);
            }
        }

        System.out.println(3 + 4 * 5);
        func(0);
    }
}
