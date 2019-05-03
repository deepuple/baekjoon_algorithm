import java.util.*;

class Main{
	static int[] comb;
	static int[] brute;
	static int n_b;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n_a = sc.nextInt();
		n_b = sc.nextInt();
		int r = sc.nextInt();
	
		comb = new int[r];
		brute = new int[r];
		comb(n_a, r);
	}
	
	static void comb(int n, int r) {
		if(n == r) {
			for(int i = 0 ; i < r ; ++i)
				comb[i] = i;
			brute(n_b, comb.length);
			return;
		}
		if(r == 0) {
			brute(n_b, comb.length);
			return;
		}
		comb[r-1] = n-1;
		comb(n-1, r-1);
		comb(n-1, r);
	}
	
	static void brute(int n, int depth) {
		if(depth==0) {
			System.out.println(Arrays.toString(comb));
			System.out.println(Arrays.toString(brute));
			//check();
			return;
		}
		
		for(int i = 0 ; i < n ; ++i) {
			brute[depth-1] = i;
			brute(n, depth-1);
		}
	}
}