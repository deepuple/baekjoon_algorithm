import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long diff = b-a;
		if(a<0&&b>0)
			diff--;
		
		long ret = calc(diff);
		System.out.println(ret);
	}
	static long calc(long in) {
		long ret = 0;
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
		return ret;
	}
}
