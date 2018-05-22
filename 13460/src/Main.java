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
                    String status="";
                    int n_r_x = r_x;
                    int n_r_y = r_y;
                    int n_b_x = b_x;
                    int n_b_y = b_y;

                    while(map[n_r_y][n_r_x]!='#'){ //끝까지 이동
                        n_r_x = n_r_x + dx[j];
                        n_r_y = n_r_y + dy[j];
                        if(n_r_x == b_x && n_r_y == b_y)
                            status = status+"B";
                        if(map[n_r_y][n_r_x] == 'O') {
                            status = status+"O";
                        }
                    }//BO(OBR), OB(BOR), O(ORB), B(BRO), nothing(RBO,ROB);
                    //O(OR), B(BR)
                    //nothing(R)

                    n_r_x = n_r_x - dx[j];
                    n_r_y = n_r_y - dy[j];

                    while (map[n_b_y][n_b_x] != '#') {
                        n_b_x = n_b_x + dx[j];
                        n_b_y = n_b_y + dy[j];
                        if (r_x == n_b_x && r_y == n_b_y)
                            status = "RB";//nothing(RBO)
                        if (map[n_b_y][n_b_x] == 'O') {
                            status = "F";//BO(OBR), O(ORB), nothing(ROB)
                        }
                    }//OB(BOR), B(BRO,BR), O(OR), nothing(R)

                    n_b_x = n_b_x - dx[j];
                    n_b_y = n_b_y - dy[j];

                    if (status.equals("RB")) {
                        n_b_x = n_b_x - dx[j];
                        n_b_y = n_b_y - dy[j];
                        if(r_x!=n_r_x || r_y!=n_r_y || b_x!=n_b_x || b_y!=n_b_y) {
                            q.offer(n_r_x);
                            q.offer(n_r_y);
                            q.offer(n_b_x);
                            q.offer(n_b_y);
                        }

                    } else if (status.equals("B")) {
                        n_r_x = n_r_x - dx[j];
                        n_r_y = n_r_y - dy[j];
                        if(r_x!=n_r_x || r_y!=n_r_y || b_x!=n_b_x || b_y!=n_b_y) {
                            q.offer(n_r_x);
                            q.offer(n_r_y);
                            q.offer(n_b_x);
                            q.offer(n_b_y);
                        }
                    } else if (status.equals("OB") || status.equals("O")) {
                        return cnt+1;
                    } else if (status.equals("F")) {
                        //do nothing;
                    } else {
                        if(r_x!=n_r_x || r_y!=n_r_y || b_x!=n_b_x || b_y!=n_b_y) {
                            q.offer(n_r_x);
                            q.offer(n_r_y);
                            q.offer(n_b_x);
                            q.offer(n_b_y);
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
