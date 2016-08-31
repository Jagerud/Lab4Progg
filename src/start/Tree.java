package start;

/**
 * Created by Jaeger on 2016-08-06.
 */
/*
public class Tree {
    public Node root;
    public Tree(){
        this.root = new Node(true,null,null);
    }


    public void insert(int id){
        Node newNode = new Node(id);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(id<current.getData()){ //ändra men inte säker på vad data ska innehålla, plats? tänkte om boxen finns kvar
                current = current.left;
                if(current==null){
                    parent.left = newNode;
                    return;
                }
            }else{
                current = current.right;
                if(current==null){
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
}
*/
