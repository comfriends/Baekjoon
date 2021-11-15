package PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //최소 힙
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (a, b) -> {
                    if (Math.abs(a) == Math.abs(b)) // 절대값 같으면
                        return (a > b) ? 1 : -1; //오름차순. 음수
                    else
                        return (Math.abs(a) > Math.abs(b)) ? 1 : -1;
                }
        );
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
    }
}
