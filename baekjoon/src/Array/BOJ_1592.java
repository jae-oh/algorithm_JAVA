package Array;

/* 
#BOJ_1475 : 방 번호
영식이와 친구들이 원형으로 모여서 시계방향으로 1부터 N까지 적혀있는 자리에 앉는다. 
영식이와 친구들은 공 던지는 게임을 하기로 했다. 게임의 규칙은 다음과 같다.

일단 1번 자리에 앉은 사람이 공을 받는다. 
그리고 나서 공을 다른 사람에게 던진다. 
다시 공을 받은 사람은 다시 공을 던지고, 이를 계속 반복한다.
한 사람이 공을 M번 받았으면 게임은 끝난다. (지금 받은 공도 포함하여 센다.) 
공을 M번보다 적게 받은 사람이 공을 던질 때, 현재 공을 받은 횟수가 
홀수번이면 자기의 현재 위치에서 시계 방향으로 L번째 있는 사람에게, 
짝수번이면 자기의 현재 위치에서 반시계 방향으로 L번째 있는 사람에게 공을 던진다.

>알고리즘 : Array

>문제풀이 아이디어
 */

import java.util.*;
import java.io.*;

public class BOJ_1592 {
    static int N,M,L,idx,ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        solve();
    }

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        
        idx = 1;
        ans = 0;

        arr[idx] = 1;

        while(arr[idx] != M){

            // 홀수는 시계방향으로 L
            if(arr[idx]%2 == 1){
                if(idx + L%N <= N){
                    idx += L%N;
                } else {
                    idx = idx + L%N - N;
                }

            // 짝수는 반시계방향으로 L
            } else {
                if(idx - L%N > 0){
                    idx -= L%N;
                } else {
                    idx = N + (idx - L%N);
                }
            }

            arr[idx]++;
            ans++;
        }

        System.out.println(ans);

    }
}
