package BackTracking;

import java.util.Scanner;

public class BackTracking3 {
    static StringBuilder stringBuilder;

    static void func(int depth, int n, int m, int numbers[]) {

        if (depth == m) {
            for (int i = 0; i < numbers.length; i++) {
                stringBuilder.append(numbers[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }


        for (int i = 0; i < n; i++) {

            numbers[depth] = i + 1;
            func(depth + 1, n, m, numbers);
            numbers[depth] = 0; //clear

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] numbers = new int[m];
        stringBuilder = new StringBuilder();
        func(0, n, m, numbers);
        System.out.print(stringBuilder);
    }
}
