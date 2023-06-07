package Stack;

/* 
#BOJ_1935 : 후위 표기식2

>알고리즘 : Stack

>문제풀이 아이디어
 */
import java.util.*;
import java.io.*;

public class BOJ_1935 {
    static int N;
    static int[] arr;
    static String ans;
    public static void main(String[] args) throws IOException{
        solve();
    }

    static void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Double> st = new Stack<>();

        N = Integer.parseInt(br.readLine());
        sb.append(br.readLine());

        arr = new int[N+1];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<sb.length();i++){
            char tmp = sb.charAt(i);
            double n1,n2;

            if(tmp != '+' && tmp != '-' && tmp != '*' && tmp != '/')
                st.add((double)arr[tmp-65]);
            else{
                n1 = st.pop();
                n2 = st.pop();

                if(tmp == '+'){
                    st.add(n2+n1);
                }else if(tmp == '-'){
                    st.add(n2-n1);
                }else if(tmp == '*'){
                    st.add(n2*n1);
                }else if(tmp == '/'){
                    st.add(n2/n1);
                }
            }
        }

        ans = String.format("%.2f", st.pop());

        System.out.println(ans);

    }
}
