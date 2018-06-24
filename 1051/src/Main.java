import java.util.Scanner;

public class Main {

	static char[][] map;
	public static void main(String[] args) {

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
		int m = Math.min(h, w);
		for(int k = m-1 ; k >= 0 ; --k) {
			for(int i = 0; i < h-k ; ++i) {
				for(int j = 0 ; j < w-k; ++j) {
					if(check(i,j,k)) {
						System.out.println((k+1)*(k+1));
						return;
					}
				}
			}
		}
		
		sc.close();
	}
	
	static boolean check(int y, int x, int offset) {
		return 	map[y][x]==map[y+offset][x]&&map[y][x]==map[y][x+offset]&&map[y][x]==map[y+offset][x+offset];
	}
}
