package Week_02.sort;

/**
 * 归并排序是将两个数组进行合并到第三个数组中
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr =new int[]{1,4,7,8,3,6,9};
        int[] temp = new int[arr.length];
        int mid = arr.length/2;
        int i = 0;
        int j = mid+1;
        int k = 0;

        while (i<mid && j<arr.length){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }else if(arr[i]>arr[j]) {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
    }
    
    public void mergeSortRecursion(int[] a,int p,int r){
        if(p>=r){
            return;
        }
        int q = p + (r - p) / 2;
        mergeSortRecursion(a,p,q);
        mergeSortRecursion(a,q+1,r);
        merge(a,p,q,r);

    }

    private void merge(int[] a, int p, int q, int r) {
        int i=p;
        int j = q+1;
        int k=0;
        int[] tmp = new int[r-p+1];
        while (i<=q&&j<=r){
            if(a[i]<=a[j]){
                tmp[k++] = a[i++];
            }else {
                tmp[k++] = a[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据。
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据copy到临时数组 tmp。
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        //将 tmp 中的数据拷贝回 a 中
        System.arraycopy(tmp, 0, a, p, r - p + 1);
    }

}
