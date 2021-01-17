import java.util.*;

public class Main {
	static int[][] in;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		in = new int[cases][3];
		for(int i = 0; i< cases ; ++i ) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			in[i][0] = w;
			in[i][1] = h;
		}
		
		for(int i = 0 ; i < cases ; i++) {
			for(int j = 0; j<cases ; ++j) {
				if(in[i][0]<in[j][0] && in[i][1]<in[j][1])
					in[i][2]++;
			}
			in[i][2]++;
		}
		

		for(int i = 0 ; i < cases ; i++) {
			System.out.print(in[i][2]+" ");
		}
		
		sc.close();
	}
}
