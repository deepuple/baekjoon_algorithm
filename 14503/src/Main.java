import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n][m];
		
		int y = sc.nextInt();
		int x = sc.nextInt();
		int dir = sc.nextInt();
		
		for(int i = 0 ; i < n ; ++i)
			for(int j =0 ; j < m; ++j)
				map[i][j] = sc.nextInt();
		
		int ans = 0;
		
		boolean flag = true;
		while(flag) {
			if(map[y][x]==0) {
				ans++;
				map[y][x] = 2;
				//printMap(map);
			}
			
			//dir : 0 : 북쪽, 1:동쪽, 2: 남쪽, 3: 서쪽;
			int[] dx = {0,1,0,-1}; 
			int[] dy = {-1,0,1,0};
			
			for(int i = 0 ; i < 5 ; ++i) {			
				if(i == 4) {
					dir = (dir+2)%4;//반대방
					
					int nx = x+dx[dir];
					int ny = y+dy[dir];
					
					if(map[ny][nx]==1)
						flag = false;
					else {
						dir = (dir+2)%4;//방향 유지
						y = ny;
						x = nx;
					}	
				}else {
					dir = (dir+3)%4; //(0+3)->3, (1+3)->0, (2+3)->1, (3+3)->2;
					
					int nx = x+dx[dir];
					int ny = y+dy[dir];
					
					if(map[ny][nx]==0) {
						x = nx;
						y = ny;
						i = 5;
					}
				}
			}
		}
		int cnt = count(map, n, m);
		System.out.println(cnt);
	}
	
	static void printMap(int[][] m) {
		for(int i = 0 ; i < m.length ; ++i)
				System.out.println(Arrays.toString(m[i]));
		System.out.println();
	}
	static int count(int[][] map, int rows, int cols) {
		int cnt = 0;
		for(int i = 0 ; i < rows ; ++i)
			for(int j =0 ; j < cols; ++j)
				if(map[i][j] == 2)
					cnt++;
		
		return cnt;
	}
	
}
