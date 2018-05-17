import java.util.*;

class Main{
	static int[] comb;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		while(true){
			int num = sc.nextInt();
			if(num==0)
				break;
			int[] in  = new int[num];
			comb = new int[6];

			for(int i = 0 ; i<num ; i++){
				in[i] = sc.nextInt();
			}
			comb(in, num, 6);
			System.out.println();
		}
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
}
