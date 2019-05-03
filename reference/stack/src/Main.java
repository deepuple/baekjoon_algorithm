import java.util.*;

class Stack{
    private int top = -1;
    ArrayList<Integer> st = new ArrayList();

    public void push(int data){
        st.add(data);
        top++;
    }

    public int pop(){
        if(st.isEmpty())
            return top;
        else {
            int ret;
            ret = st.remove(top);
            top--;
            return ret;
        }
    }

    public int size(){
        return st.size();
    }

    public int empty(){
        if(st.isEmpty())
            return 1;
        else
            return 0;
    }

    public int top(){
        if(st.isEmpty())
            return top;
        return st.get(top);
    }
}

public class Main {

    static Stack myStack = new Stack();

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
        if(cmd.length==2)
            myStack.push(Integer.parseInt(cmd[1]));
        else if(cmd[0].equals("pop"))
            System.out.println(myStack.pop());
        else if(cmd[0].equals("size"))
            System.out.println(myStack.size());
        else if(cmd[0].equals("empty"))
            System.out.println(myStack.empty());
        else if(cmd[0].equals("top"))
            System.out.println(myStack.top());
    }
}
