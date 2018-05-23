import java.util.*;

public class Main {
	static boolean[][] map;
	static boolean[][] v;
	static char[] cmd = new char[10001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new boolean[n][n];
		v = new boolean[n][n];
		int n_ap = sc.nextInt();
		for(int i = 0; i<n_ap ; ++i) {
			int y = sc.nextInt()-1;
			int x = sc.nextInt()-1;
			map[y][x] = true;
		}
		int n_cmd = sc.nextInt();
		for(int i = 0; i<n_cmd; ++i) {
			int time = sc.nextInt();
			char[] c = sc.next().toCharArray();
			cmd[time] = c[0];
		}
		
		System.out.println(simul(n));
		sc.close();
	}
	
	static int simul(int n) {
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};//우, 하, 좌, 상 
		
		int toward = 0;
		int h_x=0, h_y=0;
		int ret = 0;
		
		Queue<Integer> q = new LinkedList();

		q.offer(h_y);//지나온 길 저장
		q.offer(h_x);
		v[h_y][h_x] = true;
		
		while(true) {
			ret = ret+1; //1초 지남;
			
			h_x = h_x+dx[toward];//이동
			h_y = h_y+dy[toward];
			
			if(h_x == n || h_y == n || h_x<0 || h_y<0)//벽을 지난경우 
				break;
			
			if(v[h_y][h_x])//원을 이룬경우 
				break;

			q.offer(h_y);//지나온 길 저장
			q.offer(h_x);
			v[h_y][h_x] = true;
			
			if(!map[h_y][h_x]) { //사과가 없으면 방문 기록 삭제
				int vy = q.poll();
				int vx = q.poll();
				v[vy][vx] = false;
			}else { //사과가 있다면, 먹은걸 지운다 
				map[h_y][h_x] = false;
			}
			
			if(cmd[ret] == 'D') {
				toward += 1;
				if(toward == 4)
					toward = 0;
			}else if(cmd[ret] == 'L') {
				toward -= 1;
				if(toward == -1)
					toward = 3;
			}
		}	
		return ret;
	}
}
