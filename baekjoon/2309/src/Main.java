import java.util.*;

public class Main {
	
	static int[] comb;
	static int[] in;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		in = new int[9];
		comb = new int[7];
		
		for(int i = 0 ; i < 9 ;++i)
			in[i] = sc.nextInt();
		
		if(combination(9, 7)) {
			printAsc(in, comb);
			sc.close();
			return;
		}
		//brute(in);
		sc.close();
	}
	
	static void brute(int[] in) {
		int sum = 0, a=0, b=0;
		for (int i = 0; i < 9; i++)
	    {   
	        if (sum == 100) { break; }
	        sum = 0;
	        a = i;
	        for (int j = i+1; j < 9; j++)
	        {
	            b = j;
	            sum = 0;
	            for (int k = 0; k < 9; k++)
	            {
	                if (k == a || k == b) { continue; }
	                sum += in[k];
	            }
	            if (sum == 100) { break; }
	        }
	    }
		int av = in[a];
	    int bv = in[b];
	    //qsort(in, 0, in.length-1);
	    Arrays.sort(in);
	    for (int i = 0; i < 9; i++)
	    {
	        if (in[i] == av || in[i] == bv) { continue; }
	        System.out.println(in[i]);
	    }
	}

	static boolean combination(int n, int r) {
		if(n==r) {
			for(int i = 0 ; i < n ; ++i) {
				comb[i] = i;
			}
			if(check(in, comb)) {
				return true;
			}
			return false;
		}
		
		if(r==0) {
			if(check(in, comb)) {
				return true;
			}
			return false;
		}
		
		comb[r-1] = n-1;
		if(combination(n-1,r-1))
			return true;
		
		if(combination(n-1,r))
			return true;
		
		return false;
	}

	static boolean check(int[] in, int[] co) {
		int sum = 0;
		for(int i = 0 ; i < co.length;++i) {
			sum += in[co[i]];
		}
		
		return sum==100;
	}
	
	static void printAsc(int[] in, int[] co) {
		int[] tmp = new int[co.length];
		
		for(int i = 0 ; i < co.length;++i) {
			tmp[i] = in[co[i]];
		}
		
		//qsort(tmp,0,tmp.length-1);
		Arrays.sort(tmp);
		for(int i = 0 ; i < tmp.length;++i) {
			System.out.println(tmp[i]);
		}
	}
	
	static void qsort(int[] arr, int start, int end) {
		int i = start;
		int j = end;
		int p = (start+end)/2;
		
		while(i<=j) {
			while(arr[i]<arr[p])
				i++;
			while(arr[j]>arr[p])
				j--;
			
			if(i<=j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp; 
				i++;
				j--;
			}
		}
		
		if(start < j)
			qsort(arr, start, j);
		if(i < end)
			qsort(arr, i, end);
	}
}
