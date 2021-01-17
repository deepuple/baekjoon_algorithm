import java.util.*;

public class Main {

    static int[][] map;
    static int[][] chicken;
    static int[] sel;
    static boolean[] v;

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int select = sc.nextInt();
	    int c_num = 0, j_num = 0;
	    sel = new int[select];
	    map = new int[n][n];

	    for(int i = 0 ; i < n ;++i){
	        for(int j = 0 ; j< n ;++j){
	            map[i][j] = sc.nextInt();
	            if(map[i][j]==1)
	                j_num++;
	            if(map[i][j]==2)
	                c_num++;
            }
        }

        chicken = new int[c_num][j_num];
	    get_dist(map, chicken, n);

        v = new boolean[c_num];
	    System.out.println(comb(c_num, select, j_num));


    }

    static int comb(int n, int r, int j_cnt){
        if(n==r){
            for(int j =0 ; j < n ;++j)
                sel[j] = j;
            return calc(sel, j_cnt);
        }
        if(r == 0)
            return calc(sel, j_cnt);

        sel[r-1] = n-1;
        return Math.min(comb(n-1, r-1, j_cnt), comb(n-1, r, j_cnt));
        /*
        int ret = 100000;
        if(r == 0)
            return calc(sel, j_cnt);
        for(int i = 0 ; i < n ; ++i){
            if(!v[i]){
                v[i] = true;
                sel[r-1] = i;
                ret = Math.min(ret,comb(n, r-1, j_cnt));
                v[i] = false;
            }
        }

        return ret;
        */
    }

    static int calc(int[] sel, int j_cnt){
        int ret = 0;
        for(int i = 0 ; i < j_cnt ;++i){
            int dist = 100000;
            for(int j = 0 ; j < sel.length; ++j){
                dist = Math.min(dist, chicken[sel[j]][i]);
            }
            ret += dist;
        }

        return ret;
    }

    static void get_dist(int[][] map, int[][] chicken, int n){
        int c_idx=0,i_idx=0;
        for(int i = 0 ; i < n ;++i){
            for(int j = 0 ; j< n ;++j){
                if(map[i][j]==2) {
                    i_idx = 0;
                    for(int x = 0; x< n ; ++x){
                       for(int y = 0 ; y < n; ++y){
                           if(map[x][y]==1) {
                               chicken[c_idx][i_idx] = Math.abs(i - x) + Math.abs(j - y);
                               i_idx++;
                           }
                       }
                    }
                    c_idx++;
                }
            }
        }
    }
}
