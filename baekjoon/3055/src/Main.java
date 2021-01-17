import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		
		sc.nextLine();
		
		char[][] map = new char[h][w];
		for(int i = 0; i < h ; ++i) {
			char[] in = sc.nextLine().toCharArray();
			for(int j = 0 ; j < w; ++j) {
				map[i][j] = in[j];
			}
		}
		
		check(map, h, w);
		sc.close();
	}
	
	static void check(char[][] map, int h, int w) {
		Queue<Integer> mq = new LinkedList<>();
		
		for(int i = 0; i < h ; ++i) {
			for(int j = 0 ; j < w; ++j) {
				if(map[i][j] == 'S') {
					mq.offer(i);
					mq.offer(j);
					map[i][j] = 'V';
				}
			}
		}
		int cnt = 0;
		while(!mq.isEmpty()) {
			cnt++;
			
			//water
			for(int x = 0; x < h ; ++x) {
				for(int y = 0 ; y < w; ++y) {
					if(map[x][y] == '*') {
						int[] dx = {1, -1, 0, 0};
						int[] dy = {0, 0, 1, -1};
						for(int z = 0 ; z < 4 ; ++z) {
							int nx = x + dx[z];
							int ny = y + dy[z];
							if(nx>=0 && nx<h && ny >=0 && ny<w)
								if(map[nx][ny]=='.')
									map[nx][ny] = 'W';
						}
					}
				}
			}
			for(int x = 0; x < h ; ++x) {
				for(int y = 0 ; y < w; ++y) {
					if(map[x][y] == 'W') {
						map[x][y] = '*';
					}
				}
			}
			
			int sz = mq.size()/2;
			for(int i = 0 ; i<sz ; i++) {
				//poll
				int x = mq.poll();
				int y = mq.poll();
				
				int[] dx = {1, -1, 0, 0};
				int[] dy = {0, 0, 1, -1};
				
				for(int z = 0 ; z < 4 ; ++z) {
					int nx = x + dx[z];
					int ny = y + dy[z];
					if(nx>=0 && nx<h && ny >=0 && ny<w) {
						if(map[nx][ny]=='D') {
							System.out.println(cnt);
							return;
						}
						else if(map[nx][ny]=='.') {
							mq.offer(nx);
							mq.offer(ny);
							map[nx][ny]='V';
						}
					}
					
				}
			}
		}
		System.out.println("KAKTUS");
	}
}
