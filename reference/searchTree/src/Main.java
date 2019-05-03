import java.util.*;

public class Main {

    static ArrayList<Integer>[] ar;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertice = sc.nextInt();
        int cases = sc.nextInt();
        int start = sc.nextInt();

        ar = new ArrayList[vertice+1];
        visited = new boolean[vertice+1];

        for (int i = 1; i <= vertice; ++i)
            ar[i] = new ArrayList<Integer>();

        for (int i = 0; i < cases; ++i) {
            sc.nextLine();
            int a = sc.nextInt();
            int b = sc.nextInt();
            ar[a].add(b);
            ar[b].add(a);
        }
        Arrays.fill(visited,false);
        dfs(start);
        System.out.println();
        Arrays.fill(visited,false);
        bfs(start);
    }

    private static void dfs(int vertex){
        Stack<Integer> st = new Stack<>();

        st.push(vertex);
        while(!st.isEmpty()){
            int v = st.pop();
            if(!visited[v]) {
                System.out.print(v + " ");
                visited[v] = true;
            }
            Collections.sort(ar[v], Collections.reverseOrder());
            for(int i = 0; i<ar[v].size();++i) {
                if (!visited[ar[v].get(i)]) {
                    st.push(ar[v].get(i));
                }
            }
        }
    }

    private static void bfs(int vertex){
        Queue<Integer> q = new LinkedList<>();

        q.offer(vertex);
        while(!q.isEmpty()){
            int v = q.poll();
            if(!visited[v]) {
                System.out.print(v + " ");
                visited[v] = true;
            }
            Collections.sort(ar[v]);
            for(int i = 0; i<ar[v].size();++i) {
                if (!visited[ar[v].get(i)]) {
                    q.offer(ar[v].get(i));
                }
            }
        }
    }
}
