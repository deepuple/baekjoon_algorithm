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
				
				if(from>to){
					int tmp = from;
					from = to;
					to = tmp;
				}
				
				gugan[j][0] = corri(from);
				gugan[j][1] = corri(to);
			}
			
			System.out.println("#"+(i+1)+" "+check(gugan, stu_num));
		}
		sc.close();
	}
	
	static int check(int[][] in, int nums) {
		int cnt = 0;
		boolean[] v= new boolean[nums];
		
 		for(int i = 0 ; i<nums ; i++) {
 			cnt++;
 			if(!v[i]) {
 				v[i] = true;
				for(int j = i ; j<nums ; j++) {
					if(in[i][0] >= in[j][0] && in[i][0] <= in[j][1]) {
					}else if(in[i][1] >= in[j][0] && in[i][1] <= in[j][1]) {
					}else if(in[i][0] <= in[j][0] && in[i][1] >= in[j][1]) {
					}else {
						v[j] = true; //delete same timeline;
					}	
				}
 			}
			if(complete(v))
				return cnt;
		}
 		return cnt;
	}
	
	static boolean complete(boolean[] in) {
		boolean ret = true;
		for(int k = 0 ; k<in.length ; k++) {
			if(!in[k])
				return false;
		}
		return ret;
	}
	
	static int corri(int room_num) {
		return (room_num-1)/2;
	}
}
