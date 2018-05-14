import java.util.*;

public class Main {

    static boolean[][] map;
    static boolean[] isVisited;

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int vertice = sc.nextInt();
        int edge = sc.nextInt();

        map = new boolean[vertice+1][vertice+1];
        isVisited = new boolean[vertice+1];

        for(int i = 0 ;i < edge;++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            map[from][to] = true;
            map[to][from] = true;
        }

        int cnt = 0;
        MyQueue q = new MyQueue();

        for(int j = 1; j<=vertice ; ++j){
            if(!isVisited[j]){
                cnt++;
                q.offer(j);
                isVisited[j] = true;
                while (!q.isEmpty()){
                    int from = q.poll();
                    for(int k = 1 ; k<=vertice;++k){
                        if(map[from][k]&&!isVisited[k]){
                            q.offer(k);
                            isVisited[k] = true;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    static class MyQueue{

        private Node head;
        private Node tail;
        int size = 0;

        class Node{
            private Node next;
            private int data;

            public Node(int in){
                this.next = null;
                this.data = in;
            }
        }

        public void offer(int in){
            Node tmp = new Node(in);
            if(size==0){
                head = tail = tmp;
                head.next = tail;
            }else {
                tail.next = tmp;
                tail = tmp;
            }
            size++;
        }

        public int poll(){
            Node tmp = head;
            int ret = tmp.data;
            head = head.next;
            tmp = null;
            size--;
            return ret;
        }

        public boolean isEmpty(){
            return size==0;
        }
    }
}
