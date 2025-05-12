/*
집합 표현하기 (유니온 파인드)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            A[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.nextToken().equals("0")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            A[b] = a;
        }
    }

    public static int find(int a) {
        if (a == A[a]) {
            return a;
        }
        return A[a] = find(A[a]);
    }

    public static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        }

        return false;
    }
}
