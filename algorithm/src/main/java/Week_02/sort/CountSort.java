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


    }
}
