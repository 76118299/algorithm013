package week_01;

public class CircularQueue {
    private int[] items;
    private int n;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        items = new int[capacity];
        n = capacity;
    }
    public boolean enquque(int data){
        //队列已满
        if((tail+1%n) == head){
            return false;
        }
        items[tail] = data;
        tail = (tail+1) % n;
        return true;
    }
    public int dequeue(){
        if(head == tail){
            return -1;
        }
        int ret = items[head];
        head = (head +1)%n;
        return ret;
    }
}
