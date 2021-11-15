package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion1 {
    static int func(int n){
        if(n <= 2 )
            return 2;
        return n * func(n-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bf.readLine();
        int n = Integer.parseInt(tmp);
        if (n == 0  || n == 1)
            System.out.println("1");
        else
            System.out.println(func(n));

    }
}
