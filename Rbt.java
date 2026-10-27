
class RbtNode{
    //fields

    //data
    private int data;


    //colors (black or red)
    private boolean color;
    public static int CL_RED = 0;
    public static int CL_BLACK = 1;


    //left right nodes
    private Integer left;
    private Integer right;


    //parent
    private Integer parent;


    //methods


    //constructor

    public RbtNode(int data){
        this.data = data;
        

    }

    //accessor and mutators

    private int getData(){return data;}
    private  void setData(int data){ this.data = data;}



    //helper methods

    public void getUncle(){}

    public void getGrandParent(){}
    
    





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


