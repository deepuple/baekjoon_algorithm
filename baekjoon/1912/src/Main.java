import java.util.*;

public class Main {

    static int[] memo = new int[100001];
    static int[] input = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        for(int i = 1 ; i<=cases ; ++i)
            input[i] = sc.nextInt();

        Arrays.fill(memo,-1001);
        max(cases);

        int big = -1001;
        for(int j = 1;j<=cases;++j){
            big = Math.max(big, memo[j]);
        }

        System.out.println(big);
    }

    static int max(int in){
        if(in == 1)
            return memo[1] = input[1];

        if(memo[in] != -1001)
            return memo[in];

        memo[in] = Math.max(input[in], max(in-1) + input[in]);

        return memo[in];
    }
}
