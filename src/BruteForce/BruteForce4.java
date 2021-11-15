package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class BruteForce4 {

    public static int colorCheck(char[][] chess) {

        char[][] w_chess = {{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}
        ,{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}
        ,{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}
        ,{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}};

        char[][] b_chess = {{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'}
                ,{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'}
                ,{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'}
                ,{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'}};

        int w_check = 0;
        int b_check = 0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){

                if(chess[i][j] != w_chess[i][j] )
                    w_check++;
                if(chess[i][j] != b_chess[i][j] )
                    b_check++;

            }
        }
        return (w_check > b_check) ? b_check : w_check;
//        System.out.println(w_check + " " + b_check);
    }
    public static int solution(int n, int m, char[][] board) {

        //board -> 8 * 8

        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                //체스 만들기 가능한지 체크
                if (i+8 <= n && j+8 <= m){

                    //board -> 8*8 체스판 만들기
                    char[][] chess = new char[8][8];
                    int row = 0;
                    for(int k=i;k<i+8;k++){
                        System.arraycopy(board[k], j, chess[row], 0, 8);
                        row++;
                    }

                    // 색깔 확인
                    set.add(colorCheck(chess));
                }else
                    break;
            }
        }

        int answer=n*m;
        for(int item : set){
            if (item < answer ){
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

        char board[][] = new char[n][m];
        for(int i=0;i<n;i++){
            tmp = bf.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = tmp.split("")[j].charAt(0);
            }
        }

        System.out.println(solution(n,m,board));
//        System.out.println(solution(10,13,new char[][]{{BBBBBBBBWBWBW},{'B','W','B','W','B','W','B','W'}
//                ,{'W','B','W','B','B','B','W','B'},{'B','W','B','W','B','W','B','W'}
//                ,{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}
//                ,{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}
//        }));

    }
}
