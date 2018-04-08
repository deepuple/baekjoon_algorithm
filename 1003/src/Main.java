import java.util.*;

public class Main {

    static int count0;
    static int count1;
    static int[] memo;

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    int cases = sc.nextInt();

	    for (int i =0 ; i<cases ;++i){
	        int in = sc.nextInt();
/*
	        count0 = 0;
	        count1 = 0;
	        memo = new int[in+1];
	        fibo(in);
            System.out.println(count0+" "+count1);
*/
            memo = new int[2];
            memo[0] = 1;
            memo[1] = 0;

            for( int j = 0 ; j < in ; ++j){
                int tmp = memo[0];
                memo[0] = memo[1];
                memo[1] = memo[1]+tmp;
            }
            System.out.println(memo[0]+" "+memo[1]);
        }
    }
    /*  fail
    static int fibo(int in){
        if(in == 0){
            count0++;
            return 0;
        }else if(in == 1){
            count1++;
            return 1;
        }else if(memo[in]!=0){
            return memo[in];
        }else
            return fibo(in-1)+fibo(in-2);
    } */
}
