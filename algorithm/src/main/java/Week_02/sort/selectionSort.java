package Week_02.sort;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 3, 1, 5};
        for(int i = 0;i<arr.length;i++){
            int minIndex = i;
            //循环找出最小元素的index
            for(int j = 0;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            //跟下标i进行交换
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i]=tmp;
        }
    }
}
