import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int teams = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int cnt = 0;
		while(a!=b) {
			a = (a+1)/2;
			b = (b+1)/2;
			cnt++;
		}
		System.out.println(cnt);
		
		sc.close();
	}
}
