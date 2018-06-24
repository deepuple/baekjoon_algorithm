import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int[] in = new int[a];
		for(int i = 0 ; i<a ; ++i) {
			in[i] = i;
		}
		
		perm(in, 0, a, b);
		//c = new int[b];
		//comb(in, 0, a, b);
	}
	
	static void swap(int[] in, int a, int b) {
		int tmp = in[a];
		in[a] = in[b];
		in[b] = tmp;
	}
	
	static void perm(int[] in, int depth, int length, int k) {
		if(depth == k) {
			System.out.println(Arrays.toString(in));
			return;
		}
		
		for(int i = depth; i<length ; ++i) {
			swap(in, i, depth);
			perm(in, depth+1, length, k);
			swap(in, i, depth);
		}
	}
	
	static int sTop = 0;
	static int[] c;
	static void push(int in) {
		c[sTop++] = in;
	}
	static void pop() {
		sTop--;
	}
	
	static void comb(int[] in, int index, int length, int k) {
		if(k==0) {
			System.out.println(Arrays.toString(c));
			return;
		}
		
		for(int i = index ; i <=length-k ; ++i) {
			push(i);
			comb(in, i+1, length, k-1);
			pop();
		}
	}
}
