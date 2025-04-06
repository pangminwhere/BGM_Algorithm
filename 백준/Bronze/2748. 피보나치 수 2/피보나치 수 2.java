import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] fibonacci = new long[n+1];

        fibonacci[0] = 0;
        fibonacci[1] = 1;
        if (n == 1) {
            System.out.println(fibonacci[1]);
            return;
        }

        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];

            if (i == n) {
                System.out.println(fibonacci[i]);
            }
        }

    }
}
