package BFS;

/* 
#BOJ_1926 : 벽 부수고 이동하기 2

>알고리즘 : BFS

>문제풀이 아이디어
 */

import java.util.*;
import java.io.*;

public class BOJ_14442 {
    static Queue<pair> queue;
    static int N,M,K,ans;
    static String input;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        solve();
    }

    static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        map = new int[N][M];
        visited = new boolean[N][M][K+1];
        ans = -1;

        for(int i=0;i<N;i++){
            input = br.readLine();
            for(int j=0;j<input.length();j++){
                map[i][j] = input.charAt(j) - 48;
            }
        }

        queue.offer(new pair(0,0,1,0));
        visited[0][0][0] = true;
        
        if(N == 1 && M == 1){
            System.out.println(1);
            return;
        }

        while(!queue.isEmpty()){
            pair cur = queue.poll();

            for(int dir=0;dir<4;dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx<0 || ny <0 || nx>=N || ny>=M)
                    continue;
                
                if(map[nx][ny] == 1){
                    if(cur.cnt+1 > K)
                        continue;

                    if(visited[nx][ny][cur.cnt+1])
                        continue;
                    
                    queue.offer(new pair(nx,ny,cur.level+1,cur.cnt+1));
                    visited[nx][ny][cur.cnt+1] = true;
                }else {
                    if(visited[nx][ny][cur.cnt])
                        continue;

                    queue.offer(new pair(nx,ny,cur.level+1,cur.cnt));
                    visited[nx][ny][cur.cnt] = true;
                }

                if(nx == N-1 && ny == M-1){
                    ans = cur.level+1;
                    queue.clear();
                    break;
                }
            }
        }

        System.out.println(ans);

    }

    static class pair{
        int x;
        int y;
        int level;
        int cnt; // 벽 부순 횟수

        pair(int x,int y, int level, int cnt){
            this.x = x;
            this.y = y;
            this.level = level;
            this.cnt = cnt;
        }
    }
}
