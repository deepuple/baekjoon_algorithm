import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] v = new boolean[4];
		v[1] = true;
		int manip = sc.nextInt();
		for(int i = 0 ; i< manip; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			boolean tmp = v[from];
			v[from] = v[to];
			v[to] = tmp;
		}
		
		for(int i = 1 ; i <= 3 ; ++i)
			if(v[i])
				System.out.println(i);
		
		sc.close();
	}

}
