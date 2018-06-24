import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int in = sc.nextInt();
		
		while(in>0) {
			if(in%2==1)
				cnt++;
			in = in/2;
		}
		System.out.println(cnt);
		sc.close();
	}
}
