package PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue3 {


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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                if (priorityQueue.isEmpty())
                    stringBuilder.append(0).append("\n");
                else
                    stringBuilder.append(priorityQueue.poll()).append("\n");
            } else {
                priorityQueue.add(numbers[i]);
            }
        }

        System.out.print(stringBuilder);
    }
}
