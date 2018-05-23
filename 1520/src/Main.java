import java.util.*;

public class Main {

    static int[][] value = new int[500][500];
    static int[][] dp = new int[500][500];

    static int row, col;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        row  = sc.nextInt();
        col  = sc.nextInt();

        for(int i = 0 ; i < row ; i++) {
            Arrays.fill(value[i], -1);
            for (int j = 0; j < col; j++)
                value[i][j] = sc.nextInt();
        }
        int num = path(row-1,col-1);
        if(num == -1)
            num = 0;
        System.out.println(num);
    }

    static int path(int y, int x){

        if(x==0 && y==0)
            return 1;

        if(dp[y][x]!=0)
            return dp[y][x];

        if(dp[y][x]==-1)
            return -1;

        if(y-1>=0 && value[y-1][x] > value[y][x]) {
            int num = path(y - 1, x);
            if(num == -1)
                num = 0;
            dp[y][x] += num;
        }
        if(y+1<row && value[y+1][x] > value[y][x]){
            int num = path(y + 1, x);
            if(num == -1)
                num = 0;
            dp[y][x] += num;
        }
        if(x-1>=0 && value[y][x-1] > value[y][x]) {
            int num =path(y, x - 1);
            if(num == -1)
                num = 0;
            dp[y][x] += num;
        }
        if(x+1<col && value[y][x+1] > value[y][x]) {
            int num = path(y, x + 1);
            if(num == -1)
                num = 0;
            dp[y][x] += num;
        }

        if(dp[y][x]==0)
            dp[y][x] = -1;

        return dp[y][x];
    }
}
