import java.util.*;

public class Main {

    static int[][] map;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for(int i = 0 ; i < cases; ++i) {
            n = sc.nextInt();
            int gongsa = sc.nextInt();
            map = new int[n][n];

            int cnt = 0;
            int max = -99;
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    int in = sc.nextInt();
                    if (max < in) {
                        max = Math.max(max, in);
                        cnt = 1;
                    } else if (max == in) {
                        cnt++;
                    }
                    map[j][k] = in;
                }
            }

            int max_length = 0;
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (map[j][k] == max) {
                        max_length = Math.max(dfs(j, k,0,gongsa),max_length);
                    }
                }
            }
            max_length++;
            System.out.println("#" + (i + 1) + " " + max_length);
        }
    }

    static int dfs(int x, int y, int d, int gongsa){
        int depth = d;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};
        for(int m = 0 ; m < 4 ; ++m){
            int nx = x+dx[m];
            int ny = y+dy[m];
            if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]!=99){
                if(map[nx][ny] < map[x][y]){
                    int backup = map[x][y];
                    map[x][y]=99;
                    depth = Math.max(dfs(nx, ny,d+1, gongsa),depth);
                    map[x][y]=backup;
                }
                else if(map[nx][ny]-gongsa < map[x][y]){
                    int backup = map[x][y];
                    int backup_n = map[nx][ny];
                    map[x][y]=99;
                    map[nx][ny] = backup-1;
                    depth = Math.max(dfs(nx, ny,d+1, 0),depth);
                    map[nx][ny] = backup_n;
                    map[x][y]=backup;
                }
            }
        }
        return depth;
    }
}
