import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Stack{
    ArrayList<Integer> st = new ArrayList();

    public void push(int data){
        st.add(data);
    }

    public int pop(){
        if(st.isEmpty())
            return -1;
        else
            return st.remove(st.size()-1);
    }

    public int size(){
        return st.size();
    }

    public boolean empty(){
        return st.isEmpty();
    }

    public int top(){
        if(st.isEmpty())
            return -1;
        return st.get(st.size()-1);
    }

    public boolean hasData(int data){
        return st.contains(data);
    }
}

public class Main {
    static Stack myStack = new Stack();
    static boolean[] memo = new boolean[100000];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        Arrays.fill(memo,true);

        int cases = Integer.parseInt(br.readLine());
        for(int i = 0; i < cases; ++i){
            int in = Integer.parseInt(br.readLine());
            if(!isAvailable(in)) {
                System.out.println("NO");
                return;
            }else {
                ctrl(in);
            }
        }
        bw.flush();
    }

    private static boolean isAvailable(int data){
        if(memo[data]||myStack.hasData(data))
            return true;
        else
            return false;
    }

    private static void ctrl(int in) throws Exception{
        if(myStack.hasData(in)) {
            while(true) {
                int popVal = myStack.pop();
                memo[popVal] = false;
                bw.write("-\n");
                if(popVal==in)
                    break;
            }
        }else {
            for(int i=1;i<=in;++i){
                if(memo[i]) {
                    myStack.push(i);
                    bw.write("+\n");
                }
                memo[i] = false;
            }
            myStack.pop();
            bw.write("-\n");
        }
    }
}