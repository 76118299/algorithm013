package Week_02.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 3, 1, 5};
        for(int i=0;i<arr.length;i++){
            for(int j = i;j>0;j--){
                if(arr[j]>arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    /**
     * 不使用比较和交换
     * @param a
     * @param n
     */
     public void insertionSort(int[] a,int n){
        if(n<=1){
            return;
        }
        for(int i=1;i<n;i++){
            int value = a[i];
            int j = i-1;
            for(;j>=0;j--){
                //查找插入的位置
                if(a[j]>value){
                    a[j+1] = a[j];//这里需要数据搬移
                }else {
                    break;
                }
            }
            a[j+1] = value;//插入数据
        }

        for(int i=1;i<n;i++){
            int value = a[i];
            int j = i-1;
            for(;j>=0;j--){
                if(a[j]>value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;

        }
     }
}
