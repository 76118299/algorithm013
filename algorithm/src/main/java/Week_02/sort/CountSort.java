package Week_02.sort;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 3, 1, 5,7,9,3,4,5,7,6,2,4,5,6,6,0,1,2,3};
        int[] result = new int[arr.length];
        int[] count = new int[10];
        for(int i = 0;i<arr.length;i++){
            count[arr[i]]++;
        }
        for(int i = 0,j=0;i<count.length;i++){
            while (count[i]-->0){
                result[j++] = i;
            }
        }
        countSort(arr);

    }

    /**
     * 计数排序稳定版
     * @param arr
     */
    private static void countSort(int[] arr) {
        int []ret = new int[arr.length];
        int []count = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        for(int m=1;m<count.length;m++){
            count[m] = count[m] +count[m-1];// 存储被排序的元素，会出现在最终数组的下标位置
        }
        for(int i=arr.length-1;i>0;i--){
            //取出 arr[i] 要被存放的下标index
          int index=  count[arr[i]];
          int c1 = --index;
          //将arr【i】 存放在 index-1的位置
          ret[c1] = arr[i];
        }
    }
}
