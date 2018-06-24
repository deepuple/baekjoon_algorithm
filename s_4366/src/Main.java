import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String in = sc.nextLine();
			int in_a = Integer.parseInt(in, 2);

			String out = sc.nextLine();
			
			for(int i = 0 ; i< in.length(); ++i) {
				int tmp = in_a ^ (int)Math.pow(2, i);
				
				if(check(out, toTri(tmp)))
					System.out.println("#"+test_case+" "+tmp);
			}
		}
		sc.close();
	}
	
	static boolean check(String a, String b) {
		
		if(a.length()!=b.length())
			return false;
		
		char[] i = a.toCharArray();
		char[] j = b.toCharArray();
		
		int cnt = 0;
		for(int k = 0 ; k<a.length(); ++k) {
			if(i[k]!=j[k])
				cnt++;
		}
		
		if(cnt!=1)
			return false;
		else
			return true;
	}
	
	static String toTri(int in) {
		String ret = "";
		
		if(in < 3)
			return ret+in;
		
		while(3<=in) {
			int b = in%3;			
			ret = b + ret;
			in = in/3;
		}
		
		return in + ret;
	}
}
