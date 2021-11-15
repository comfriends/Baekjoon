package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sort6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int n = Integer.parseInt(str);
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            str = bf.readLine();
            arr[i][0] = Integer.parseInt(str.split(" ")[0]);
            arr[i][1] = Integer.parseInt(str.split(" ")[1]);
        }

        Arrays.sort(arr, (e1, e2) -> {
            if(e1[0] == e2[0]) {
                return e1[1] - e2[1];
            }
            else {
                return e1[0] - e2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(arr[i][0] + " " + arr[i][1] + "\n");
        }
        System.out.print(sb);

    }
}
