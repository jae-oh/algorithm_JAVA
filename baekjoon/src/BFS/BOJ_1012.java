package BFS;

/* 
#BOJ_1475 : 방 번호

>알고리즘 : BFS

>문제풀이 아이디어
 */

import java.util.*;
import java.io.*;

public class BOJ_1012{
    static int testN,M,N,K,ix,iy,ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        solve();
    }

    static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        testN = Integer.parseInt(br.readLine());
        for(int i=0;i<testN;i++){
            Queue<codi> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            ans = 0;

            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine(), " ");

                iy = Integer.parseInt(st.nextToken());
                ix = Integer.parseInt(st.nextToken());

                map[ix][iy]++;
            }

            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(map[j][k] > 0 && !visited[j][k]){
                        queue.add(new codi(j,k));
                        visited[j][k] = true;
                        ans++;

                        while(!queue.isEmpty()){
                            codi cur = queue.poll();

                            for(int dir=0;dir<4;dir++){
                                int nx = cur.x + dx[dir];
                                int ny = cur.y + dy[dir];

                                if(nx >= N || ny >= M || nx < 0 || ny < 0)
                                    continue;

                                if(visited[nx][ny] || map[nx][ny] <= 0)
                                    continue;

                                queue.add(new codi(nx,ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        
        System.out.println(sb);
    }

    static class codi{
        int x;
        int y;

        codi(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
