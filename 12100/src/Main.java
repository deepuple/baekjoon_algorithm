import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		
		for(int i = 0; i<n ; i++)
			for(int j = 0; j<n ; j++)
				map[i][j] = sc.nextInt();
		
		System.out.println(max(map,n,0));
		sc.close();
	}
	
	static int max(int[][] in, int n, int depth) {
		int ret = 0;
		
		if(depth==5) {
			return getMaxBlock(in, n);
		}
		for(int i = 0;i<4;++i) {
			ret = Math.max(ret, max(manipulate(in, n, i), n, depth+1));
		}
		return ret;
	}
	
	static int[][] manipulate(int[][] in, int n, int cmd) {
		int[][] ret = new int[n][n];
		int[] tmp = new int[n];
		
		for(int i = 0 ; i < n ; ++i) { //다섯개 줄에 대해..
			if(cmd==0) {//왼쪽 밀
				for(int j = 0 ; j < n ; ++j) {
					tmp[j] = in[i][j];	
				}
				for(int k = 0 ; k < n-1 ; ++k) {
					clearZero(tmp,n);
					if(tmp[k]==tmp[k+1]) {
						tmp[k] *= 2;
						tmp[k+1] = 0;
					}
				}
				for(int l = 0 ; l < n ; ++l) {
					ret[i][l] = tmp[l];	
				}
				
			}
			else if(cmd==1) {//위 밀
				for(int j = 0 ; j < n ; ++j) {
					tmp[j] = in[j][i];	
				}
				for(int k = 0 ; k < n-1 ; ++k) {
					clearZero(tmp,n);
					if(tmp[k]==tmp[k+1]) {
						tmp[k] *= 2;
						tmp[k+1] = 0;
					}
				}
				for(int l = 0 ; l < n ; ++l) {
					ret[l][i] = tmp[l];	
				}
			}
			else if(cmd==2) {//오 밀
				for(int j = 0 ; j < n ; ++j) {
					tmp[j] = in[i][n-1-j];	
				}
				for(int k = 0 ; k < n-1 ; ++k) {
					clearZero(tmp,n);
					if(tmp[k]==tmp[k+1]) {
						tmp[k] *= 2;
						tmp[k+1] = 0;
					}
				}
				for(int l = 0 ; l < n ; ++l) {
					ret[i][n-1-l] = tmp[l];	
				}
			}
			else if(cmd==3) {//아 밀
				for(int j = 0 ; j < n ; ++j) {
					tmp[j] = in[n-1-j][i];	
				}
				for(int k = 0 ; k < n-1 ; ++k) {
					clearZero(tmp,n);
					if(tmp[k]==tmp[k+1]) {
						tmp[k] *= 2;
						tmp[k+1] = 0;
					}
				}
				for(int l = 0 ; l < n ; ++l) {
					ret[n-1-l][i] = tmp[l];	
				}
			}
		}
		return ret;
	}
	
	static void clearZero(int[] in, int n) {
		int cnt = 0;
		for(int i = 0 ; i<n; ++i) {
			if(in[i]==0)
				cnt++;
			else {
				if(cnt!=0) {
					in[i-cnt] = in[i];
				}
			}
		}
		for(int j = n-cnt ; j<n ; ++j) {
			in[j] = 0;
		}
	}
	
	static int getMaxBlock(int[][] in, int n) {
		int ret = 0;
		
		for(int i = 0; i<n ; i++)
			for(int j = 0; j<n ; j++)
				ret = Math.max(ret, in[i][j]);
		
		return ret;
		
	}
}
