package BFS;

/* 
#BOJ_1926 : 그림

>알고리즘 : BFS

>문제풀이 아이디어
 */
import java.util.*;
import java.io.*;

public class BOJ_1926 {
    static Queue<codi> queue;
    static int N,M,ans,max,tmp;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        solve();
    }

    static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] > 0 && !visited[i][j]){
                    queue.add(new codi(i,j));
                    visited[i][j] = true;
                    ans++;
                    tmp = 1;

                    while(!queue.isEmpty()){
                        codi cur = queue.poll();

                        for(int dir=0;dir<4;dir++){
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];

                            if(nx >= N || ny >= M || nx < 0 || ny < 0)
                                continue;

                            if(map[nx][ny] <= 0 || visited[nx][ny])
                                continue;

                            queue.add(new codi(nx,ny));
                            visited[nx][ny] = true;
                            tmp++;
                        }
                    }

                    if(max < tmp)
                        max = tmp;
                    
                }
            }
        }

        System.out.println(ans);
        System.out.println(max);
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
