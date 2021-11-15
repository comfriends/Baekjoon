package BruteForce;

import java.util.*;

public class BruteForce5 {
    static Set<String> arr;

    static void func(String str, int count, int check) {

        arr.add(str);

        if (count == check)
            return;

        String[] add = new String[]{"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        for(int i=0;i<add.length;i++){
            for(int j=0;j<add.length;j++){
                if(arr.contains(add[i] + str + add[j]) == false) //중요포인트 ***
                    func(add[i] + str + add[j], count +1, check);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new HashSet();

        func("666", 0, 4); //4자리수가 플러스된다

        // Set을 List로 변환

        Set<Integer> arr2 = new HashSet();
        for(String item : arr){
            arr2.add(Integer.parseInt(item));
        }
        List frutList = new ArrayList(arr2); // List 정렬
        Collections.sort(frutList);
        System.out.println(frutList.get(n-1));

    }
}
