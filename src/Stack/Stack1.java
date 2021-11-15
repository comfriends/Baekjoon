package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bf.readLine();
        int n = Integer.parseInt(tmp);

        Stack<Integer> stack = new Stack<>();

        String[] str = new String[n];

        for(int i=0;i<n;i++){
            tmp = bf.readLine();
            str[i] = tmp;
        }//for i

        for(int i=0;i<n;i++){
            String a = str[i].split(" ")[0];
            if (a.equals("push")){
                int b = Integer.parseInt(str[i].split(" ")[1]);
                stack.push(b);
            }else if (a.equals("pop")){
                if (stack.size()==0){
                    System.out.println(-1);
                }else
                    System.out.println(stack.pop());
            }else if (a.equals("top")){
                if (stack.size()==0){
                    System.out.println(-1);
                }else
                    System.out.println(stack.peek());
            }else if (a.equals("empty")){
                int k = (stack.empty()) ? 1 : 0;
                System.out.println(k);
            }else if (a.equals("size")){
                System.out.println(stack.size());
            }
        }
    }
}
