import java.util.*;

public class Main {

	static char[][] map;
	public static void main(String[] args) {
		
		int min = 64;
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		sc.nextLine();
		
		map = new char[h][w];
		for(int i = 0; i < h ; ++i) {
			char[] in = sc.nextLine().toCharArray();
			for(int j = 0 ; j < w; ++j) {
				map[i][j] = in[j];
			}
		}
		
		for(int i = 0; i <= h-8 ; ++i) {
			for(int j = 0 ; j <= w-8; ++j) {
				min = Math.min(check(i,j), min);
			}
		}
		System.out.println(min);
		sc.close();
	}
	
	static int check(int y, int x) {
		char[] checkA = {'B','W','B','W','B','W','B','W',
				'W','B','W','B','W','B','W','B',
				'B','W','B','W','B','W','B','W',
				'W','B','W','B','W','B','W','B',
				'B','W','B','W','B','W','B','W',
				'W','B','W','B','W','B','W','B',
				'B','W','B','W','B','W','B','W',
				'W','B','W','B','W','B','W','B'};
		
		char[] checkB = {'W','B','W','B','W','B','W','B',
				'B','W','B','W','B','W','B','W',
				'W','B','W','B','W','B','W','B',
				'B','W','B','W','B','W','B','W',
				'W','B','W','B','W','B','W','B',
				'B','W','B','W','B','W','B','W',
				'W','B','W','B','W','B','W','B',
				'B','W','B','W','B','W','B','W'};
		
		int cnt = 0;
		int ret = 0;
		for(int i = y ; i< 8+y ;++i) {
			for(int j = x ; j < 8+x ; ++j) {
				if(map[i][j]!=checkA[(i-y)*8+(j-x)])
					cnt++;
			}
		}
		ret = cnt;
		cnt = 0;
		for(int i = y ; i< 8+y ;++i) {
			for(int j = x ; j < 8+x ; ++j) {
				if(map[i][j]!=checkB[(i-y)*8+(j-x)])
					cnt++;
			}
		}
		return Math.min(ret, cnt);
	}
}
