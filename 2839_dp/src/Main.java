import java.util.*;

public class Main{

    static int[] memo = new int[10];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        for(int i = 0; i< cases; ++i) {
            sc.nextLine();

            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(checkCaing(x,y,a,b));
        }


    }

    static int checkCaing(int x, int y, int a, int b){
        int lcm = x*y/gcd(x, y);
        int ret = -1;

        for(int i = 0; i * x < lcm; ++i){
            int seq = (i * x) + a;
            if((seq-b) % y == 0)
                return seq;
        }

        return -1;
    }

    static int gcd(int x, int y){
        if( x % y == 0)
            return y;

        return gcd(y, x % y);
    }
}