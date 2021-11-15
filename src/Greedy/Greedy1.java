package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy1 {
    static int[] money;
    static int answer;
    static void func(int m, int index){

        if (m <= 0 || index < 0)
            return;

        if(money[index] <= m){
            int count =  check(index, m);
            m = m - (money[index] * count);
            answer += count;
        }

        func(m, index-1);
    }
    static int check(int index, int m){
        int k=1;
        while(true){
            int won = money[index] * k;
            if (won <= m){
                k++;
            } else
                break;
        }
        return k-1;
    }
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bf.readLine();
        int n = Integer.parseInt(tmp.split(" ")[0]);
        int m = Integer.parseInt(tmp.split(" ")[1]);
        money = new int[n];
        for(int i=0;i<n;i++){
            tmp = bf.readLine();
            money[i] = Integer.parseInt(tmp);
        }
        answer = 0;
        func(m,n-1);
        System.out.println(answer);
    }
}
