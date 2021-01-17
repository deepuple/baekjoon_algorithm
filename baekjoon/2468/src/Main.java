import java.util.*;

public class Main {

    static int[][] map;
    static int max;
    static int size;
    static boolean[] visited;

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    size = sc.nextInt();
	    map = new int[size][size];
	    visited = new boolean[size*size];
	    int ret = 0;

	    for(int i = 0 ; i < size ; ++i)
            for(int j = 0 ; j < size ; ++j)
                max = Math.max(max,map[i][j] = sc.nextInt());

	    for(int k = 1; k <= max ; ++k){
	        ret = Math.max(ret, BFS(k));
            Arrays.fill(visited,false);
        }

        System.out.println(ret);
    }
    static int BFS(int h){
        int ret = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        MyQueue q = new MyQueue();
        //Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < size*size ; ++i){
            if(map[i2x(i)][i2y(i)]>h &&!visited[i]){
                ret++;
                q.offer(i);
                visited[i] = true;
                while (!q.isEmpty()){
                    int v = q.poll();
                    for(int j = 0 ; j < 4 ; ++j){
                        int x = i2x(v) + dx[j];
                        int y = i2y(v) + dy[j];
                        int idx = p2i(x,y);
                        if(x >=0 && y >=0 && x < size && y < size && map[x][y]>h && !visited[idx]){
                            q.offer(idx);
                            visited[idx] = true;
                        }
                    }
                }
            }else
                visited[i] = true;
        }
        if(ret == 0)
            return 1;
        return ret;
    }
    static int p2i(int x, int y){
        return y*size+x;
    }
    static int i2x(int idx){
        return idx%size;
    }
    static int i2y(int idx){
        return idx/size;
    }
    static class MyQueue{
        class Node{
            int data;
            Node next;

            public Node(int in){
                this.data = in;
                this.next = null;
            }
        }
        private Node head, tail;
        private int size;

        public void offer(int in){
            Node n = new Node(in);

            if(size == 0){
                head = n;
                tail = head;
                head.next = tail;
            }else{
                tail.next = n;
                tail = n;
            }

            size++;
        }

        public int poll(){
            Node n = head;
            int ret = n.data;
            head = head.next;
            n = null;
            size--;

            return ret;
        }

        public boolean isEmpty(){
            return size==0;
        }
    }
}
