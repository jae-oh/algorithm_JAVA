package DFS;

/** BOJ_1012 : 알파벳
 * 
 * 알고리즘 : DFS
 * 
 * 문제풀이 아이디어
 */

import java.util.*;
import java.io.*;

public class BOJ_1987 {
    static int R,C,ans;
    static int[][] map;
    static boolean[] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        solve();
    }

    static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[200];

        for(int i=0;i<R;i++){
            sb = new StringBuilder(br.readLine());

            for(int j=0;j<C;j++){
                map[i][j] = sb.charAt(j);
            }
        }

        dfs(new codi(0,0), 1);

        System.out.println(ans);
    }

    static void dfs(codi cur, int num){
        visited[map[cur.x][cur.y]] = true;
        
        if(num > ans)
            ans = num;

        for(int dir=0;dir<4;dir++){
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];

            if(nx >= R || ny >= C || nx < 0 || ny < 0)
                continue;
            
            if(visited[map[nx][ny]])
                continue;

            dfs(new codi(nx,ny), num+1);
        }

        visited[map[cur.x][cur.y]] = false;
    }

    static class codi{
        int x;
        int y;

        codi(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
