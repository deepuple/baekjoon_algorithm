import java.util.*;

public class Main {
	static int[] in;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		in = new int[n*2+1];
		
		for(int i = 0 ;i<n;++i) {
			in[i] = i+1;
		}
		
		int top = 0;
		int end = n-1;
		
		while(n>0) {
			System.out.print(in[top]+" ");
			in[end+1] = in[top+1];
			top +=2;
			end++;
			n--;
		}
		sc.close();
	}
}
