/*
오일러 피 함수 구현 (오일러 피)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long result = n;

        for(long p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) {
                result = result - result / p;
                while (n % p == 0) {
                    n /= p;
                }
            }
        }

        if (n > 1) {
            result = result - result / n;
        }

        System.out.println(result);
    }
}
