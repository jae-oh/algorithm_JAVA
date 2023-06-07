package BFS;

/* 
#BOJ_1926 : DFS와 BFS

>알고리즘 : DFS + BFS

>문제풀이 아이디어
 */

import java.util.*;
import java.io.*;

public class BOJ_1260 {
    static StringBuilder sb;
    static int vN, eN, start;
    static Queue<Integer> queue;
    static List<Integer>[] edge;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        solve();
    }

    static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        vN = Integer.parseInt(st.nextToken());
        eN = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        edge = new LinkedList[vN+1];

        for(int i=0;i<vN+1;i++){
            edge[i] = new LinkedList<Integer>();
        }

        for(int i=0;i<eN;i++){
            st = new StringTokenizer(br.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            edge[v1].add(v2);
            edge[v2].add(v1);
        }

        for(int i=1;i<vN+1;i++){
            Collections.sort(edge[i]);
        }

        //DFS
        sb = new StringBuilder();
        visited = new boolean[vN+1];

        dfs(start);

        System.out.println(sb);

        //BFS
        sb = new StringBuilder();
        queue = new LinkedList<>();
        visited = new boolean[vN+1];

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur + " ");

            for(int i=0;i<edge[cur].size();i++){
                int next = edge[cur].get(i);

                if(visited[next])
                    continue;

                queue.offer(next);
                visited[next] = true;
            }
        }

        System.out.println(sb);

    }

    static void dfs(int cur){
        visited[cur] = true;
        sb.append(cur + " ");

        for(int i=0;i<edge[cur].size();i++){
            if(!visited[edge[cur].get(i)])
                dfs(edge[cur].get(i));
        }
    }
}
