import java.util.*;

public class Main {
	
	static int[] live_idx;
	static int[] comb;
	static int rows, cols;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		rows = sc.nextInt();
		cols = sc.nextInt();
		
		int[][] map = new int[rows][cols];
		live_idx = new int[rows*cols]; 
		comb = new int[3];
		
		int cnt = 0;
		for(int i = 0 ; i < rows ; ++i) {
			for(int j = 0 ; j < cols ; ++j) {
				int in = sc.nextInt();
				map[i][j] = in;
				if(in==0) {
					live_idx[cnt] = ptToIdx(j, i);
					cnt++;
				}
			}
		}
		
		System.out.println(getMaxCell(map, cnt, 3));
		sc.close();
	}
	
	static int getMaxCell(int[][] m, int n, int r) {
		if(n == r) {
			for(int i = 0 ; i < r ; ++i) {
				comb[i] = i;
			}
			for(int j = 0 ; j < comb.length ; ++j) {
				int idx = live_idx[comb[j]];
				m[idxtoY(idx)][idxtoX(idx)] = 1;
			}
			int ret = count(m);
			for(int j = 0 ; j < comb.length ; ++j) {
				int idx = live_idx[comb[j]];
				m[idxtoY(idx)][idxtoX(idx)] = 0;
			}
			return ret;
		}
		if(r == 0) {
			for(int j = 0 ; j < comb.length ; ++j) {
				int idx = live_idx[comb[j]];
				m[idxtoY(idx)][idxtoX(idx)] = 1;
			}
			int ret = count(m);
			for(int j = 0 ; j < comb.length ; ++j) {
				int idx = live_idx[comb[j]];
				m[idxtoY(idx)][idxtoX(idx)] = 0;
			}
			return ret;
		}
		comb[r-1] = n-1;
		return Math.max(getMaxCell(m, n-1, r-1), getMaxCell(m, n-1, r));
	}
	
	static int ptToIdx(int x, int y) {
		return (y*cols)+x;
	}
	static int idxtoX(int idx) {
		return idx%cols;
	}
	static int idxtoY(int idx) {
		return idx/cols;
	}
	
	static int count(int[][] in) {
		int[][] tmp = new int[rows][cols];
		
		for(int i = 0 ; i < rows ; ++i)
			for(int j = 0 ; j < cols ; ++j)
				tmp[i][j] = in[i][j];
		
		Queue<Integer> q = new LinkedList<>();
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		for(int i = 0 ; i < rows ; ++i) {
			for(int j = 0 ; j < cols ; ++j) {
				if(tmp[i][j]==2) {
					q.offer(i);
					q.offer(j);
					while(!q.isEmpty()) {
						int y = q.poll();
						int x = q.poll();
						for(int k = 0; k <4 ; ++k) {
							int ny = y+dy[k];
							int nx = x+dx[k];
							if(nx>=0 && nx<cols && ny>=0 && ny<rows) {
								if(tmp[ny][nx]==0) {
									q.offer(ny);
									q.offer(nx);
									tmp[ny][nx]=2;
								}	
							}
						}
					}
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0 ; i < rows ; ++i)
			for(int j = 0 ; j < cols ; ++j)
				if(tmp[i][j]==0) 
					cnt++;
		
		return cnt;
	}
}
