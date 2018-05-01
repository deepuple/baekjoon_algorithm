import java.util.*;

public class Main {

    static char[][] map;
    static int rows, cols;
    static int redIdx;
    static int blIdx;

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    rows = sc.nextInt();
	    cols = sc.nextInt();

	    for(int i = 0 ; i < rows ; ++i) {
            char[] in = sc.nextLine().toCharArray();
            for (int j = 0; j < cols; ++j) {
                if (in[j] == 'R') {
                    map[i][j] = '.';
                    redIdx = ptToIdx(j, i);
                }else if(in[j] =='B'){
                    map[i][j] = '.';
                    blIdx = ptToIdx(j, i);
                }else
                    map[i][j] = in[j];
            }
        }
        System.out.println(BFS());
    }

    static int BFS(){
        Queue<Integer> q = new LinkedList<>();

        q.offer(redIdx);
        q.offer(blIdx);

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0 ; i<(sz/2) ; ++i){
                int redidx = q.poll();
                int blidx = q.poll();

                //어느 방향으로 움직이든...

                    //붉은 색을 끝까지 옮긴다.
                        //벽이 있는 경우 종료
                        //중간에 푸른 구슬이 있다면, 플래그 표시를 해두고 나중에 한칸 뺀다
                        //목적지에 도달하였다면 일단 종료

                    //푸른 색을 끝까지 옮긴다.
                        //벽이 있는 경우 종료
                        //중간에 붉은 구슬이 있다면, 플래그 표시를 해두고 나중에 한칸 뺀다.
                        //목적지에 도달하였다면 일단 종료

                    //플래그 표시에 따라 적당히 좌표를 보정한다

                    //방문 이력이 있다면 큐에 넣지 않는다.

                    //둘다 목적지에 도달한 경우에는 -1 을 출력
                    //하나만 도달한 경우에는 단계를 출력하고 종료

            }
        }
    }

    static int ptToIdx(int x, int y){
        return y*cols+x;
    }
    static int idxToX(int idx){
        return idx*cols;
    }
    static int idxToY(int idx){
        return idx/cols;
    }

}
