import java.util.*;

public class Main {

	static int[][] map;
	static int cols=0, rows=0;
	static int[] comb;
	static int cnt;
	static int[] st;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		cols = sc.nextInt();
		int sticks = sc.nextInt();
		rows = sc.nextInt();
		
		map = new int[rows+1][cols+1];
		
		if(sticks==0) {
			System.out.println(0);
			return;
		}
		
		for(int i = 0 ; i<sticks; ++i) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r][c] = 1; //사다리 있는 칸;
		}		
		//빈칸을 인덱스 형태로 저장함 
		cnt = 0;
		for(int i = 1 ; i <= rows ; ++i) {
			for(int j = 1 ; j < cols ;++j) {
				if(map[i][j]==0)
					cnt++;
			}
		}
		
		st = new int[cnt];
		int idx = 0;
		for(int i = 1 ; i <= rows ; ++i) {
			for(int j = 1 ; j < cols ; ++j) {
				if(map[i][j]==0) {
					st[idx] = ptToIdx(i,j);
					idx++;
				}
			}
		}
		
		for(int i = 1 ; i <= cnt; ++i) {
			comb = new int[i];
			if(combination(map, cnt, i)) {
				System.out.println(i);
				return;
			}
			if(i==3) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println("-1");
	}
	
	static boolean combination(int[][] map, int n, int r) {
		if(n==r) {
			for(int i = 0 ; i<r ;++i) {
				comb[i] = i;
			}
			return check(map);
		}
		if(r==0) {
			return check(map);
		}
		comb[r-1] = n-1;
		if(combination(map, n-1, r-1))
			return true;
		if(combination(map, n-1, r))
			return true;
		
		return false;
	}
	
	static boolean check(int[][] map) {
		boolean ret = true;
		
		//cp
		int[][] tmp = new int[rows+1][cols+1];
		for(int i = 1 ; i <= rows ; ++i) {
			for(int j = 1 ; j <= cols ; ++j) {
				tmp[i][j] = map[i][j];
			}
		}
		
		//사다리를 놓고...
		for(int i = 0; i<comb.length;++i) {
			int c = idxToPtC(st[comb[i]]);
			int r = idxToPtR(st[comb[i]]);
			if(c==1) {
				if(tmp[r][c+1]!=1) {
					tmp[r][c] = 1;
				}
			}else {
				if(tmp[r][c+1]!=1 && tmp[r][c-1]!=1) {
					tmp[r][c] = 1;
				}
			}
		}
		
		//체크한다
		/*
		for(int i = 1 ; i <= rows ; ++i) {
			System.out.println(Arrays.toString(tmp[i]));
		}
		System.out.println("-------");
		*/
		int num = 0;
		for(int i = 1 ; i <= cols ; ++i) {
			int r = 1;
			num = i;
			while(r<=rows) {
				if(num == 1) {
					if(tmp[r][num]==1)
						num++;
				}else if(num==cols) {
					if(tmp[r][num-1]==1)
						num--;
				}else {
					if(tmp[r][num]==1)
						num++;
					else if(tmp[r][num-1]==1)
						num--;
				}
				r++;
			}
			if(num!=i)
				return false;
			
		}
		
		return ret;
	}
	
	static int ptToIdx(int r, int c) {
		return r*cols+c;
	}
	static int idxToPtC(int idx) {
		return idx%cols;
	}
	static int idxToPtR(int idx) {
		return idx/cols;
	}
}
