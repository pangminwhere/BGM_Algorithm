/*
회의실 배정하기 (그리디 탐욕법)
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 회의 개수
        int N = sc.nextInt();

        int[][] meeting = new int[N][2];

        for (int i = 0; i < N; i++) {
            meeting[i][0] = sc.nextInt();
            meeting[i][1] = sc.nextInt();
        }

        /*
         회의의 종료 시간이 빠를 수록 다음 회의와 겹치지 않게 시작하고
         종료 시간이 같은 경우 시작 시간이 빠른 순으로 정렬해야 함
         compare 함수 사용
         */
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                if (S[1] == E[1]) { // 종료 시간이 같을 때
                    return S[0] - E[0];
                }
                return S[1] - E[1];
            }
        });

        int count = 0;
        int end = -1;

        for (int i = 0; i < N; i++) {
            if (meeting[i][0] >= end) {
                end = meeting[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
