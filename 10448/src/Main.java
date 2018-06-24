import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for(int i = 0 ; i< cases; ++i) {
			int in = sc.nextInt();
			
			if(check(in))
				System.out.println(1);
			else
				System.out.println(0);
		}
		sc.close();
	}
	
	static boolean check(int in) {
		boolean ret = false;
		int end = findN(in);
		for(int i = 1  ; i <= end ; ++i) {
			int in2 = in-(i*(i+1)/2);
			int end2 = findN(in2);	
			for(int j = 1 ; j <= end2 ; ++j) {
				int in3 = in2-(j*(j+1)/2);
				
				if(findN2(in3))
					return true;
			}
		}
		return ret;
	}
	
	static boolean findN2(int in) {	
	//a = 1, b = 1, c= -2*in
		double ret1 = (-1 + (double)Math.sqrt(1-4*(-2*in)))/2;
		double ret2 = (-1 - (double)Math.sqrt(1-4*(-2*in)))/2;
		
		if(ret1%1 == 0)
			return true;
		else if(ret2%1 == 0)
			return true;
		return false;
	}
	
	static int findN(int in) {
		int i = 0;
		while((i*(i+1))/2<in) {
			i++;
		}
		return i-1;
	}
}
