package List;

/* 
#BOJ_1158 : 요세푸스 문제
요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

>알고리즘 : Array

>문제풀이 아이디어
 */

import java.util.*;
import java.io.*;

public class BOJ_1158 {
    static int N,K;
    public static void main(String[] args) throws IOException{
        solve();
    }

    static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        /* 1번 풀이 */
        // List<Integer> aList = new ArrayList<>();
        // ListIterator<Integer> aIter = aList.listIterator();

        // for(int i=1; i<=N; i++){
        //     aIter.add(i);
        // }

        // sb.append("<");
        // while(!aList.isEmpty()){
        //     for(int i=0; i<K-1;i++){
        //         if(aIter.hasNext())
        //             aIter.next();
        //         else{
        //             aIter = aList.listIterator();
        //             aIter.next();
        //         }
        //     }

        //     if(aIter.hasNext())
        //         sb.append(aIter.next() + ", ");
        //     else{
        //         aIter = aList.listIterator();
        //         sb.append(aIter.next() + ", ");
        //     }

        //     aIter.remove();

        // }
        // sb.delete(sb.length()-2, sb.length());
        // sb.append(">");

        // System.out.println(sb.toString());

        /* 2번 풀이 */
        Queue<Integer> queue = new LinkedList<>();
        int idx = 1;

        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        sb.append("<");

        while(queue.size() != 1){
            if(idx%K != 0)
                queue.add(queue.poll());
            else
                sb.append(queue.poll() + ", ");

            idx++;
        }
        sb.append(queue.poll() + ">");

        System.out.println(sb.toString());
    }
}
