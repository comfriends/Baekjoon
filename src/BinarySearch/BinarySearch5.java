package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch5 {

    public static int[] arr;

    static long func(long min, long max, int m) {

        long mid = (min+max)/2;

        if (min > max)
            return -1;

        int count = 1;
        int index = 0;
        for(int i=1;i<arr.length;i++){
            if (arr[i] - arr[index] >= mid){
                count++;
                index = i;
            }
        }

        long result;
        if(count >= m){
            result = func(mid + 1, max, m);
        }else{
            result = func(min, mid - 1 , m);
        }

        if (result == - 1){
            if (count >= m){
                return mid;
            }else{
                return -1;
            }
        }else {
          return result;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //메모리 초과에서 벗어남
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(func(1, arr[n - 1] - arr[0], m));
    }
}
