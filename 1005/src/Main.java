import java.util.*;
import java.io.*;

public class Main {


    static int[] build_time;
    static ArrayList<Integer>[] node;
    static int[] build_time_total;
    static int v;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cases = Integer.parseInt(br.readLine());

        for(int i =0 ; i<cases; ++i){
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            build_time = new int[v+1];
            build_time_total = new int[v+1];
            boolean[] dep_building = new boolean[v+1];
            node =  new ArrayList[v+1];
            for(int m = 1 ; m <= v ; ++m)
                node[m] = new ArrayList<Integer>();
            int node_num = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= v ; ++j){
                build_time[j] = Integer.parseInt(st.nextToken());
            }

            for(int k = 0 ; k< node_num ; ++k){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                node[to].add(from);
                dep_building[to] = true;
            }

            for(int m = 1 ; m <= v ;++m){
                if(dep_building[m]==false)
                    build_time_total[m] = build_time[m];
            }

            int target = Integer.parseInt(br.readLine());

            System.out.println(bt(target));
        }
    }
    static int bt(int in){
        if(build_time_total[in]!=0)
            return build_time_total[in];

        int tmp=0;
        for(int i = 0 ; i <node[in].size();++i){
            int from = node[in].get(i);
            tmp = Math.max(tmp, bt(from));
        }
        return build_time_total[in] = tmp + build_time[in];
    }
}
