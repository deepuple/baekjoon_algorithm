import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		
		int[] in = new int[nums];
		
		for(int i = 0 ; i < nums ;++i)
			in[i] = sc.nextInt();
		
		qsort(in, 0, nums-1);
		
		for(int i = 0 ; i < nums ;++i)
			System.out.println(in[i]);
		
		sc.close();
	}
	
	static void qsort(int[] arr, int start, int end) {
		int i = start;
		int j = end;
		int p = arr[(start+end)/2];
		
		while(i<=j) {
			while(arr[i]<p)
				i++;
			while(arr[j]>p)
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