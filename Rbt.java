
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

    private int getData(){return data;}
    private void setData(int data){ this.data = data;}

    public int getColor(){ return color;}
    public int setColor(int color){ this.color = color;}

    public RbtNode getLeft(){ return left;}
    public RbtNode setLeft(RbtNode left){ this.left = left;}

    public RbtNode getRight(){ return right;}
    public RbtNode setRight(RbtNode right){ this.right = right;}
 
    public RbtNode getParent(){ return parent;}
    public RbtNode setParent(RbtNode parent){ this.parent = parent;}

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

    public void insert(value)

    //search(value)
    public boolean search(value){

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

}


