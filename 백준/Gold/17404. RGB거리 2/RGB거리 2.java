import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] cost = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];
        int[] paint = new int[N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[1][j] = cost[1][j];
                } else {
                    dp[1][j] = 1001;
                }
            }

            for (int k = 2; k < N + 1; k++) {
                dp[k][0] = Math.min(dp[k-1][1], dp[k-1][2]) + cost[k][0];
                dp[k][1] = Math.min(dp[k-1][0], dp[k-1][2]) + cost[k][1];
                dp[k][2] = Math.min(dp[k-1][0], dp[k-1][1]) + cost[k][2];
                if (k == N) {
                    if (i == 0) {
                        paint[i] = Math.min(dp[N][1], dp[N][2]);
                    }
                    if (i == 1) {
                        paint[i] = Math.min(dp[N][0], dp[N][2]);
                    }
                    if (i == 2) {
                        paint[i] = Math.min(dp[N][0], dp[N][1]);
                    }
                }
            }
        }

        System.out.println(Math.min(paint[0], Math.min(paint[1], paint[2])));
    }
}
