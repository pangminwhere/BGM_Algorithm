/*
제곱이 아닌 수 찾기 (정수론)
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long Min = sc.nextLong();
        long Max = sc.nextLong();

        // 최댓값과 최솟값의 차이만큼 배열 선언
        boolean[] Check = new boolean[(int) (Max - Min + 1)];

        // 2의 제곱 수인 4부터 Max보다 작거나 같은 값까지 반복
        for (long i = 2; i * i <= Max; i++) {
            long pow = i * i;
            long start_index = Min / pow;

            if (Min % pow != 0) {
                start_index++;
            }

            for (long j = start_index; pow * j <= Max; j++) {
                Check[(int) ((j * pow) - Min)] = true;
            }
        }

        int count = 0;

        for (int i = 0; i <= Max - Min; i++) {
            if (!Check[i]) {
                count++;
            }
        }

        System.out.println(count);

    }
}
