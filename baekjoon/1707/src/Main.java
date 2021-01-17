import java.util.*;

public class Main {

    static boolean[][] map;
    static boolean[] isVisited;
    static boolean[] flag;

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        int cases = sc.nextInt();

        for(int x = 0 ; x<cases;++x) {

            int vertice = sc.nextInt();
            int edge = sc.nextInt();

            map = new boolean[vertice + 1][vertice + 1];
            isVisited = new boolean[vertice + 1];
            flag = new boolean[vertice+1];

            for (int i = 0; i < edge; ++i) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                map[from][to] = true;
                map[to][from] = true;
            }

            boolean check = true;
            MyQueue q = new MyQueue();

            for (int j = 1; j <= vertice; ++j) {
                if (!isVisited[j]) {
                    boolean red = false;
                    q.offer(j);
                    isVisited[j] = true; //false
                    flag[j] = red; // false;
                    red = flipflop(red); //true
                    while (!q.isEmpty()) {
                        int sz = q.size();
                        for(int l = 0; l<sz ;++l){
                            int from = q.poll();
                            for (int k = 1; k <= vertice; ++k) {
                                if (map[from][k]) {
                                    if (!isVisited[k]) {
                                        q.offer(k);
                                        isVisited[k] = true;
                                        flag[k] = red; // true
                                    } else if (red != flag[k]) {
                                        check = false;
                                        break;
                                    }
                                }
                            }
                        }
                        red = flipflop(red);//false
                    }
                }
            }

            if(check)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static boolean flipflop(boolean flag){
        if(flag)
            return false;
        else
            return true;
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

        public int size(){
            return size;
        }
    }
}
