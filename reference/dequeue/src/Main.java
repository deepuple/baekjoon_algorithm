import java.util.*;

class Deque{
    LinkedList<Integer> dq = new LinkedList<Integer>();

    public void push_front(int data){
        dq.addFirst(data);
    }

    public void push_back(int data){
        dq.add(data);
    }

    public int pop_front(){
        if(dq.isEmpty())
            return -1;
        else {
            return dq.remove(0);
        }
    }

    public int pop_back(){
        if(dq.isEmpty())
            return -1;
        else {
            return dq.remove(dq.size()-1);
        }
    }

    public int size(){
        return dq.size();
    }

    public int empty(){
        if(dq.isEmpty())
            return 1;
        else
            return 0;
    }

    public int front(){
        if(dq.isEmpty())
            return -1;
        return dq.get(0);
    }

    public int back(){
        if(dq.isEmpty())
            return -1;
        return dq.get(dq.size()-1);
    }
}

public class Main {

    static Deque myQueue = new Deque();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < cases; ++i){
            ctrl(sc.nextLine());
        }
    }

    private static void ctrl(String in){
        String[] cmd = in.split(" ");
        if(cmd.length==2) {
            if(cmd[0].equals("push_front"))
                myQueue.push_front(Integer.parseInt(cmd[1]));
            else if(cmd[0].equals("push_back"))
                myQueue.push_back(Integer.parseInt(cmd[1]));
        }
        else if(cmd[0].equals("pop_front"))
            System.out.println(myQueue.pop_front());
        else if(cmd[0].equals("pop_back"))
            System.out.println(myQueue.pop_back());
        else if(cmd[0].equals("size"))
            System.out.println(myQueue.size());
        else if(cmd[0].equals("empty"))
            System.out.println(myQueue.empty());
        else if(cmd[0].equals("front"))
            System.out.println(myQueue.front());
        else if(cmd[0].equals("back"))
            System.out.println(myQueue.back());
    }
}
