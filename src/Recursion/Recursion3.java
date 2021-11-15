package Recursion;

import java.io.IOException;
import java.util.Scanner;

public class Recursion3 {

    static boolean[][] map;

    static void recursion(int x, int y, int n, boolean outCheck) {
        if (n <= 1) {
            map[x][y] = outCheck;
            return;
        }

        if (outCheck == false) {
            return;
        }

        int x1 = 0 + x;
        int x2 = (1 * n / 3) + x;
        int x3 = (2 * n / 3) + x;

        int y1 = 0 + y;
        int y2 = (1 * n / 3) + y;
        int y3 = (2 * n / 3) + y;

        recursion(x1, y1, n / 3, true);
        recursion(x2, y1, n / 3, true);
        recursion(x3, y1, n / 3, true);

        recursion(x1, y2, n / 3, true);
        recursion(x2, y2, n / 3, false);
        recursion(x3, y2, n / 3, true);

        recursion(x1, y3, n / 3, true);
        recursion(x2, y3, n / 3, true);
        recursion(x3, y3, n / 3, true);

    }


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        map = new boolean[n][n];

        recursion(0, 0, n, true);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j])
                    answer.append("*");
                else
                    answer.append(" ");
            }
            answer.append("\n");
        }

        System.out.println(answer);

    }
}
