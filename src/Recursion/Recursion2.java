package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion2 {

    static int fibonacci(int n){
        if(n <= 1)
            return n;

        //Fn = Fn-1 + Fn-2
        return fibonacci(n-1 ) + fibonacci(n-2 );

    }
    public static void solution(int n) {
        System.out.println(fibonacci(n));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bf.readLine();
        int n = Integer.parseInt(tmp);
        solution(n);
    }

}
