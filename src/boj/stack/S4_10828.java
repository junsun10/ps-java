// 스택 ( 정답 )
// 알고리즘: 스택

package boj.stack;

import java.io.*;
import java.util.*;

public class S4_10828 {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());

        solution();
    }

    static void solution() throws Exception {

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String method = st.nextToken();
            if ("push".equals(method)) {
                int x = Integer.parseInt(st.nextToken());
                push(x);
            }
            else {
                if ("pop".equals(method)) {
                    pop();
                }
                else if ("size".equals(method)) {
                    size();
                }
                else if ("empty".equals(method)) {
                    empty();
                }
                else {
                    top();
                }
            }
        }

        System.out.println(sb);
    }

    static void push(int x) {
        stack.push(x);
    }

    static void pop() {
        if (!stack.isEmpty()) {
            int pop = stack.pop();
            sb.append(pop+"\n");
        }
        else {
            sb.append(-1+"\n");
        }
    }

    static void size() {
        sb.append(stack.size()+"\n");
    }

    static void empty() {
        if (stack.isEmpty()) {
            sb.append(1+"\n");
        }
        else {
            sb.append(0+"\n");
        }
    }

    static void top() {
        if (!stack.isEmpty()) {
            sb.append(stack.peek()+"\n");
        }
        else {
            sb.append(-1+"\n");
        }
    }
}
