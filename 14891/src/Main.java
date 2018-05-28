import java.util.*;
public class Main {

    static int[] in;

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    in = new int[4+1];
	    for(int i = 1; i<=4 ;++i)
            in[i] = charToint(sc.nextLine().toCharArray());

	    int n_cmd = sc.nextInt();
        for(int j = 0 ; j < n_cmd ; ++j){
            int idx = sc.nextInt();
            int dir = sc.nextInt();
            runCmd(idx, dir);
        }
        int ret = 0;
        for(int i = 1; i<=4 ;++i) {
            if ((in[i] & 128) == 128)
                ret += Math.pow(2,i-1);
        }
	    System.out.println(ret);
    }
    static void runCmd(int idx, int  dir){
        boolean[] v = new boolean[4+1];
        Queue<Integer> iq = new LinkedList<>();
        Queue<Integer> vq = new LinkedList<>();
        Queue<Integer> dq = new LinkedList<>();

        iq.offer(idx);
        vq.offer(in[idx]);
        dq.offer(dir);
        v[idx] = true;
        click(idx, dir);
        while(!iq.isEmpty()){
            int n_idx = iq.poll();
            int n_val = vq.poll();
            int n_dir = dq.poll();
            if(n_idx-1>0){
                if((!v[n_idx-1])&&(checkMove(in[n_idx-1], n_val))){
                    iq.offer(n_idx-1);
                    vq.offer(in[n_idx-1]);
                    dq.offer(swapDir(n_dir));
                    v[n_idx-1] = true;
                    click(n_idx-1, swapDir(n_dir));
                }
            }
            if(n_idx+1<5){
                if((!v[n_idx+1])&&(checkMove(n_val, in[n_idx+1]))){
                    iq.offer(n_idx+1);
                    vq.offer(in[n_idx+1]);
                    dq.offer(swapDir(n_dir));
                    v[n_idx+1] = true;
                    click(n_idx+1, swapDir(n_dir));
                }
            }
        }
    }
    static void click(int idx, int cmd){
        if(cmd==1){
            if ((in[idx] & 1 ) == 1) {
                in[idx] = in[idx] >> 1;
                in[idx] = in[idx] | 128;
            }else
                in[idx] = in[idx] >> 1;
        }else {
            if ((in[idx] & 128) == 128) {
                in[idx] = in[idx] & 127;
                in[idx] = in[idx] << 1;
                in[idx] = in[idx] | 1;
            }else
                in[idx] = in[idx] << 1;
        }
    }
    static boolean checkMove(int right, int left){
        int r = right&32;
        int l = left&2;

        if((r==32&&l==2)||(r==0&&l==0))
            return false;

        return true;
    }
    static int swapDir(int in){
        if(in == 1)
            return -1;
        else
            return 1;
    }
    static int charToint(char[] in){
        int ret=0;
        for(int i = 0; i < 8;++i){
            if(in[i]=='1')
                ret = ret|1;

            if(i<7)
                ret = ret<<1;
        }
        return ret;
    }
}
