package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackTracking4 {

    static int[] result = new int[9];
    static void combination(int[] arr, int start, int n, int r, int size) {

        if(r == 0) {
            String str = "";
            for(int j=size;j>=1;j--){
                str +=  result[j] + " ";
            }

            System.out.println(str);
            return;
        }

        for(int i=start; i<n; i++) {
            result[r] = i+1;
            combination(arr, i , n, r - 1, size); // start(i) 변화를 주지 않으면 중복 조합이 가능!
        }
    }

    public static void solution(int n, int m) {

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }

//            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
        combination(arr, 0, n , m, m);

    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bf.readLine();
        int n = Integer.parseInt(tmp.split(" ")[0]);
        int m = Integer.parseInt(tmp.split(" ")[1]);

        solution(n,m);
    }
}
