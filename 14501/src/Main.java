import java.util.*;

class Main{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] cons = new int[n][2];

		for(int i =0 ; i< n ; ++i){
			cons[i][0] = sc.nextInt();
			cons[i][1] = sc.nextInt();
		}

		System.out.println(cal(cons,n,0));
	}

	static int cal(int[][] in, int length, int depth){
		int ret = 0;

		if(depth>=length)
			return ret;

		for(int i = depth ; i < length ; ++ i){
			if(depth +  in[i][0]< length){
				int cal  = in[i][1]+cal(in, length, depth+in[i][0]);
				ret = Math.max(ret, cal);
			}
		}

		return ret;
	}
}
