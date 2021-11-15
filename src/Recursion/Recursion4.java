package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion4 {


    static StringBuilder str;
    static int count;
    private static void func(int n, String from, String by, String to) {

        if (n == 1) {
            count++;
            str.append( from + " " + to);
        } else {
            func(n - 1, from, to, by);
            count++;
            str.append("\n" + from + " " + to + "\n" );
            func(n - 1, by, from, to);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bf.readLine();
        int n = Integer.parseInt(tmp);
        str = new StringBuilder();
        count = 0;
        func(n, "1", "2", "3");
        System.out.println(count);
        System.out.println(str);
    }
}
