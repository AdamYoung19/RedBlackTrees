
class RbtNode{
    //fields

    //data
    private int data;


    //colors (black or red)
    private byte color;
    public static final byte CL_RED = 0;
    public static final byte CL_BLACK = 1;


    //left right nodes
    private RbtNode left;
    private RbtNode right;


    //parent
    private RbtNode parent;


    //methods


    //constructor

    public RbtNode(int data){
        this.data = data;
        this.color = CL_RED;
        this.left = null;
        this.right = null;
        this.parent = null;
        
    }

    //accessor and mutators

    public int getData(){return data;}
    public void setData(int data){ this.data = data;}

    public byte getColor(){ return color;}
    public void setColor(byte color){ this.color = color;}

    public RbtNode getLeft(){ return left;}
    public void setLeft(RbtNode left){ this.left = left;}

    public RbtNode getRight(){ return right;}
    public void setRight(RbtNode right){ this.right = right;}
 
    public RbtNode getParent(){ return parent;}
    public void setParent(RbtNode parent){ this.parent = parent;}

    //helper methods

    public RbtNode getUncle(){
        RbtNode gp = getGrandParent();
        if (gp == null) return null;
        if (this.parent == gp.left) return gp.right;
        else return gp.left;

    }

    public RbtNode getGrandParent(){
        if (this.parent != null) {
            return this.parent.parent;}
        return null;
    }
    
    





}





public class Rbt {
    //Fields
    public RbtNode root;
    private String inorderStr = "";


    //methods (all public)

    //insert(value)

    public void insert(int value){
        RbtNode node = new RbtNode(value);

        //if empty tree
        if (root == null){
            node.setColor(RbtNode.CL_BLACK);
            root = node;
            return;
        }

        //Go to leaf
        RbtNode parent = null;
        RbtNode current = root;

        while (current != null){
            parent = current;
            if (node.getData() < current.getData()) current = current.getLeft();
            else if (node.getData() > current.getData()) current = current.getRight();
            else return;
        }

        //link leaf to parent
        node.setParent(parent);
        if (node.getData() < parent.getData()) parent.setLeft(node);
        else parent.setRight(node);

        fixInsert(node);
        




    }

    //Helper fix insert
    public void fixInsert(RbtNode k){
        while (k.getParent() != null && k.getParent().getColor() == RbtNode.CL_RED){
            RbtNode uncle = k.getUncle();
            RbtNode gp = k.getGrandParent();
            RbtNode parent = k.getParent();


            //case 1: parent is left of gp
            if (parent == gp.getLeft()){
                //case 1a: uncle is red
                if (uncle != null && uncle.getColor() == RbtNode.CL_RED){
                    parent.setColor(RbtNode.CL_BLACK);
                    uncle.setColor(RbtNode.CL_BLACK);
                    gp.setColor(RbtNode.CL_RED);
                    k = gp;
                } else {
                    //case 1ba: uncle is black, k is right child
                    if (k == parent.getRight()) {
                        k = parent;
                        rightRotate(k);
                        parent = k.getParent();
                    }
                    //case 1bb: uncle is black, k is left child
                    parent.setColor(RbtNode.CL_BLACK);
                    gp.setColor(RbtNode.CL_RED);
                    leftRotate(gp);

                }
            }
            //case 2: parent is right of gp
            else {
                //case 2a: uncle is red
                if (uncle != null && uncle.getColor() == RbtNode.CL_RED){
                    parent.setColor(RbtNode.CL_BLACK);
                    uncle.setColor(RbtNode.CL_BLACK);
                    gp.setColor(RbtNode.CL_RED);
                    k = gp;
                } else {
                    //case 2ba: uncle is black, k is left child
                    if (k == parent.getLeft()) {
                        k = parent;
                        rightRotate(k);
                        parent = k.getParent();
                    }
                    //case 2bb: uncle is black, k is right child
                    parent.setColor(RbtNode.CL_BLACK);
                    gp.setColor(RbtNode.CL_RED);
                    leftRotate(gp);

                }
            }
        }
        root.setColor(RbtNode.CL_BLACK);
    }

    //search(value)
    public boolean search(int value){
        RbtNode current = root;

        while (current != null) {
            if (value == current.getData()){
                return true;
            } else if (value < current.getData()){
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    //min()
    public int min(){
        if (root == null) return -1;

        RbtNode current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getData();
    }

    //max()
    public int max(){
        if (root == null) return -1;

        RbtNode current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getData();
    }

    //size()
    public int size(){
        return sizeHelper(root);
    }

    private int sizeHelper(RbtNode node){
        if (node == null) return 0;
        return 1 + sizeHelper(node.getLeft()) + sizeHelper(node.getRight());
    }


    //inorder()
    public String inorder(){
        inorderStr = "";
        inorderHelper(root);
        return inorderStr;
    }

    //helper inorder
    private void inorderHelper(RbtNode node){
        if (node != null){
            inorderHelper(node.getLeft());
            inorderStr += node.getData() + " ";
            inorderHelper(node.getRight());
        }
    }



    //************ /* 
    //BONUS: DELETE FUNCTION
   /*
    public void delete(int value){
        RbtNode node = root;


        //find the node
        while (node != null && node.getData() != value){
            if (value < node.getData()) node = node.getLeft();
            else node = node.getRight();
        }

        //if not found
        if (node == null) return;



        //case 1: node has no children

        


        //case 2: node has one child


        //case 3: node has two children


    }  */

    //************ 


    //helper rotation functions

    private void leftRotate(RbtNode x){
        RbtNode y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != null) y.getLeft().setParent(x);
        y.setParent(x.getParent());
        if (x.getParent() == null) this.root = y;
        else if (x == x.getParent().getLeft()) x.getParent().setLeft(y);
        else x.getParent().setRight(y);
        y.setLeft(x);
        x.setParent(y);
        
    }


    private void rightRotate(RbtNode x){
        RbtNode y = x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != null) y.getRight().setParent(x);
        y.setParent(x.getParent());
        if (x.getParent() == null) this.root = y;
        else if (x == x.getParent().getRight()) x.getParent().setRight(y);
        else x.getParent().setLeft(y);
        y.setRight(x);
        x.setParent(y);
        
    }

}


