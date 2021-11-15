package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HanoiTower {

    static StringBuilder stringBuilder;

    static void hanoitop(int departure, int destination, int n) {
        if (n == 0)
            return;

        int otherStick = 6 - departure - destination;
        hanoitop(departure, otherStick, n - 1);
        stringBuilder.append(departure)
                .append(" ")
                .append(destination)
                .append("\n");

        stringBuilder.append(String.format("%s %s\n", departure, destination));

        hanoitop(otherStick, destination, n - 1);
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        System.out.println((int) Math.pow(2, n) - 1);
//        stringBuilder = new StringBuilder();
//        hanoitop(1, 3, n);
//        System.out.print(stringBuilder);


        String str = "AB";
        String str2 = "AB";

        Scanner scanner = new Scanner(System.in);
        str2 = scanner.next();

        System.out.println(str==str2);
        System.out.println(str.equals(str2));
    }
}
