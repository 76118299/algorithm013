package Week_02.sort;

/**
 * 冒泡排序
 */
public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 3, 1, 5};

        for(int i=arr.length;i>0;i--){ //外层循环 i--是因为后面的不需再排序了

            for(int j=0;j<i-1;j++){ //每次冒泡都要找出最大的元素
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }

            }
        }

    }
    public void  bubbleSort(int[] a,int n){
        if(n<=1){
            return;
        }
        for(int i=0;i<n;i++){
            //提前退出冒泡循环的标志位
            boolean flag = false;
            for(int j=0;i<n - i-1;j++){
                if(a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
