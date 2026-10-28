
class RbtNode{
    //fields

    //data
    private int data;


    //colors (black or red)
    private int color;
    public static final int CL_RED = 0;
    public static final int CL_BLACK = 1;


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

    public int getColor(){ return color;}
    public void setColor(int color){ this.color = color;}

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
            return;
        }

        //link leaf to parent
        node.setParent(parent);
        if (node.getData() < parent.getData()) parent.setLeft(node);
        else parent.setRight(node);


        




    }

    //search(value)
    public boolean search(RbtNode value){

        return false;
    }

    //min()
    public int min(){

    }

    //max()
    public int max(){

    }

    //size()
    public int size(){

    }

    //inorder()
    public int inorder(){

    }



    //helper function

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
        x.setRight(y.getLeft());
        if (y.getRight() != null) y.getRight().setParent(x);
        y.setParent(x.getParent());
        if (x.getParent() == null) this.root = y;
        else if (x == x.getParent().getRight()) x.getParent().setRight(y);
        else x.getParent().setLeft(y);
        y.setRight(x);
        x.setParent(y);
        
    }

}


