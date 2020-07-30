package week_01;

/**
 * 数组
 * add delete find
 */
public class MyArray {
    private int[] data;
    /**
     * 数组的长度
     */
    private int length;
    /**
     * 数组元素的数量
     */
    private int count;
    /**
     * 数组的默认长度
     */
    private static final int DEFATUL_CAPACITY = 10;

    public MyArray(int capacity) {
        this.data = new int[capacity];
        this.length = capacity;
        this.count = 0;
    }
    public MyArray() {
       this(DEFATUL_CAPACITY);
    }
    private void ensureCapacity(int length){
        this.length = length*2;
        int[] newDate = new int[this.length];
        System.arraycopy(data,0,newDate,0,data.length);
        data = newDate;
    }
    /**
     * 添加一个元素
     * @param data
     */
    public boolean add(int data){
        if(count == length ){
            this.ensureCapacity(length);
        }
        this.data[count++] = data;
        return true;
    }

    /**
     * 将元素添加到指定的下标中
     * @param index
     * @param data
     * @return
     */
    public boolean add(int index,int data){
        if(index<0||index>length){
            return false;
        }
        if(count == length ){
            this.ensureCapacity(length);
        }
        for(int i= length;i>=index;i--){
               this.data[i+1] = this.data[i];//元素向后移动
        }
        this.data[index] = data;
        return true;
    }
    public int remove(int index){
        if(index<0||index>length){
            return -1;
        }
        int ret = data[index];
        for (int i = index;i<length;i++){
            this.data[i-1] = this.data[i];
        }
        return ret;
    }
}
