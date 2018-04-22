import java.util.*;

public class Main {

    static String[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0 ; i< cases; ++i){
            check = new String[10000];
            int curr = sc.nextInt();
            int target = sc.nextInt();

            System.out.println(BFS(curr, target));
        }
    }
    static String BFS(int from, int to){
        MyQueue mq = new MyQueue();

        mq.offer(from);
        check[from] = "A";

        while(!mq.isEmpty()){
            int x = mq.poll();
            if(x == to){
                return check[x].substring(1,check[x].length());
            }else{
                if(check[D(x)]==null||check[D(x)].equals("")) {
                    mq.offer(D(x));
                    check[D(x)] = check[x]+"D";
                }
                if(check[S(x)]==null||check[S(x)].equals("")) {
                    mq.offer(S(x));
                    check[S(x)] = check[x]+"S";
                }
                if(check[L(x)]==null||check[L(x)].equals("")) {
                    mq.offer(L(x));
                    check[L(x)] = check[x]+"L";
                }
                if(check[R(x)]==null||check[R(x)].equals("")) {
                    mq.offer(R(x));
                    check[R(x)] = check[x]+"R";
                }
            }
        }
        return "ASSERT";
    }
    static int D(int in){
        int ret = in*2;
        return ret>=10000 ? ret%10000 : ret;
    }
    static int S(int in){
        return in==0 ? 9999 : in-1;
    }
    static int L(int in){
        int ret = (in*10)%10000+(in*10)/10000;
        return ret;
    }
    static int R(int in){
        int ret = (in%10)*1000+in/10;
        return ret;
    }

    static class MyQueue{
        private Node head;
        private Node tail;
        private int size;

        class Node{
            private Node next;
            int data;
            Node(int in){
                this.data = in;
                this.next = null;
            }
        }
        public void offer(int in){
            Node tmp = new Node(in);
            if(size == 0){
                head = tail = tmp;
                head.next = tail;
                tail.next = head;
            }else{
                tail.next = tmp;
                tail = tmp;
            }
            size++;
        }

        public int poll(){
            Node tmp = head;
            int ret = head.data;

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


