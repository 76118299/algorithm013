package week_01;

public class ArrayQueue {
    private int[] items;
    private int head;
    private int tail;
    private int n;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
        n = capacity;
    }

    /**
     * 入队
     * @return
     */
    public boolean enqueue(int value){
        if(tail == n){
          return false;
        }
        items[++tail] = value;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public int dequeue(){
        if(head == tail){
            return -1;
        }
        return items[++head];
    }
}
