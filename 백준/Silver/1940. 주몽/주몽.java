import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] ingredient = new int[n];



        for(int i =0; i < n; i++) {
            ingredient[i] = sc.nextInt();
        }

        Arrays.sort(ingredient);

        int idx = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (ingredient[i] + ingredient[j] < m) {
                i++;
            } else if (ingredient[i] + ingredient[j] > m) {
                j--;
            } else {
                idx++;
                i++;
                j--;
            }
        }

        System.out.println(idx);
    }
}
