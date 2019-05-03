import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] test = {43,32,6,2,4,63,7,43,1};

        qsort(test, 0, test.length-1);

        System.out.println(Arrays.toString(test));
    }

    static void qsort(int[] arr, int start, int end){
        int i = start;
        int j = end;
        int p = arr[(start+end)/2];

        while(i<=j){
            while(arr[i]<p)
                i++;
            while(arr[j]>p)
                j--;
            if(i<=j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        if(start < j)
            qsort(arr, start, j);
        if(i < end)
            qsort(arr, i, end);
    }
}
