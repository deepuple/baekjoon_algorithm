import java.util.*;

public class Main {
	static int[][] val;
	static int[] comb; 
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		val = new int[n][n];
		
		for(int i = 0 ; i<n ; ++i)
			for(int j =0; j<n ; ++j)
				val[i][j] = sc.nextInt();
		
		comb = new int[n/2];
		
		System.out.println(minTeam(n, n/2));
		sc.close();
	}
	
	static int minTeam(int n, int r) {
		if(n==r) {
			for(int i = 0 ; i<n;++i)
				comb[i] = i;
			return calc();
		}
		if(r==0) {
			return calc();
		}
		comb[r-1] = n-1;
		return Math.min(minTeam(n-1,r-1), minTeam(n-1, r));
	}
	
	static int calc() {
		int[] bTeam = new int[comb.length];
		int bIdx = 0 ;
		for(int i = 0 ; i<n ; ++i) {
			if(!hasElem(i))
				bTeam[bIdx++] = i;
		}
		
		int a = getTeamEval(comb);
		int b = getTeamEval(bTeam);
		
		return Math.abs(a-b);
	}
	
	static int getTeamEval(int[] in) {
		int ret = 0;
		
		for(int i = 0 ; i< in.length ; ++i)
			for(int j = 0 ; j <in.length ;++j)
				if(j!=i)
					ret += val[in[i]][in[j]];
		
		return ret;
	}
	
	static boolean hasElem(int in) {
		boolean ret = false;
		for(int i = 0 ; i<comb.length ; ++i) {
			if(comb[i] == in)
				return true;
		}
		return ret;
	}
}
