import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		
		int[][] map = new int[n][n];
		
		for(int i = 0 ; i<n ; ++i) {
			for(int j = 0 ; j<n; ++j) {
				map[i][j] = sc.nextInt();
			}
		}
		int cnt = 0;
		
		for(int i = 0 ; i<n ; ++i) {
			if(check(map[i], n, l))
				cnt++;
		}
		
		for(int i = 0 ; i<n ; ++i) {
			int[] tmp = new int[n];
			for(int j = 0 ; j<n; ++j) {
				tmp[j] = map[j][i]; 
			}
			if(check(tmp, n, l))
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static boolean check(int[] line, int width, int l) {
		int curVal = 0;
		int[] dpPoint = new int[width];
		int dpIdx = 0;
		
		for(int i = 0 ; i < width ; ++i) {
			int val = line[i];
			if(i == 0)
				curVal = val;
			else {
				if(curVal == val-1) {//up
					for(int j = 1 ; j <= l ; ++j) {
						if(i-j < 0)
							return false;
						else {
							if(line[i-j]!=curVal)
								return false;
						}
					}
					curVal = val;
					dpPoint[dpIdx] = i;
					dpIdx++;
				}
				else if(curVal == val+1) {//down
					for(int j = 1 ; j < l ; ++j) {
						if(i+j >= width)
							return false;
						else {
							if(line[i+j]!=val)
								return false;
						}
					}
					curVal = val;
					dpPoint[dpIdx] = i*-1;
					dpIdx++;
				}
				else if(curVal == val) {
					//do nothing.
				}
				else
					return false;
			}	
		}
		
		int tmp = 0;
		for(int i = 0 ; i<width;++i) {
			if(dpPoint[i]<0)//아래 
				tmp = dpPoint[i]*-1; 
			else if(dpPoint[i]>0 && tmp!=0) {//위 
				if(Math.abs(tmp-dpPoint[i])<2*l)
					return false;
				tmp = 0;
			}
		}
		
		return true;
	}
	
}
