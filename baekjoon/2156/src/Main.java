import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        int[] dp = new int[cases+1];
        int[] wines = new int[cases+1];

        for(int i = 1 ; i<= cases; ++i){
            wines[i] = sc.nextInt();
        }

        if(cases>=1)
            dp[1] = wines[1];
        if(cases>=2)
            dp[2] = wines[1]+wines[2];
        if(cases>=3)
            dp[3] = Math.max(Math.max(wines[1]+wines[2], wines[2]+wines[3]), wines[1]+wines[3]);

        if(cases>3) {
            for (int j = 4; j <= cases; ++j) {
                dp[j] = Math.max(Math.max(dp[j-1],dp[j-2]+wines[j]),dp[j-3]+wines[j]+wines[j-1]);
            }
        }
        System.out.println(dp[cases]);

    }
}
