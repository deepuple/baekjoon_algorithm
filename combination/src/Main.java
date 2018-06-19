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
        //perm(n, r);
        perm2(arr, 0, n, r);

        System.out.println("---------");

        Arrays.fill(prt, 0);
        Arrays.fill(v, false);
        //comb(n, r);
        comb2(arr, 0, n, r);
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
                prt[i] = i;
            System.out.println(Arrays.toString(prt));
            return;
        }
        if(r == 0) {
            System.out.println(Arrays.toString(prt));
            return;
        }
        prt[r-1] = n-1;
        comb(n-1, r-1); // i 포함
        comb(n-1, r); // i가 포함되지 않은 경우
    }

    static void swap(int[] in, int a, int b){
        int tmp = in[a];
        in[a] = in[b];
        in[b] = tmp;
    }

    static void perm2(int[] in, int depth, int length, int r){
        if (depth==r) {
            System.out.println(Arrays.toString(Arrays.copyOf(in,r)));
            return;
        }

        for (int i = depth; i < length; i++) {
            swap(in, i, depth);
            perm2(in, depth+1, length, r);
            swap(in, i, depth); //backtrack
        }
    }

    static int stackTop = 0;
    static void push(int in){
        prt[stackTop++] = in;
    }
    static void pop(){
        stackTop--;
    }

    static void comb2(int[] in, int offset, int length, int r){
        if(r==0){
            System.out.println(Arrays.toString(prt));
            return;
        }

        for(int i = offset; i <= length-r; i++){
            push(in[i]);
            comb2(in,i+1, length,r-1);
            pop();
        }
    }
}
