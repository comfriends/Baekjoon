package Greedy;

import sun.rmi.server.InactiveGroupException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String[] minus = str.split("-");

        long answer = 0;
        boolean first_check = false;
        for (int i = 0; i < minus.length; i++) {
            String[] plus = minus[i].split("[+]");

            long sum = 0;
            for (int j = 0; j < plus.length; j++) { //나머지 전부 플러스
                sum += Integer.parseInt(plus[j]);
            }

            if (first_check) {
                answer -= sum;

            } else {
                answer = sum;
                first_check = true;
            }

        }

        System.out.println(answer);
    }
}
