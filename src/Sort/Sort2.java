package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort2 {
    public static int[] src;
    public static int[] tmp;
    public static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            int p = start;
            int q = mid + 1;
            int idx = p;
            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && src[p] < src[q])) {
                    tmp[idx++] = src[p++];
                } else {
                    tmp[idx++] = src[q++];
                }
            }
            for (int i = start; i <= end; i++) {
                src[i] = tmp[i];
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int n = Integer.parseInt(str);
        src = new int[n];
        tmp = new int[n];
        for(int i=0;i<n;i++){
            str = bf.readLine();
            src[i]= Integer.parseInt(str);
        }
        mergeSort(0,n-1);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(src[i] + "\n");
        }
        System.out.println(answer);

    }
}
