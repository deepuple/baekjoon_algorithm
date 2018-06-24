import java.util.*;
public class Main {
	
	static int max;
	static int nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<4 ; ++i) {
			int off = sc.nextInt();
			nums -= off;
			int on = sc.nextInt();
			nums += on;
			
			max =  Math.max(nums, max);
		}
		System.out.println(max);
		sc.close();
	}

}
