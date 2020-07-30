package week_01;

/**
 * 基于链表实现的栈
 */
public class StackLinked {
    private Node top = null;

    /**
     * 入栈
     */
    public void push(int data){
        Node newNode = new Node(data,null);
        if(top == null){
            top = newNode;
        }else {
            //新的节点变成head
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 出站
     */
    public int pop(){
        if(top == null){
            return  -1;
        }
        int ret = top.data;
        top = top.next;
        return ret;
    }

    public void pringAll(){
        Node p = top;
        while (p!=null){
            System.out.println(p.data);
            p = p.next;
        }
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
