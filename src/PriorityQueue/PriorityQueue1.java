package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueue1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //최대 힙(큰 숫자를 먼저 뽑기)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int[] numbers = new int[n];
        for(int i=0;i<n;i++){
            numbers[i] = scanner.nextInt();
        }
        for(int i=0;i<numbers.length;i++){
            if (numbers[i] == 0){
                if (priorityQueue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(priorityQueue.poll());
            }else{
                priorityQueue.add(numbers[i]);
            }
        }
    }
}
