import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;

        for(int i = 0 ; i < n ;++i){
            if(max<arr[i])
                max = arr[i];
        }

        int[] count = new int[max+1];
        int[] b = new int[n];
        //counting
        for(int i = 0 ; i < n ;++i){
            count[arr[i]]++;
        }

        //sum
        int sum = 0;
        for(int i = 0; i <= max; ++i){
            sum += count[i];
            count[i] = sum;
        }

        for(int i = n-1 ; i >= 0; i--) {
            int value = arr[i];
            int index = count[value];
            b[index-1] = value;
            count[value]--;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i< n; ++i)
            bw.write(Integer.toString(b[i]) + "\n");

        bw.flush();
    }
}
