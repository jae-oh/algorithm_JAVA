package MST;

/* 
#BOJ_1197 : 최소 스패닝 트리

>알고리즘 : Kruskal, Prim

>문제풀이 아이디어
=> 프림으로 풀 때, LinkedList로 풀면 시간초과남..
 */

import java.io.*;
import java.util.*;

public class BOJ_1197 {
    static int vertexN, edgeN;

    /* Kruskal */
    static int[] P;
    public static void main(String[] args) throws IOException{
        //solve_01(); // kruskal
        solve_02(); // prim
    }

    static void solve_01() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        vertexN = Integer.parseInt(st.nextToken());
        edgeN = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int ans = 0;
        Edge[] edge_list = new Edge[edgeN];
        P = new int[vertexN+1];

        for(int i=0;i<edgeN;i++){
            st = new StringTokenizer(br.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edge_list[i] = new Edge(v1,v2,w);
        }

        Arrays.sort(edge_list, (o1, o2) -> (Integer.compare(o1.w, o2.w))); // 오름차순 정렬
        makeSet();

        for(int i=0;i<edgeN;i++){
            if(unionSet(edge_list[i].v1, edge_list[i].v2)){
                ans += edge_list[i].w;

                cnt++;
                if(cnt == vertexN-1)
                    break;
            }
        }

        System.out.println(ans);
    }

    static void makeSet(){
        for(int i=0;i<=vertexN;i++){
            P[i] = i;
        }
    }

    static int findSet(int cur){
        if(cur == P[cur]){
            return cur;
        }

        return findSet(P[cur]);
    }

    static boolean unionSet(int e1, int e2){
        int root1 = findSet(e1);
        int root2 = findSet(e2);

        if(root1 == root2)
            return false;
        
        P[root2] = root1;
        return true;
    }

    static class Edge{
        int v1;
        int v2;
        int w;

        Edge(int v1, int v2, int w){
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }

    static void solve_02() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        vertexN = Integer.parseInt(st.nextToken());
        edgeN = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> PQ = new PriorityQueue<>((o1,o2)->(Integer.compare(o1.w, o2.w)));
        ArrayList<Node>[] adjList = new ArrayList[vertexN+1];
        for(int i=0;i<vertexN+1;i++){
            adjList[i] = new ArrayList<Node>();
        }
        // LinkedList<Node>[] adjList = new LinkedList[vertexN+1];
        // for(int i=0;i<vertexN+1;i++){
        //     adjList[i] = new LinkedList<Node>();
        // }
        boolean[] visited = new boolean[vertexN+1];
        int ans = 0;
        int cnt = 0;


        for(int i=0; i<edgeN;i++){
            st = new StringTokenizer(br.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[v1].add(new Node(v2, w));
            adjList[v2].add(new Node(v1, w));
            // adjList[v1].push(new Node(v2, w));
            // adjList[v2].push(new Node(v1, w));
        }

        for(int i=0;i<adjList[1].size();i++){
            PQ.offer(new Node(adjList[1].get(i).v, adjList[1].get(i).w));
        }
        visited[1] = true;

        while(!PQ.isEmpty()){
            Node cur = PQ.poll();
            if(visited[cur.v])
                continue;

            ans += cur.w;
            visited[cur.v] = true;

            cnt++;
            if(cnt == vertexN-1)
                break;

            for(int i=0;i<adjList[cur.v].size();i++){
                if(visited[adjList[cur.v].get(i).v])
                    continue;
                PQ.offer(new Node(adjList[cur.v].get(i).v, adjList[cur.v].get(i).w));
            }
        }

        System.out.println(ans);
    }

    static class Node{
        int v;
        int w;

        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
}
