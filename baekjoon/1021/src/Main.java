import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        Deque<Integer> dq = new LinkedList<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        int num = Integer.parseInt(init[0]);
        int cases = Integer.parseInt(init[1]);

        for(int i=1;i<=num;++i){
            dq.add(i);
        }

        String[] in = br.readLine().split(" ");

        int cnt = 0;
        for(int j=0;j<cases;++j){
            int n = Integer.parseInt(in[j]);
            int left = getLeft(dq, n);
            int right = getRight(dq, n);

            if (right < left) {
                while (dq.peekFirst()!=n) {
                    dq.addFirst(dq.pollLast());
                    cnt++;
                }
                dq.pollFirst();
            } else {
                while (dq.peekFirst()!=n) {
                    dq.addLast(dq.pollFirst());
                    cnt++;
                }
                dq.pollFirst();
            }
        }
        System.out.println(cnt);
    }

    private static int getRight(Deque<Integer> li, int index){
        Iterator<Integer> itr = li.descendingIterator();
        int count = 0;
        while(itr.hasNext()){
            if(index == itr.next()){
                break;
            }else{
                count++;
            }
        }
        return count;
    }

    private static int getLeft(Deque<Integer> li, int index){
        Iterator<Integer> itr = li.iterator();
        int count = 0;
        while(itr.hasNext()){
            if(index == itr.next()){
                break;
            }else{
                count++;
            }
        }
        return count;
    }
}
