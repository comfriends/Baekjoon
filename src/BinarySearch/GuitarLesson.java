package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuitarLesson {
    public static int[] arr;

    static long func(long min, long max, int m) {

        if (min > max)
            return -1;

        long mid = (min + max) / 2;
        long sum = 0;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] > mid) {
                count = m+1;
                break;
            }
            if (sum > mid) {
                sum = arr[i];
                count++;
            }
        }

        long result;
        if (count > m) { //개수가 많다는 건, 여러개를 쪼갤 정도로 mid 값이 작다는 의미
            result = func(mid + 1, max, m);
        } else {
            result = func(min, mid - 1, m);
        }

        if (result == -1) { //부모 값이 문제
            if (count <= m) {
                return mid;
            } else {
                return -1;
            }
        } else {
            return result;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //메모리 초과에서 벗어남
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " "); //메모리 초과에서 벗어남
        arr = new int[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
        }
        System.out.println(func(arr[n - 1], max, m));
    }
}
