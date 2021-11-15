package Greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy5 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] dist = new long[n - 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = scanner.nextLong();
        }
        long[] cost = new long[n];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = scanner.nextLong();
        }

        long sum = 0;
        int min_index = 0;
        for (int i = 0; i < cost.length - 1; i++) {
            if (cost[min_index] > cost[i]) {
                min_index = i;
            }
            sum += dist[i] * cost[min_index];
        }
        System.out.println(sum);

    }

}
