import java.io.*;

public class Main {

    static int[] memo = new int [301];
    static int[] cost = new int [301];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; ++i){
            String input = br.readLine();
            cost[i] = Integer.parseInt(input);
        }

        System.out.println(costMax(n));
    }

    static int costMax(int n){
        if(n == 0 || n == 1){
            return memo[n] = cost[n];
        }

        if(memo[n]!=0)
            return memo[n];

        if((n-3) == -1)
            memo[n] = Math.max(cost[n-1], cost[n-2])+cost[n];
        else
            memo[n] = Math.max(costMax(n-3)+cost[n-1], costMax(n-2))+cost[n];

        return memo[n];
    }
}
