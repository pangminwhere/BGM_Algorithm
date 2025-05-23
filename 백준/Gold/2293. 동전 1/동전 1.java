import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n + 1];
        int[] dp = new int[10001];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
