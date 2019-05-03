import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		for(int i = 1 ; i <= cases ; ++i) {
			
			boolean[] in = new boolean[10];
			for(int j = 0 ; j < 10 ; ++j) {
				int tmp = sc.nextInt();
				if(tmp==1)
					in[j] = true;
				else
					in[j] = false;
			}
			
			int target = sc.nextInt();
			int tmp = calc(in, target);
			if(tmp !=-1)
				System.out.println("#"+i+" "+(tmp+1));
			else
				System.out.println("#"+i+" "+(-1));
		}
		sc.close();
	}
	
	static int calc(boolean[] in, int target) {	
		int min = 9999999;
		for(int i = 2 ; i*i<=target ; ++i) {
			int a = target%i;
			if(a == 0) {
				int tmp = isInputable(in, i); 
				if(tmp != -1) {
					int sub = calc(in, target/i);
					if(sub != -1)
						min = (min>(sub+tmp+1)) ? (sub+tmp+1) : min;
				}
			}
		}
		
		int a = isInputable(in, target);
		
		if(min==9999999) {
			return (a != -1)? a : -1;
		}
		else
			return (a != -1 && a < min)? a : min;
	}
	
	static int isInputable(boolean[] in, int a) {
		if(a<10)
			return (in[a] == true) ? 1 : -1;
		
		else {
			int tmp = a%10;
			if(in[tmp]) {
				int b = isInputable(in, (a/10));
				if(b != -1)
					return b+1;
				else
					return -1;
			}
			else
				return -1;
		}
	}

}
