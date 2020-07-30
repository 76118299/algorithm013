package week_01;

/**
 * 基于数组的栈
 */
public class StackArray {
    private int[] items;
    //元素的个数
    private int count;
    //栈的大小
    private int n;

    public StackArray(int n) {
        items = new int[n];
        this.n = n;
        count = 0;
    }

    public boolean push(int value){
        if(count == n){
            return false;
        }
        items[++count] = value;
        return true;
    }
    public int pop(){
        if(count == 0){
            return -1;
        }
        return items[--count];
    }
}
