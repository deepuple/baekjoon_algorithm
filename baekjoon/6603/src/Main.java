import java.util.*;

class Main{
	static int[] comb;
	static boolean[] v;
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		while(true){
			int num = sc.nextInt();
			if(num==0)
				break;
			int[] in  = new int[num];
			v = new boolean[num];
			comb = new int[6];

			for(int i = 0 ; i<num ; i++){
				in[i] = sc.nextInt();
			}
			//comb(in, 0, 0);
			comb2(in, 0, num, 6);
			System.out.println();
		}
	}
	
	static int stackTop = 0;
	static void push(int in) {
		comb[stackTop++] = in;
	}
	static void pop() {
		stackTop--;
	}
	static void comb2(int[] in, int offset, int length, int r) {
		if(r==0) {
			for(int i = 0 ; i<comb.length ; i++){
				System.out.print(comb[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = offset ; i<=length-r; ++i) {
			push(in[i]);
			comb2(in, i+1, length, r-1);
			pop();
		}
	}
	/*
	static void comb(int[] in, int index, int cnt) {
		if(cnt==6) {
			for(int i = 0 ; i<v.length ; i++){
				if(v[i])
					System.out.print(in[i]+" ");
			}
			System.out.println();
			return;
		}
		
		if(index>=v.length)
			return;
		
		v[index] = true;
		comb(in, index+1, cnt+1);
		v[index] = false;
		comb(in, index+1, cnt);
	}

	static void comb(int[] in, int n, int r){

		if(n==r){
			for(int i = 0; i < n; ++i){
				comb[i] = i;
			}
			for(int j = 0; j<comb.length; ++j){
				System.out.print(in[comb[j]]+" ");
			}
			System.out.println();
			return;
		}

		if(r==0){
			for(int k = 0; k<comb.length; ++k){
				System.out.print(in[comb[k]]+" ");
			}
			System.out.println();
			return;
		}
		comb[r-1] = n-1;
		comb(in, n-1, r-1);
		comb(in, n-1, r);
	}
	*/
}
