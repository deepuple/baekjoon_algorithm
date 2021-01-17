import java.io.*;

public class Main {

    static int[][] memo = new int [500][500];
    static int[][] cost = new int [500][500];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; ++i){
            String[] input = br.readLine().split(" ");
	        for(int j = 0 ; j <= i ; ++j)
	            cost[i][j] = Integer.parseInt(input[j]);
        }
        int max = 0;
        for(int m = 0 ; m < n ; ++m){
	        max = Math.max(max, costMax(n-1,m));
        }

        System.out.println(max);
    }

    static int costMax(int n, int i){
        if(n==0){
            return cost[0][0];
        }

        if(memo[n][i]!=0){
            return memo[n][i];
        }

        if(i==0){
            memo[n][i] = costMax(n-1,0)+cost[n][0];
        }else if(i==n){
            memo[n][i] = costMax(n-1,n-1)+cost[n][n];
        }else{
            memo[n][i] = Math.max(costMax(n-1,i-1), costMax(n-1,i))+cost[n][i];
        }

        return memo[n][i];
    }
}
