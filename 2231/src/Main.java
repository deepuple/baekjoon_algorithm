import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		System.out.println(calc(in));
		sc.close();
	}
	
	static int calc(int in) {
		if(in < 10) {
			if(in%2==0)
				return in/2;
			else
				return 0;
		}else {
			int i = 2;
			while(Math.pow(10, i)<in) {
				i++;
			}
			i--;
			
			int start = 0;
			for(int j = 0; j<i ;++j) {
				start += 9*Math.pow(10, j);
			}
			
			int ret = 0;
			for(int j = start ; j < in ; ++j) {
				if(in==j+sum(j))
					return j;
			}
			return ret;
		}
	}
	
	static int sum(int in) {
		if(in<10)
			return in;
		else
			return in%10 + sum(in/10);
	}
}
