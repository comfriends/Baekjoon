package DivideConquer;

import java.util.Scanner;

public class DivideConquer1 {
    static int[][] arr;
    static int whiteNum;
    static int blueNum;

    static void func(int startRow, int startCol, int divide) {


        int type = arr[startRow][startCol];
        for (int i = startRow; i < startRow + divide; i++) {
            for (int j = startCol; j < startCol + divide; j++) {
                if (arr[i][j] != type) { //j - startCol
                    func(startRow, startCol, divide / 2);
                    func(startRow, startCol + divide / 2, divide / 2);
                    func(startRow + divide / 2, startCol, divide / 2);
                    func(startRow + divide / 2, startCol + divide / 2, divide / 2);
                    return;
                }
            }
        }

        if (type == 0)
            whiteNum++;
        else
            blueNum++;
        return;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        func(0, 0, n);
        System.out.println(whiteNum);
        System.out.println(blueNum);
    }
}
