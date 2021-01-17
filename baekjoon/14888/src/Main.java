import java.util.*;

public class Main {

    static int[] in;
    static int[] cmd;

    static boolean[] v;
    static int[] ret;

    static long min = 1000000000;
    static long max = -1000000000;

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    int nums = sc.nextInt();

	    in = new int[nums];
	    cmd = new int[nums-1];
	    v = new boolean[nums-1];
	    ret = new int[nums-1];

	    for(int i = 0; i < nums ; ++i){
	        in[i] = sc.nextInt();
	    }

	    int idx = 0;

        for(int j = 0 ; j < 4 ; ++j){
	        int cnt = sc.nextInt();
	        for(int k = 0 ; k < cnt; ++k){
	            cmd[idx] = j;
	            idx++;
            }
        }

        perm(nums-1, ret.length);

        System.out.println(max);
        System.out.println(min);
    }

    static void perm(int n, int r){
        if(r == 0){
            min = Math.min(min,calc(ret));
            max = Math.max(max,calc(ret));
            //System.out.println(Arrays.toString(ret));
            return;
        }

        for(int i = 0 ; i < n ; ++i){
            if(!v[i]){
                v[i] = true;
                ret[r-1] = cmd[i];
                perm(n, r-1);
                v[i] = false;
            }
        }
    }

    static int calc(int[] ret){
        int r = in[0];
        for(int i = 0 ; i < ret.length;++i){
            if(ret[i]==0)
                r +=in[i+1];
            else if(ret[i]==1)
                r -=in[i+1];
            else if(ret[i]==2)
                r *=in[i+1];
            else if(ret[i]==3)
                r /=in[i+1];
        }
        return r;
    }

}
