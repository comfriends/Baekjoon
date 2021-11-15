package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch4 {
    public static int[] arr;
    static long func(long min, long max, int m){
        long max_mid = 0;
        while (min < max) {

            // 범위 내에서 중간 길이를 구한다.
            long mid = (max + min) / 2;
            long count = 0;

            // 구해진 중간 길이로 잘라서 총 몇 개가 만들어지는지를 구한다.
            for (int i = 0; i < arr.length; i++) {
                long k = (arr[i] - mid < 0) ? 0 : arr[i] - mid ;
                count += k ;
            }
            /*
             *  [upper bound 형식]
             *
             *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
             *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
             *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
             */
            if (count < m) {
                max = mid;
            } else {
                min = mid + 1;
                max_mid = mid;
            }
        }
        return max_mid;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //메모리 초과에서 벗어남
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " "); //메모리 초과에서 벗어남
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(func(0, arr[n-1], m));
    }
}
