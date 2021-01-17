import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();
        int[] memo = new int[in+3];

        memo[1] = 0;
        memo[2] = memo[3] = 1;

        for(int i = 4; i <= in ; ++i){
            if((i%3==0)&&(i%2==0))
                memo[i] = Math.min(Math.min(memo[i/3], memo[i/2]),memo[i-1])+1;
            else if(i%3==0)
                memo[i] = Math.min(memo[i/3],memo[i-1])+1;
            else if(i%2==0)
                memo[i] = Math.min(memo[i/2],memo[i-1])+1;
            else
                memo[i] = memo[i-1]+1;
        }
        System.out.println(memo[in]);
    }

    /*
    static int minMath(int n){
        if(n==1)
            return 0;
        if(n==2 || n==3){
            return 1;
        }

        if(memo[n]!=0)
            return memo[n];

        if(n%2==0&&n%3==0){
            memo[n] = Math.min(minMath(n/3),minMath(n/2))+1;
        }else if(n%2==0){
            memo[n] = Math.min(minMath(n/2), minMath(n-1))+1;
        }else if(n%3==0){
            memo[n] = Math.min(minMath(n/3), minMath(n-1))+1;
        }else{
            memo[n] = minMath(n-1)+1;
        }
        return memo[n];
    }
     */
}
