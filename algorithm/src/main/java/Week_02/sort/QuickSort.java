package Week_02.sort;


/**
 * 快速排序是找到一个轴，和轴进行比较，进行交换
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 3, 1, 5};
        int left=0;
        int right = arr.length-2;
        quickSort(arr,left,right);

    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left>=right){
            return;
        }
        partition(arr,left,right);
    }

    private static void partition(int[] arr, int left, int right) {
        //定义一个轴
        int pivot = arr[right];
        int leftBound = left;
        int rightBound = right;
        while (leftBound<rightBound){
            //找到左边比轴大的元素
            while (arr[leftBound]<=pivot)  leftBound++;
            //找到右边比轴小的元素
            while (arr[rightBound]>=pivot) rightBound++;
            //进行元素交换
            int tmp=arr[right];
            arr[right] = arr[leftBound];
            arr[leftBound] = tmp;
        }
        int tmp=arr[right];
        arr[right] = arr[leftBound];
        arr[leftBound] = tmp;
    }
}
