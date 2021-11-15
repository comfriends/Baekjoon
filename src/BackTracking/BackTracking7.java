package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackTracking7 {

    static int min;
    static int max;
    static void func(int[] number, int[] operator, int start, int result) {

        if (start >= number.length){
            if ( result<min)
                min = result;
            if(result > max)
                max = result;
            return;
        }


//        for(int i=start;i<number.length;i++){

            if (start == 1){
                result = number[0];
            }
            int a = number[start];

            for(int j=0;j<4;j++){
                if (operator[j] !=0){
                    operator[j]--;
                    if (j == 0)
                        func( number, operator, start+1, result + a);
                    else if (j == 1)
                        func( number, operator, start+1, result - a);
                    else if (j == 2)
                        func( number, operator, start+1, result * a);
                    else
                        func( number, operator, start+1, result / a);
                    operator[j]++;
                }
            }



//        }

    }

    static char calc(int[] operator){
        for(int i=0;i<4;i++){
            if (operator[i] != 0){
                operator[i]--;
                if (i == 0){
                    return '+';
                }else if (i==1){
                    return '-';
                }else if (i==2){
                    return '*';
                }else {
                    return '/';
                }
            }
        }// for
        return ' ';
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bf.readLine();
        int n = Integer.parseInt(tmp);
        int[] number = new int[n];
        tmp = bf.readLine();
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(tmp.split(" ")[i]);
        }
        tmp = bf.readLine();
        int[] operator = new int[4];
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(tmp.split(" ")[i]);
        }

        min = 1000000001;
        max = -1000000001;
        func(number, operator, 1, 0);
        System.out.println(max);
        System.out.println(min);
    }
}
