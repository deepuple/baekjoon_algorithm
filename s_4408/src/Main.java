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
 			if(!v[i]) {
 	 			cnt++;
 				v[i] = true;//select
 				boolean[] check = new boolean[200];
 				
 				for(int k = in[i][0] ; k<=in[i][1] ; ++k) {
 					check[k] = true;
 				}
 				
				for(int j = i ; j<nums ; j++) {
					boolean isSp = true;
					for(int l = in[j][0] ; l <= in[j][1]; ++l) {
						if(check[l])
							isSp = false;
					}
					
					if(isSp) {
						v[j] = true; //delete same timeline;
						for(int k = in[j][0] ; k<=in[j][1] ; ++k) {
		 					check[k] = true;
		 				}
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
