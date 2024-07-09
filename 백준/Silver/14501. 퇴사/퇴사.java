import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N+1];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (i + T[i] <= N) {
                dp[i + T[i]] = Math.max(dp[i + T[i]],dp[i] + P[i]);
            }

            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }

        System.out.println(dp[N]);
    }
}
