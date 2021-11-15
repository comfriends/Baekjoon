package BruteForce;

import java.util.Scanner;

public class BruteForce3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] person = new int[n][3];
        for(int i=0;i<n;i++){
            String tmp = sc.next();
            person[i][0] = Integer.parseInt(tmp);
            tmp = sc.next();
            person[i][1] = Integer.parseInt(tmp);
            person[i][2] = 1;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (i != j){
                    if (person[i][0] < person[j][0] && person[i][1] < person[j][1]){
                        person[i][2]++;
                    }
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(person[i][2] + " ");
        }
        System.out.println(str);

    }
}
