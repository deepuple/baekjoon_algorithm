import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long ret = calc(b)-calc(a);
		if(ret<0)
			ret *= -1;
		System.out.println(ret);
		
		sc.close();
	}
	
	static long calc(long a) {
		long ret = 0;
		long in = a;
		
		if(a<0)
			in *= -1;
		
		int depth = 0;
		while(in>0) {
			long check = in % 10;
			if(check>4)
				ret += (check-1)*Math.pow(9, depth);
			else
				ret += check*Math.pow(9, depth);
			in = in/10;
			depth++;
		}
		
		if (a<0)
			ret *= -1;
		else
			ret--;
		
		return ret;
	}
}
