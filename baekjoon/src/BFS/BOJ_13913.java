package BFS;

/* 
#BOJ_1926 : 숨바꼭질4

>알고리즘 : BFS

>문제풀이 아이디어
 */

import java.util.*;
import java.io.*;

public class BOJ_13913 {
    static Queue<pair> queue;
    static int N,K,ans;
    static boolean[] visited;
    static int[] road;
    public static void main(String[] args) throws IOException{
        solve();
    }

    static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        queue = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[200001];
        road = new int[200001];

        queue.offer(new pair(N,0));
        visited[N] = true;
        road[N] = -1;

        while(!queue.isEmpty()){
            pair cur = queue.poll();

            for(int i=0;i<3;i++){
                int next = 0;
                if(i==0){
                    next = cur.cd-1;
                }else if(i==1){
                    next = cur.cd+1;
                }else if(i==2){
                    next = cur.cd*2;
                }

                if(next > 200000 || next < 0)
                    continue;

                if(visited[next])
                    continue;

                if(next == K){
                    ans = cur.cnt+1;
                    road[next] = cur.cd;
                    queue.clear();
                    break;
                }

                queue.offer(new pair(next, cur.cnt+1));
                visited[next] = true;
                road[next] = cur.cd;
                
            }
        }

        for(int i=K;i!=N;i=road[i]){
            sb.insert(0, i + " ");
        }
        sb.insert(0, N + " ");

        System.out.println(ans);
        System.out.println(sb);
    }

    static class pair{
        int cd;
        int cnt;

        pair(int cd, int cnt){
            this.cd = cd;
            this.cnt = cnt;
        }
    }
}
