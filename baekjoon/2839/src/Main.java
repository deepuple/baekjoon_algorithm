import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        int ret = 0;
        int input = sc.nextInt();

        ret += input/5;
        input = input%5;
        if(input == 0)
            System.out.println(ret);
        else if(input == 1)
            if(ret>0)
                System.out.println(ret+1);
            else
                System.out.println(-1);
        else if(input == 2)
            if(ret>1)
                System.out.println(ret+2);
            else
                System.out.println(-1);
        else if(input == 3)
            System.out.println(ret+1);
        else if(input == 4)
            if(ret>0)
                System.out.println(ret+2);
            else
                System.out.println(-1);
    }
}

