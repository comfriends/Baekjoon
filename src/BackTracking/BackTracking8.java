package BackTracking;

import java.util.Scanner;

public class BackTracking8 {

    static int[][] arr;
    static int min;

    static void func(int n, int depth, boolean[] visited, int index[]) { //int startNum2, int linkNum1, int linkNum2

        if (min == 0)
            return;
        if (depth >= n) {
            int startSum = 0;
            for (int i = 0; i < n / 2 - 1; i++) {
                for (int j = i + 1; j < n / 2; j++) {
                    startSum += arr[index[i]][index[j]] + arr[index[j]][index[i]];
                }
            }
            int linkSum = 0;
            for (int i = n / 2; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    linkSum += arr[index[i]][index[j]] + arr[index[j]][index[i]];
                }
            }
            if (min > Math.abs(startSum - linkSum))
                min = Math.abs(startSum - linkSum);
            return;
        }

        int start = 0;
        if (depth != 0 && depth != n / 2) {
            start = index[depth - 1] + 1;
        }
        for (int i = start; i < n; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            index[depth] = i;
            func(n, depth + 1, visited, index);
            visited[i] = false;
            index[depth] = 0; //초기화
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n][n];
        boolean[] visited = new boolean[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }//for

        min = 1000;
        func(n, 0, visited, index);

        System.out.println(min);
    }
}
