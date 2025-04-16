/*
ATM 인출 시간 계산하기 (삽입 정렬)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        int sum = 0;

        for (int i = 1; i < N; i++) {
            P[i] = P[i] + P[i - 1];
        }
        for (int i = 0; i < N; i++) {
            sum += P[i];
        }

        System.out.println(sum);
    }
}
