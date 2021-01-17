import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = sc.nextInt();

        int[] coin = new int[n+1];

        for(int i = 1 ; i <= n ; ++i) {
            coin[i] = sc.nextInt();
        }

        Arrays.sort(coin);

        int[] dp = new int[total+1];
        dp[0] = 1;
        for ( int i = 1; i <= n; i++ ){
            for ( int j = coin[i]; j <= total; j++ ){
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[total]);
    }

}

