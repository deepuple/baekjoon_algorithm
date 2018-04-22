import java.util.*;

public class Main {

    static boolean[][] map;
    static int size;
    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0 ; i < cases ; ++i){
            size = sc.nextInt();
            map = new boolean[size][size];

            int currIdx = (sc.nextInt()*size)+sc.nextInt();
            int targetIdx = (sc.nextInt()*size)+sc.nextInt();

            System.out.println(BFS(currIdx,targetIdx));
        }
    }
    static int BFS(int curr, int target){
        Queue<Integer> q = new LinkedList<>();

        int[] dx = {-1,-2,-1,-2,1,2,1,2};
        int[] dy = {-2,-1,2,1,-2,-1,2,1};

        q.offer(curr);
        map[idxToX(curr)][idxToY(curr)] = true;

        int ret = 0;

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0 ; i < sz ; ++i){
                int idx = q.poll();
                if(idx == target)
                    return ret;
                int x = idxToX(idx);
                int y = idxToY(idx);
                for(int j = 0 ; j<8 ; ++j){
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(nx>=0 && nx<size && ny>=0 && ny<size && map[nx][ny]==false){
                        int nIdx = ptToIdx(nx,ny);
                        map[nx][ny] = true;
                        q.offer(nIdx);
                    }
                }
            }
            ret++;
        }
        return ret;
    }

    static int idxToX(int idx){
        return idx%size;
    }
    static int idxToY(int idx){
        return idx/size;
    }
    static int ptToIdx(int x, int y){
        return y*size+x;
    }
}
