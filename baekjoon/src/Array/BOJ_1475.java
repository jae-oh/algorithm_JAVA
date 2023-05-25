package Array;

/* 
#BOJ_1475 : 방 번호

>알고리즘 : Array

>문제풀이 아이디어
 */

import java.util.*;
import java.io.*;

public class BOJ_1475 {
    static int N, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        solve();
    }

    static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[10];
        ans = 0;

        while(N > 0){
            arr[N%10]++;
            N /= 10;
        }

        arr[6] += arr[9];

        if(arr[6]%2 == 1){
            arr[6] = arr[6]/2 + 1;
        }else {
            arr[6] = arr[6]/2;
        }

        for(int i=0; i<9; i++){
            if(arr[i] > ans){
                ans = arr[i];
            }
        }

        System.out.println(ans);
    }
}
