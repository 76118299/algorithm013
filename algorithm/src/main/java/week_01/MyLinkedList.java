package week_01;

public class MyLinkedList {
    private Node head;

    /**
     * 向头部插入节点
     *
     * @param newNode
     */
    public void  insertToHead(Node newNode){
        if(head == null){
            head = newNode;
        }else {
            //新节点替换头节点
            newNode.next = head;
            head = newNode;

        }
    }

    /**
     * 向尾部插入节点
     * @param data
     */
    public void  insetTail(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else {
            Node p = head;
            while (p.next!=null){
                p = p.next;
            }
            newNode.next = p.next;
            p.next = newNode;
        }
    }

    /**
     * 某个节点之后插入
     */
    public void insertAfter(Node p,Node newNode){
        if(p == null){
            return;
        }
        Node q = head;
        while (q!=null && q.data!=p.data){
            q = q.next;
        }
        newNode.next = q.next;
        p.next = newNode;
    }

    /**
     * 某个节点之前插入
     * @param p
     * @param newNode
     */
    public void inserBefor(Node p,Node newNode){
        if(p == null){
            return;
        }
        Node q = head;
        while (q!=null && q.next!=p){
            q = q.next;
        }
        newNode.next = q.next;
        q.next=newNode;
    }
    public void deleteByNode(int value){
        Node p = head;
        Node q = null;
        while (p!=null&& p.data!=value){
            p = p.next;
            q = p;
        }
        if(p == null){
            return;
        }
        if(q==null){
            head = head.next;
        }else {
            p.next = p.next.next;
        }
    }
    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
