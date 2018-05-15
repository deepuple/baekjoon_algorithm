import java.util.*;

public class Main {

    static boolean[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new boolean[101][101];

        int d_num = sc.nextInt();

        for(int i = 0 ; i < d_num ; ++ i ){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            int[] cmd = makeCmd(d, g);
            mark(x, y, cmd);
        }

        System.out.print(check());
    }

    static int check(){
        int cnt = 0;
        for(int i = 0 ; i < 100 ; ++ i){
            for(int j = 0 ; j < 100 ; ++j){
                if(map[i][j]){
                    if(map[i+1][j] && map[i+1][j+1] && map[i][j+1])
                        cnt++;
                }
            }
        }
        return cnt;
    }

    static int[] makeCmd(int direction, int gen){
        int[] ret = new int[(int)Math.pow(2,gen)];
        ret[0] = direction;

        for(int i = 1 ; i <= gen; ++i){
            Stack<Integer> s = new Stack<>();
            for(int j = 0 ; j < (int)Math.pow(2,(i-1)); ++j){ //1:1, 2:2, 3:4
                s.push(ret[j]);
            }
            int sz = s.size();
            for(int k = 0 ; k < sz ; ++k){ //1:1, 2:2, 3:4
                ret[sz+k] = tran_dir(s.pop());
            }
        }
        return ret;
    }

    static int tran_dir(int in){
        if(in == 3)
            return 0;
        else
            return in+1;
    }

    static void mark(int x, int y, int[] cmd){
        int a=x, b=y;
        map[a][b] = true;
        for(int i = 0 ; i < cmd.length ; ++i){
            a = moveX(a, cmd[i]);
            b = moveY(b, cmd[i]);
            map[a][b] = true;
        }
    }

    static int moveX(int x, int cmd){
        if(cmd == 0)
            return x+1;
        else if(cmd == 2)
            return x-1;
        else
            return x+0;
    }

    static int moveY(int y, int cmd){
        if(cmd == 1)
            return y-1;
        else if(cmd == 3)
            return y+1;
        else
            return y+0;
    }
}
