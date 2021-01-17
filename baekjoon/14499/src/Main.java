import java.util.*;

class Main{
	static int[][] map;
	static int n, m, x, y;
	static int[] dice = {0,0,0,0,0,0,0};

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

		int map_v = map[x][y];
		change_dice(dice,cmd);
		if(map_v!=0){
			dice[6] = map_v;
			map[x][y] = 0;
		}
		else
			map[x][y] = dice[6];

		return dice[1];
	}
	static void change_dice(int[] dice, int cmd){
	    int[] temp = dice.clone();

	    if(cmd==1){
            dice[1] = temp[4];
            dice[3] = temp[1];
            dice[4] = temp[6];
            dice[6] = temp[3];
        }else if(cmd==2){
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[4] = temp[1];
            dice[6] = temp[4];
        }else if(cmd==3){
            dice[1] = temp[5];
            dice[2] = temp[1];
            dice[5] = temp[6];
            dice[6] = temp[2];
        }else{
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[5] = temp[1];
            dice[6] = temp[5];
        }
    }
}

