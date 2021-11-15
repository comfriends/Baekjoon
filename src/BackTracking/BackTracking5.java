package BackTracking;

import java.util.Scanner;

public class BackTracking5 {
    static int n;
    static boolean[][] arr;
    static int func(int check) {
        if (check >= n) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {

            if (checkBoard(check,i) == false) { //이 부분이 백트래킹.
                arr[check][i] = true; //깊은 복사 안하게 바꿧어!
                count += func(check + 1);
                arr[check][i] = false;
            }
        }

        return count;
    }

    static boolean checkBoard(int x, int y) {

        for (int i = 0; i < n; i++) {
            if (checkBoardHelper(x - i, y))
                return true;
            if (checkBoardHelper(x - i, y + i))
                return true;
            if (checkBoardHelper(x - i, y - i))
                return true;
//            checkBoardHelper(arr, x - i, y + i);
//            checkBoardHelper(arr, x - i, y - i);
//            checkBoardHelper(arr, x - i, y);
//            checkBoardHelper(arr, x, y + i);
//            checkBoardHelper(arr, x, y - i);
        }
        return false;
    }

    static boolean checkBoardHelper(int x, int y) {
        if (x < 0 || x >= n) return false;
        if (y < 0 || y >= n) return false;

        return arr[x][y];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new boolean[n][n];
        System.out.println(func(0));
    }
}
