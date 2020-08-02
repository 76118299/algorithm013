package Week_02.sort;

/**
 * 简单的二分查找
 */
public class BinarySerch {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 3, 1, 5};
      int ret=  bserch(arr,arr.length,9);
    }

    /**
     * 二分查找前提是数组有序
     * @param arr
     * @param length
     * @param value
     * @return
     */
    private static int bserch(int[] arr, int length, int value) {
        int low = 0;
        int high = length-1;
        //临界点，low<=high
        while (low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == value){
                return mid;
            }else if(value>arr[mid]){
                low = mid+1;
            }else if(value<arr[mid]){
                high = mid-1;
            }
        }
        return -1;
    }
}
