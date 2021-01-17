import java.util.*;

public class Main {

    static boolean[] key;

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        key = new boolean[10];

        int num =  sc.nextInt();
        int broken = sc.nextInt();
        for(int i = 0 ; i < broken ; ++i){
            key[sc.nextInt()] = true;
        }

        if(num==100) {
            System.out.println(0);
        }
        else{
            int ret = 0;

            //+, -;
            ret = Math.abs(100-num);

            //only key
            if(broken==0)
                ret = Math.min(ret, Integer.toString(num).length());
            else { //key, +, -
                ret = Math.min(ret, findNum(num, Math.abs(100-num)));
            }
            System.out.println(ret);
        }

    }

    static int findNum(int num, int diff){
        //--
        int click=0;
        int ret=diff;
        while(click<diff) {
            if(num-click<0){
                break;
            }
            if (available(num-click)) {
                ret = Integer.toString(num-click).length() + click;
                break;
            }
            click++;
        }
        //++
        click=0;
        while(click<diff) {
            if (available(num+click)) {
                ret = Math.min(ret, Integer.toString(num+click).length() + click);
                break;
            }
            click++;
        }

        return ret;
    }

    static boolean available(int num){
        while(num >= 10){
            int check = num%10;
            if(key[check])
                return false;
            num = num/10;
        }

        if(key[num])
            return false;

        return true;
    }
}
