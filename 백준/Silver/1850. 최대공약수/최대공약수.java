import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/*
최대 공약수 (유클리드 호제법)
 */
public class Main {

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long a = sc.nextLong();
        long b = sc.nextLong();
        
        long result = gcd(a, b);
        
        while (result > 0) {
            bw.write("1");
            result--;
        }
        bw.flush();
        bw.close();
        
    }
    
    public static long gcd (long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
