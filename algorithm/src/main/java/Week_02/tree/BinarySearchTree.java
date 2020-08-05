package Week_02.tree;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {
    private Node tree;
    public Node find(int data){
        Node p = tree;
        while (p!=null){
            if(p.data>data){
                p = p.right;
            }else {
                p = p.left;
            }
            return p;

        }
        return null;
    }
    public void insert(int data){
        if(tree == null){
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p!=null){
            if(data>p.data){
                if(p.right==null){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }else if(data<p.data) {
                if(p.left == null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }
    public void  delete(int data){
        Node p = tree;//p 指向要删除的节点，初始化指向根节点
        Node pp = null;// pp 记录的是p的父节点
        while (p!=null && p.data!=data){
            pp = p;
            if(data>p.data){
                p = p.right;
            }else {
                p = p.left;
            }
        }
        if(p == null){
            return;
        }
        //要删除的节点有俩节点
        if(p.left!=null && p.right!=null){
            Node minp = p.right;
            Node minpp = null;
            while (minp.left!=null){
                minpp = minp;
                minp = minp.left;
            }
            p.data = minp.data;
            p = minp;
            pp = minpp;
        }
        //删除节点是叶子节点，或者仅有一个子节点
        Node child; //p的子节点
        if(p.left !=null){
            child = p.left;
        }else if(p.right!=null){
            child = p.right;
        }else {
            child = null;
        }
        if(pp ==null){//删除的是根节点
            pp = tree;
        }else if(pp.left ==p){
            pp.left = child;
        }else {
            pp.right = child;
        }

    }
    public Node finMin(){
        Node p = tree;
        while (p.left!=null){
            p = p.left;
        }
        return p;
    }
    public Node finMax(){
        Node p = tree;
        while (p.right!=null){
            p = p.right;
        }

        return p;
    }
    class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
