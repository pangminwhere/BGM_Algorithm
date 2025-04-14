/*
최솟값 찾기(슬라이딩 윈도우)
 */

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> dq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while(!dq.isEmpty() && dq.getLast().value > now) {
                dq.removeLast();
            }

            dq.addLast(new Node(now, i));

            if (dq.getFirst().index <= i - L) {
                dq.removeFirst();
            }
            bw.write(dq.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
    
    static class Node {
        public int value;
        public int index;
        
        public Node (int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}

