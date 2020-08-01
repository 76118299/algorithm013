package Week_02.sort;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 3, 1, 5,7,9,3,4,5,7,6,2,4,5,6,6,0,1,2,3};
        int[] result = new int[arr.length];
        int[] count = new int[10];
        //先将元素添加到count数组进行计数
        for(int i=0;i<arr.length;i++){
            /**
             *  此时要排序的元素 arr 就变成了count的下标值
             *  下标就是有序的了
             */
            count[arr[i]]++; //这里如果arr【2】=1， arr【3】 = 1 那么count【arr】 ++ 就是2
        }
        for(int i=0,j=0;i<count.length;i++){
            while (count[i]-->0){
                result[j++] = i;
            }
        }

    }
}
