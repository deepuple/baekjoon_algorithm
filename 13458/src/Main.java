import java.util.*;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int c = sc.nextInt();
	    int[] num = new int[c];
	    long ret=0;
	    for(int i = 0 ; i < c ; ++i){
	        num[i] = sc.nextInt();
        }
        int pri = sc.nextInt();
	    int sub = sc.nextInt();

	    for(int j = 0 ; j < c ; ++j){
	        int tmp = num[j]-pri;
	        if(tmp<=0)
	            continue;
	        ret += tmp/sub;
	        if(tmp%sub!=0)
	            ret++;
        }

        ret +=c;

        System.out.println(ret);

    }
}
