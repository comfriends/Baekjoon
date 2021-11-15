package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch6 {
    static long n;

    static long func(long min, long max, long m) {

        if (min > max)
            return -1;
        long mid = (min + max) / 2;
        long sum = 0;
        long value = 0;//찾는 숫자
        for (int i = 1; i <= n; i++) {
            long count = (mid / i > n) ? n : (mid / i);
            sum += count;
            if (value < count * i)
                value = count * i;
        }

        long result;
        if (sum >= m) { //mid 값을 낮춰도 돼
            result = func(min, mid - 1, m);
        } else {
            result = func(mid + 1, max, m);
        }

        if (result == -1) { //부모 결과가 안좋으면
            if (sum >= m) {
                return value;
            } else {
                return -1;
            }
        } else {
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        long m = Integer.parseInt(br.readLine());
        System.out.println(func(1, n*n, m)); //인덱스
    }
}
