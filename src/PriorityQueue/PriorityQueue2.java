package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //최소 힙
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int[] numbers = new int[n];
        for(int i=0;i<n;i++){
            numbers[i] = scanner.nextInt();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<numbers.length;i++){
            if (numbers[i] == 0){
                if (priorityQueue.isEmpty())
                    stringBuilder.append(0).append("\n");
                else
                    stringBuilder.append(priorityQueue.poll()).append("\n");
            }else{
                priorityQueue.add(numbers[i]);
            }
        }

        System.out.print(stringBuilder);
    }
}
