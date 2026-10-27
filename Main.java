public class Main {
    public static void main(String[] args) {
        //Instatiate and initialize Rbt object
        Rbt tree = new Rbt();

        //load with initial values
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);

        while (true){
            Vis.showTree(tree);
            if (!Vis.showMenu(tree)){
                break;
            }
        }
    }

}
