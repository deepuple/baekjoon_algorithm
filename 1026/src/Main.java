import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] a = new int[size];
        int[] b = new int[size];

        for(int i = 0; i< size ; ++i)
            a[i] = sc.nextInt();
        for(int j = 0; j< size ; ++j)
            b[j] = sc.nextInt();

        qsort(a, 0, a.length-1, true);
        qsort(b, 0, b.length-1, false);

        System.out.println(mux(a,b,size));

    }

    static int mux(int[] a, int[] b, int size){
        int ret=0;
        for(int i = 0; i<size;++i)
            ret += a[i]*b[i];

        return ret;
    }

    static void qsort(int[] arr, int start, int end, boolean asc) {
        int i = start;
        int j = end;
        int p = arr[(start + end) / 2];

        while (i <= j) {
            if (asc) {
                while (arr[i] < p)
                    i++;
                while (arr[j] > p)
                    j--;
            } else {
                while (arr[i] > p)
                    i++;
                while (arr[j] < p)
                    j--;
            }

            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        if (start < j)
            qsort(arr, start, j, asc);
        if (i < end)
            qsort(arr, i, end, asc);

    }
}
