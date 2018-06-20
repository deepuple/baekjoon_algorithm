import java.util.*;

public class Main {

	static int[][] gugan;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for(int i = 0 ; i < cases ; ++i) {
			int stu_num = sc.nextInt();
			
			gugan = new int[stu_num][2];
			
			for(int j = 0 ; j < stu_num ; j++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				gugan[j][0] = corri(from);
				gugan[j][1] = corri(to);
			}
			
			System.out.println("#"+i+" "+check(gugan, stu_num));
		}
		sc.close();
	}
	
	static int check(int[][] in, int nums) {
		int max = 0;

		for(int i = 0 ; i<nums ; i++) {
			int cnt = 0;
			for(int j = 0 ; j<nums ; j++) {
				if(i != j) {
					if(in[j][0] >= in[i][0] && in[j][0] <= in[i][1])
						cnt++;
					else if(in[j][1] >= in[i][0] && in[j][1] <= in[i][1])
						cnt++;
				}
			}
			max = Math.max(max, cnt);
		}
		return max+1;
	}
	
	static int corri(int room_num) {
		return (room_num-1)/2;
	}
}
