import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int num = y;
        while(true){
            if((num-x)%15 == 0) {
                if ((num-z)%19 == 0) {
                    System.out.println(num);
                    return;
                }
            }
            num += 28;
        }

    }
}
