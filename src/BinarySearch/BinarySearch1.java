package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch1 {
    public static int[] src;
    public static int func(int target) {
        int start = 0;
        int end = src.length - 1;
        int mid = (end + start) / 2;
        while (end - start >= 0) {
            if (src[mid] == target) {
                //Case: Find target in array
                return 1;
            } else if (src[mid] <= target) {
                //Case: target is exist in right of array[mid]
                start = mid + 1;
            } else {
                //Case: target is exist in left of array[mid]
                end = mid - 1;
            }
            mid = (end + start) / 2;
        }
        //Case: Can't find data in array
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        src = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //메모리 초과에서 벗어남
        for (int i = 0; i < n; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(src); //이분탐색 전에 무조건 정렬!
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            sb.append(func(k) + "\n");
        }
        System.out.print(sb);
    }
}
