package BruteForce;

import java.util.Scanner;

public class BruteForce2 {

    static int min;
    static void func(int n, int check){

        if (n == 0)
            return ;

        int length = (int)(Math.log10(n)+1);
        if (length * 9 < check - n)
            return ;

        int sum = 0;
        int num = n;
        while(num > 0) {
            sum += num%10; //자릿수
            num /= 10;
        }

        if (n + sum == check){
            if (n  < min)
                min = n;
        }

        func(n - 1, check);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        min = 1000001;
        func(n-1, n);
        if (min == 1000001)
            System.out.println(0);
        else
            System.out.println(min);
    }
}
