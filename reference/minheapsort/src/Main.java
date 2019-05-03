import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int k = 0; k < n; ++k) {
            sc.nextLine();
            arr[k] = sc.nextInt();
        }

        for(int i = n/2-1; i>=0; --i)
            minheapify(arr, n, i);

        for(int j = n-1; j >= 0; --j) {
            System.out.println(arr[0]);

            int swap = arr[j];
            arr[0] = arr[j];
            arr[j] = swap;
            minheapify(arr, j, 0);
        }
    }

    static void minheapify(int[] arr, int length, int index){
        int min = index;
        int left = index*2+1;
        int right = left+1;

        if(left<length && arr[left]<arr[index])
            min = left;

        if(right<length && arr[right]<arr[min])
            min = right;

        if(min!=index) {
            int swap = arr[index];
            arr[index] = arr[min];
            arr[min] = swap;

            minheapify(arr, length, min);
        }
    }
}
