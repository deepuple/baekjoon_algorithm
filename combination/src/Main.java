import java.util.*;

public class Main {

    static int[] arr;
    static int[] prt;
    static boolean[] v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        arr = new int[n];
        prt = new int[r];
        v = new boolean[n];

        for(int i = 0; i< n ; ++i){
            arr[i] = i+1;
        }

        Arrays.fill(prt, 0);
        Arrays.fill(v, false);
        perm(n, r);

        Arrays.fill(prt, 0);
        Arrays.fill(v, false);
        comb(n, r);
    }

    static void perm(int n, int r){
        if(r == 0) {
            System.out.println(Arrays.toString(prt));
            return;
        }
        for(int i = 0 ; i < n ; ++i){
            if(!v[i]){
                v[i] = true;
                prt[r-1] = i;
                perm(n, r-1);
                v[i] = false;
            }
        }
    }

    static void comb(int n, int r){
        if(n == r){
            for(int i = 0 ; i < n ; ++i)
                prt[i] = i+1;
            System.out.println(Arrays.toString(prt));
            return;
        }
        if(r == 0) {
            System.out.println(Arrays.toString(prt));
            return;
        }
        prt[r-1] = n;
        comb(n-1, r-1); // i 포함
        comb(n-1, r); // i가 포함되지 않은 경우
    }
}
