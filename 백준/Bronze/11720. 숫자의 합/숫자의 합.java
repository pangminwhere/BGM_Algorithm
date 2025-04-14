import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        String sNum = scanner.next();
        char[] cNum = sNum.toCharArray();

        int sum = 0;
        for(int i = 0; i < cNum.length; i++) {
            String a = "";
            String b = a + cNum[i];
            sum += Integer.parseInt(b);
        }

        System.out.println(sum);
    }
}
