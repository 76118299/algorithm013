package week_01;

public class LinkedQueue {
    private Node head;
    private Node tail;

    /**
     * 入队
     */
    public void enqueue(int value){
        Node newNode = new Node(value,null);
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = tail.next;

        }
    }

    /**
     * 出队
     * @return
     */
    public int enqueue(){
        if(head == null){
            return -1;
        }
        int ret = head.data;
        head = head.next;
        if(head == null){
            tail =null;
        }
        return  ret;
    }
    class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
