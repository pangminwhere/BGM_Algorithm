import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (K / A[i] > 0) {
                int divide = K / A[i];
                count += divide;
                if (K == 0) {
                    break;
                }
                K %= A[i];
            }
        }

        System.out.println(count);
    }
}
