import java.util.*;

public class Main {
	
	static int[] comb;
	static int[] in;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		int sum = sc.nextInt();
		cnt = 0;
		
		in = new int[nums];
		
		for(int i = 0 ; i<nums ; ++i) {
			in[i] = sc.nextInt();
		}
		
		for(int i = 1 ; i<=nums; ++i) {
			comb = new int[i];
			combination(nums, i, sum);
		}
		
		System.out.println(cnt);
		sc.close();
	}
	
	static void combination(int n, int r, int total) {
		if(n==r) {
			for(int i = 0 ; i < r;++i)
				comb[i] = i;
			if(check(total))
				cnt++;
			return;
		}
		if(r==0) {
			if(check(total))
				cnt++;
			return;
		}
		comb[r-1] = n-1;
		combination(n-1, r-1, total);
		combination(n-1, r, total);
	}
	
	static boolean check(int total) {
		int sums = 0;
		for(int i = 0 ; i<comb.length;++i) {
			sums +=in[comb[i]];
		}
		return sums==total;
	}

}
