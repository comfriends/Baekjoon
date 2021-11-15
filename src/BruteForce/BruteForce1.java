package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BruteForce1 {
    private static Set<Integer> set = new HashSet<Integer>();
    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            int sum=0;
            for(int i=0;i<n;i++){
                if(visited[i] == true)
                    sum+= arr[i];
            }
            set.add(sum);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    public static int solution(int n, int m, int[] card) {
        boolean[] visited = new boolean[n];
        combination(card, visited, 0, n, 3);
        int answer=0;
        for(int item : set){
            if (item > answer && item <= m){
                answer = item;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException { //psvm
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bf.readLine();
        int n = Integer.parseInt(tmp.split(" ")[0]);
        int m = Integer.parseInt(tmp.split(" ")[1]);
        tmp = bf.readLine();
        int number[] = new int[n];
        for(int i=0;i<n;i++){
            number[i] = Integer.parseInt(tmp.split(" ")[i]);
        }
//        solution(5,21,new int[]{5,6,7,8,9});
        System.out.println(solution(n,m,number));
    }

}
