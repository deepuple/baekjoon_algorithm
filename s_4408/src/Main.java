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
		int max = 0; 
		int[] cnt= new int[200]; 
		for(int i = 0 ; i<nums ; i++) { 
			for(int j = in[i][0] ; j<=in[i][1];j++)
				cnt[j]++;
		} 

		for (int i = 0 ;i<200;++i){
			if(max<cnt[i])
				max = cnt[i];
		}
		return max; 
 	} 

 	static int corri(int room_num) { 
 		return (room_num-1)/2; 
 	} 
}
