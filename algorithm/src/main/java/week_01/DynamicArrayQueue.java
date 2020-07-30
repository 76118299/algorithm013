package week_01;

/**
 * 基于数组动态扩容的队列
 */
public class DynamicArrayQueue {
    private int[] items;
    private int n;
    private int head;
    private int tail;

    public DynamicArrayQueue(int capacity) {
        items = new int[capacity];
        n = capacity;
    }
    public boolean enqueue(int value){
        if(tail == n){
           if(head ==0){
               //数据搬移(缩容)
               for(int i=head;i<tail;i++){
                   items[i-1] = items[i];
               }
               head = 0;
               tail -=head;
           }
        }
        items[++tail]=value;
        return true;
    }
    public int dequeue(){
       if(head == tail){
           return -1;
       }
       return items[++head];
    }
}
