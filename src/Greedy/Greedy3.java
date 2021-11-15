package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Greedy3 {

    static int[] arr;
    static int sum;
    static void func(int index, int result){
        if (index == arr.length){
            System.out.println(sum);
            System.exit(0);
        }
        result += arr[index];
        sum += result;
        func(index+1, result);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int n = Integer.parseInt(str);
        arr = new int[n];
        str = bf.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.split(" ")[i]);
        }

        Arrays.sort(arr);
        sum = 0;
        func(0,0);


    }
}

