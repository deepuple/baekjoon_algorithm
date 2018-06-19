import java.util.*;

public class Main {

    static int[] map;
    static int size;
    static Queue<Integer> aq, bq;
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    size = sc.nextInt();
	    int godol_idx = ptoIdx(sc.nextInt(),sc.nextInt());
	    int godol_h_idx = ptoIdx(sc.nextInt(),sc.nextInt());

        int gosun_idx = ptoIdx(sc.nextInt(),sc.nextInt());
        int gosun_h_idx = ptoIdx(sc.nextInt(),sc.nextInt());


        map = new int[size*size];
        for(int i = 0; i<size*size; ++i)
            map[i] = sc.nextInt();

        System.out.println(calculate(godol_idx, godol_h_idx, gosun_idx, gosun_h_idx));
    }

    static int ptoIdx(int x, int y) {
        return y * 5 + x;
    }
    static int idxtoX(int idx){
        return idx%size;
    }
    static int idxtoY(int idx){
        return idx/size;
    }

    static int calculate(int a, int a_h, int b, int b_h){
        aq = new LinkedList<Integer>();
        bq = new LinkedList<Integer>();

        aq.offer(a);
        bq.offer(b);
        int cnt=0;

        while(!aq.isEmpty()||!bq.isEmpty()){
            int szA = aq.size();
            int szB = bq.size();
            int godol = -1, gosun = -1;
            if(szA>0 && szB>0) {
                for (int i = 0; i < szA; ++i) {
                    godol = aq.poll();
                    for (int j = 0; j < szB; ++j) {
                        gosun = bq.poll();

                        if (godol == a_h && gosun == b_h)
                            return cnt;

                        if (!checkMate(godol, gosun))
                            continue;

                        if (godol != -1)
                            map[godol] = 2;
                        if (gosun != -1)
                            map[gosun] = 3;

                        if (godol != a_h && godol != -1) {
                            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
                            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
                            for (int l = 0; l < 8; l++) {
                                int to_x = idxtoX(godol) + dx[l];
                                int to_y = idxtoY(godol) + dy[l];
                                int to_idx = ptoIdx(to_x, to_y);
                                if (to_x >= 0 && to_x < size && to_y >= 0 && to_y < size && (map[to_idx] == 0 || map[to_idx] == 3))
                                    aq.offer(to_idx);
                            }
                        }

                        if (gosun != b_h && gosun != -1) {
                            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
                            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
                            for (int k = 0; k < 8; k++) {
                                int to_x = idxtoX(gosun) + dx[k];
                                int to_y = idxtoY(gosun) + dy[k];
                                int to_idx = ptoIdx(to_x, to_y);
                                if (to_x >= 0 && to_x < size && to_y >= 0 && to_y < size && (map[to_idx] == 0 || map[to_idx] == 2))
                                    bq.offer(to_idx);
                            }
                        }
                    }
                }
            }else if(szA>0&&szB==0) {
                for (int j = 0; j < szA; ++j) {
                    godol = aq.poll();

                    if (godol == a_h)
                        return cnt;

                    map[godol] = 2;

                    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
                    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
                    for (int k = 0; k < 8; k++) {
                        int to_x = idxtoX(godol) + dx[k];
                        int to_y = idxtoY(godol) + dy[k];
                        int to_idx = ptoIdx(to_x, to_y);
                        if (to_x >= 0 && to_x < size && to_y >= 0 && to_y < size && (map[to_idx] == 0 || map[to_idx] == 2))
                            aq.offer(to_idx);
                    }
                }
            }else if(szB>0&&szA==0) {
                for (int j = 0; j < szB; ++j) {
                    gosun = bq.poll();

                    if (gosun == b_h)
                        return cnt;

                    map[gosun] = 3;

                    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
                    int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
                    for (int k = 0; k < 8; k++) {
                        int to_x = idxtoX(gosun) + dx[k];
                        int to_y = idxtoY(gosun) + dy[k];
                        int to_idx = ptoIdx(to_x, to_y);
                        if (to_x >= 0 && to_x < size && to_y >= 0 && to_y < size && (map[to_idx] == 0 || map[to_idx] == 2))
                            bq.offer(to_idx);
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }

    static boolean checkMate(int a, int b){
        if(a==-1||b==-1)
            return true;

        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        for(int i = 0 ; i<8 ; i++){
            if(b==ptoIdx(idxtoX(a)+dx[i], idxtoY(a)+dy[i]))
                return false;
        }

        return true;
    }

    static void validate(int a, int b){

    }
}
