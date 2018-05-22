import java.util.*;

public class Main {

    static char[][] map;
    static int rows, cols;

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    rows = sc.nextInt();
	    cols = sc.nextInt();
        int rx=0, ry=0, bx=0, by=0;

        map = new char[rows][cols];
        sc.nextLine();
	    for(int i = 0 ; i < rows ; ++i) {
            char[] in = sc.nextLine().toCharArray();
            for (int j = 0; j < cols; ++j) {
                if (in[j] == 'R') {
                    ry = i;
                    rx = j;
                    map[i][j] = 'R';
                }else if(in[j] =='B'){
                    by = i;
                    bx = j;
                    map[i][j] = '.';
                }else
                    map[i][j] = in[j];
            }
        }
        System.out.println(BFS(rx, ry, bx, by));
    }

    static int BFS(int rx, int ry, int bx, int by){
        Queue<Integer> q = new LinkedList<>();
        q.offer(rx);
        q.offer(ry);
        q.offer(bx);
        q.offer(by);

        int cnt = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0 ; i<(sz/4) ; ++i){
                int r_x = q.poll();
                int r_y = q.poll();
                int b_x = q.poll();
                int b_y = q.poll();
                int[] dx = {1,0,-1,0};
                int[] dy = {0,1,0,-1};

                for(int j = 0 ; j < 4 ; ++j){
                    String status="";//RB, BR, G, OB
                    int n_r_x = r_x;
                    int n_r_y = r_y;
                    int n_b_x = b_x;
                    int n_b_y = b_y;

                    while(map[n_r_y][n_r_x]!='#'){ //끝까지 이동
                        n_r_x = n_r_x + dx[j];
                        n_r_y = n_r_y + dy[j];
                        if(n_r_x == b_x && n_r_y == b_y && !status.equals("G")) //골에 지나가지 않았고, 푸른색 구슬을 만난경우
                            status = "BR";
                        if(map[n_r_y][n_r_x] == 'O') { //골을 지나간 경우
                            if (status.equals("BR")) //푸른 색을 먼저 지난경우
                                status = "OB"; //푸른색이 먼저 도달함
                            else
                                status = "G"; //붉은색이 먼저 도달함
                        }

                    }
                    n_r_x = n_r_x - dx[j];
                    n_r_y = n_r_y - dy[j];

                    if(n_r_x != r_x || n_r_y != r_y) {
                        while (map[n_b_y][n_b_x] != '#') {
                            n_b_x = n_b_x + dx[j];
                            n_b_y = n_b_y + dy[j];
                            if (r_x == n_b_x && r_y == n_b_y && !status.equals("OB")) //골에 지나가지 않았고, 붉은 색을 만난경우
                                status = "RB";
                            if (map[n_b_y][n_b_x] == 'O') { //골을 지나간 경우
                                status = "OB"; //푸른색이 먼저 도달함
                            }
                        }
                        n_b_x = n_b_x - dx[j];
                        n_b_y = n_b_y - dy[j];

                        if (status.equals("RB")) {
                            n_b_x = n_b_x - dx[j];
                            n_b_y = n_b_y - dy[j];
                            if (map[n_r_y][n_r_x] != 'R') {
                                q.offer(n_r_x);
                                q.offer(n_r_y);
                                q.offer(n_b_x);
                                q.offer(n_b_y);
                                map[n_r_y][n_r_x] = 'R';
                            }
                        } else if (status.equals("BR")) {
                            n_r_x = n_r_x - dx[j];
                            n_r_y = n_r_y - dy[j];
                            if (map[n_r_y][n_r_x] != 'R') {
                                q.offer(n_r_x);
                                q.offer(n_r_y);
                                q.offer(n_b_x);
                                q.offer(n_b_y);
                                map[n_r_y][n_r_x] = 'R';
                            }
                        } else if (status.equals("OB")) {
                            //do nothing;
                        } else if (status.equals("G")) {
                            return cnt+1;
                        } else {
                            if (map[n_r_y][n_r_x] != 'R') {
                                q.offer(n_r_x);
                                q.offer(n_r_y);
                                q.offer(n_b_x);
                                q.offer(n_b_y);
                                map[n_r_y][n_r_x] = 'R';
                            }
                        }
                    }
                }
            }
            cnt++;
            
            if(cnt>10)
                return -1;
        }
        return -1;
    }

}
