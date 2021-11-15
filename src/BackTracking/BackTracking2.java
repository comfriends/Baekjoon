package BackTracking;

import java.util.Scanner;

public class BackTracking2 {
    static StringBuilder stringBuilder;

    static void func(int start, int depth, int n, int m, int numbers[], boolean visited[]) {

        if (depth == m) {
            for (int i = 0; i < numbers.length; i++) {
                stringBuilder.append(numbers[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }


        for (int i = start; i < n; i++) {

            if (visited[i])
                continue;

            numbers[depth] = i + 1;
            visited[i] = true;
            func(i + 1, depth + 1, n, m, numbers, visited);
            numbers[depth] = 0; //clear
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] numbers = new int[m];
        boolean[] visited = new boolean[n];
        stringBuilder = new StringBuilder();
        func(0, 0, n, m, numbers, visited);
        System.out.print(stringBuilder);
    }
}
