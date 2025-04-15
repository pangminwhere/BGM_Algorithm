/*
오큰수 (자료구조)
 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] ans = new int[n];
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }

        bw.write("\n");
        bw.flush();

        bw.close();
        br.close();


    }
}
