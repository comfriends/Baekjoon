package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch2 {

    public static int[] arr;
    private static int lowerBound(int target) { //특정 target보다 크거나 같은 첫번째 원소의 인덱스
        int begin = 0;
        int end = arr.length-1;

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(arr[mid] >= target) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        return end;
    }

    private static int upperBound(int target) { //특정 target보다 큰 첫번째 원소의 인덱스를 리턴한다.
        int begin = 0;
        int end = arr.length-1;

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(arr[mid] <= target) {
                begin = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //메모리 초과에서 벗어남
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //이분탐색 전에 무조건 정렬!
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            int a = lowerBound(k);
            int b = upperBound(k);
            if (k == arr[b])
                b++;
            sb.append( b-a + " ");
        }
        System.out.println(sb);
    }
}
