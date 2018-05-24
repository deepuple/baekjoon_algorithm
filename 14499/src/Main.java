import java.util.*;

class Main{
	static int[][] map;
	static int n, m, x, y;
	static int[][] dice = {{0,0,0,0,0,0},
			{0,6,2,3,5,4},
			{0,5,6,3,1,4},
			{0,4,2,6,5,1},
			{0,3,2,1,5,6},
			{0,2,1,3,6,4},
			{0,1,5,3,2,4}};
	static int base = 6;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		x = sc.nextInt();
		y = sc.nextInt();
		int n_cmd = sc.nextInt();

		for(int i = 0 ; i<n ; ++i)
			for(int j = 0 ; j<m ; ++j)
				map[i][j] = sc.nextInt();

		for(int k = 0 ; k < n_cmd ; ++k){
			int ret = run_cmd(sc.nextInt());
			if(ret!=99)
				System.out.println(ret);
		}

	}

	static int run_cmd(int cmd){
		int[] dy = {0,1,-1,0,0};
		int[] dx = {0,0,0,-1,1};

		int nx = x+dx[cmd];
		int ny = y+dy[cmd];

		if(nx < 0 || nx > n-1 || ny <0 || ny > m-1)
			return 99;

		x = nx;
		y = ny;

		if(cmd==1)
			cmd = 3;
		else if(cmd==2)
			cmd = 5;
		else if(cmd==3)
			cmd = 2;
		else
			cmd = 4;

		int map_v = map[x][y];
		base = dice[base][cmd];
		if(map_v!=0){
			dice[base][0] = map_v;
			map[x][y] = 0;
		}
		else
			map[x][y] = dice[base][0];

		int top = dice[base][1];
		return dice[top][0];
	}
}
