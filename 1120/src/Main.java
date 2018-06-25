import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] a = sc.nextLine().toCharArray();
		
		int min = a.length;
		int length_a = 0;
		int length_b = 0;
		int index_b = 0 ; 
		
		for(int i = 0 ; i<a.length ; ++i) {
			if(a[i]==' ') {
				index_b = i+1;
				length_a = i;
				length_b = a.length-i-1;
			}
		}
		
		for(int offset = 0 ; offset<length_b-length_a+1 ; ++offset) {
			int cnt = 0;
			for(int i = 0 ; i<length_a ; ++i) {
				if(a[i]!=a[index_b+i+offset])
					cnt++;
			}
			min = Math.min(min, cnt);
		}
		
		System.out.println(min);
		
		sc.close();
	}

}
