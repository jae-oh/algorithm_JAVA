package Array;

/* 
#BOJ_2563 : 색종이
가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 
이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 
이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.

예를 들어 흰색 도화지 위에 세 장의 검은색 색종이를 그림과 같은 모양으로 붙였다면 검은색 영역의 넓이는 260이 된다

>알고리즘 : Array

>문제풀이 아이디어
 */

import java.io.*;
import java.util.*;

public class BOJ_2563 {
    static int cnt, row, col, ans;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        solve();
    }

    static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[101][101];

        cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<cnt; i++){
            st = new StringTokenizer(br.readLine(), " ");

            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());

            for(int j=row; j<row+10; j++){
                for(int k=col; k<col+10; k++){
                    map[j][k]++;
                }
            }
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j] != 0)
                    ans++;
            }
        }

        System.out.println(ans);
    }
}
