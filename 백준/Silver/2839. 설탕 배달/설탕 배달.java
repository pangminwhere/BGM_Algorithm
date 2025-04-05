import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];

        if (n >= 3) {
            dp[3] = 1;
        }
        if (n >= 5) {
            dp[5] = 1;
        }

        for (int i = 6; i <= n; i++) {
            if (i % 5 == 0) {
                dp[i] = dp[i- 5] + 1;
            } else if (i % 3 == 0) {
                dp[i] = dp[i - 3] + 1;
            } else {
                if (dp[i - 3] != 0 && dp[i - 5] != 0){
                    dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
                }
            }
        }

        if (dp[n] == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(dp[n]);
    }
}
