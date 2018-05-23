import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) {
		int[] in = {1,2,3,0,4,0,5,7,0,0};
		clearZero(in, in.length);
		System.out.println(Arrays.toString(in));
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

}
