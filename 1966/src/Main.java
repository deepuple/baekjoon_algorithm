import java.util.*;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int cases = sc.nextInt();

	    Queue<Integer> pr = new LinkedList<Integer>();
	    LinkedList<Integer> max = new LinkedList<Integer>();

	    for(int i = 0 ; i< cases; ++i){
	        sc.nextLine();
	        int num = sc.nextInt();
	        int target = sc.nextInt();
	        sc.nextLine();
	        for(int j = 0; j<num; ++j){
	            int pri = sc.nextInt();
	            //if(!max.contains(pri))
                max.add(pri);
	            if(j==target)
	                pri += 200;
	            pr.offer(pri);
            }
            Collections.sort(max, Collections.reverseOrder());

            int ret = 1;

	        while(!pr.isEmpty()){
	            int cur = pr.poll();

	            if(cur>=201){
	                cur -=200;
                    if(cur!=max.get(0)){
                        cur +=200;
                        pr.offer(cur);
                    }else{
                        System.out.println(ret);
                        pr.clear();
                        max.clear();
                        break;
                    }
                }else{
                    if(cur!=max.get(0)) {
                        pr.offer(cur);
                    }else {
                        max.remove(0);
                        ret++;
                    }
                }
            }
        }
    }
}
