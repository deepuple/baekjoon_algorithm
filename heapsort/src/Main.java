public class Main {

    public static void main(String[] args) {
        int[] arr ={2,3,525,67,23,246,324,34,523,2,1};

        int n = arr.length;

        //build heap tree
        for(int i = n/2-1; i >=0 ; i--)
            maxheap(arr, n, i);

        //rearrage
        for (int i=n-1; i>=0; i--)
        {
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap;

            maxheap(arr, i, 0);
        }

        for(int j=0;j<arr.length;++j)
            System.out.print(arr[j]+", ");
    }

    static void maxheap(int[] arr, int length, int index){
        int largest_index=index;
        int left=index*2+1;
        int right=left+1;

        if(left<length && arr[left]>arr[index]){
            largest_index=left;
        }

        if(right<length && arr[largest_index]<arr[right]){
            largest_index=right;
        }

        if(largest_index!=index){
            int swap = arr[index];
            arr[index] = arr[largest_index];
            arr[largest_index] = swap;

            maxheap(arr, length, largest_index);
        }
    }
}
