import java.util.*;

public class Main {

    static boolean[][] map;
    static int height, width;
    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        boolean[][] map_ori = new boolean[height][width];
        map = new boolean[height][width];
        for(int i = 0; i < height ; ++i){
            char[] in = sc.next().toCharArray();
            for (int j = 0 ; j< width; ++j){
                map_ori[i][j] = Integer.parseInt(in[j]+"")==0 ? false : true;
            }
        }

        int ret = -1;
        for(int y = 0; y < height ; ++y){
            for (int x = 0 ; x < width; ++x){
                if(map_ori[y][x] && isVaildBlock(x,y, map_ori)){

                    //set map
                    for(int a = 0; a < height ; ++a)
                        for (int b = 0 ; b < width; ++b)
                            map[a][b] = map_ori[a][b];

                    map[y][x] = false;
                    int result = BFS();
                    if(result != -1) {
                        if (ret != -1)
                            ret = Math.min(ret, result);
                        else
                            ret = result;
                    }

                    map[y][x] = true;
                }
            }
        }
        System.out.println(ret);
    }
    static int BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        map[0][0] = true;

        int depth = 0;

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0 ; i <sz ; ++i){
                int idx = q.poll();
                if(idx == (height*width-1))
                    return depth+1;

                int[] dx = {-1,0,1,0};
                int[] dy = {0,-1,0,1};
                for (int j = 0 ; j < 4 ;++j){
                    int nx = idxToX(idx)+dx[j];
                    int ny = idxToY(idx)+dy[j];
                    if(nx >=0 && nx < width && ny >= 0 && ny < height && !map[ny][nx]) { //is road.
                        q.offer(ptToIdx(nx,ny));
                        map[ny][nx] = true;
                    }

                }
            }
            depth++;
        }

        return -1;
    }

    static int idxToX(int idx){
        return idx%width;
    }
    static int idxToY(int idx){
        return idx/width;
    }
    static int ptToIdx(int x, int y){
        return y*width+x;
    }

    static boolean isVaildBlock(int x, int y, boolean[][] m){
        int cnt=0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        for (int i = 0 ; i < 4 ;++i){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >=0 && nx < width && ny >= 0 && ny < height && !m[ny][nx]) //is road.
                cnt++;
        }

        return cnt>=2;
    }
}
