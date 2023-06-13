package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
#BOJ_2239 : 스도쿠

>알고리즘 : DFS

>문제풀이 아이디어
 */

public class BOJ_2239 {
    static StringBuilder sb;
    static int[][] map;
    static int[][] rVisited, cVisited;
    static boolean flag;
    public static void main(String[] args) throws IOException{
        solve();
    }

    static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[10][10];

        // 방문 체크
        rVisited = new int[10][10]; //행
        cVisited = new int[10][10]; //열

        for(int i=1;i<=9;i++){
            sb = new StringBuilder(br.readLine());
            for(int j=1;j<=9;j++){
                map[i][j] = sb.charAt(j-1) - 48;

                if(map[i][j] > 0){
                    rVisited[i][map[i][j]]++;
                    cVisited[j][map[i][j]]++;
                }
            }
        }

        sb = new StringBuilder();

        dfs(new codi(1,1), 9);

        System.out.println(sb);

    }

    static void dfs(codi cur, int step){
        if(flag)
            return;

        if(step == 90){
            flag = true;

            for(int i=1;i<=9;i++){
                for(int j=1;j<=9;j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }

            return;
        }

        if(map[cur.x][cur.y] == 0){
            for(int i=1;i<=9;i++){
                if(rVisited[cur.x][i] > 0 || cVisited[cur.y][i] > 0 || !squareSearch(cur, i))
                    continue;

                map[cur.x][cur.y] = i;

                rVisited[cur.x][map[cur.x][cur.y]]++;
                cVisited[cur.y][map[cur.x][cur.y]]++;
                dfs(new codi((step+1)/9, (step+1)%9+1), step+1);
                rVisited[cur.x][map[cur.x][cur.y]]--;
                cVisited[cur.y][map[cur.x][cur.y]]--;
                map[cur.x][cur.y] = 0;
            }
        } else{
            dfs(new codi((step+1)/9, (step+1)%9+1), step+1);
        }

    }

    static boolean squareSearch(codi cur, int num){
        int row = 3*((cur.x-1)/3)+1;
        int col = 3*((cur.y-1)/3)+1;

        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(i == cur.x && j == cur.y)
                    continue;
                else if(map[i][j] == num)
                    return false;
            }
        }

        return true;
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
