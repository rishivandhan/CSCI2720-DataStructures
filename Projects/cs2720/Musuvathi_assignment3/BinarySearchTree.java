import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class BinarySearchTree<T extends Comparable<T>>{


    private NodeType<T> root;


    public BinarySearchTree(){
        root = null;
    }

    public NodeType<T> getRoot(){
        return root;
    }





    //methods start from here;
    
    //insert method that takes in the root of the tree and the number that is being compared to
    public NodeType<T> insert(NodeType<T> root, T item){
        if(root == null){//this if statment only runs if the root of the tree is null.
            NodeType node = new NodeType();

            node.info = item;
            node.left = null; 
            node.right = null; 

            return node;

        } else {
            //These if statments compares item to be inserted with the root of the item and assignes based on the comparison
            if(item.compareTo(root.info) == 0){

                System.out.println("The item already exists");
                return root;

            }else if(item.compareTo(root.info) < 0){

                root.left = insert(root.left, item);

            } else {
                root.right = insert(root.right, item);
            } 
            
            
            return root;
            
        }

    }

        //method to print the tree inorder.
        public void inOrder(NodeType<T> root){
        //if statement that runs until root is not equal to null. Recursion is being used so no while loop is needed.
        if(root != null){
            inOrder(root.left);
            System.out.print(root.info + " ");
            inOrder(root.right);
        }
       

    }

    //This method is the search method that returns true if the item is found on the list and false otherwise.
    public boolean retrieve(NodeType<T> root, T item){
        //this means if the root is empty then it returns null
       if(root == null){
        return false; 

       } else if(item.compareTo(root.info) == 0){//if its the same value then it returns true
        return true;

       } else if(item.compareTo(root.info) < 0){//these else if and else statment recursively traverses through the bst based on the comparison.
            return retrieve(root.left, item);
        } else{
            return retrieve(root.right, item);
        }
       
    }
    
    //method to find the logical predecessor, this is used later in the delete method to delete a node with two children
    //this method helps with the delete method later to replace the deleting number for temp.
    public NodeType<T> pred(NodeType<T> root){
        //this if statement checks to see if the tree is empty. Even if it has a root node, it also checks to see if the child is empty
        if(root == null){
            return null;

        } else if(root.right== null){
            return root;
        } else {
            return pred(root.right);
        }
    

    }

    //three base cases:
    //1. if it has no children
    //2. if it has one child
    //3. if it has two children
    public NodeType<T> delete(NodeType<T> root, T item){
        if(root == null){

            System.out.println("The number is not present in the list");
        } else if(item.compareTo(root.info) < 0){//searching and traversing through bst
            root.left = delete(root.left, item);
        } else if(item.compareTo(root.info) > 0){//searching and traversing through bst
            root.right = delete(root.right, item);
        } else if(item.compareTo(root.info) == 0){//searching and traversing through bst

            if(root.left == null && root.right == null){//if it has no children
                return null;
            } else if(root.left != null && root.right == null){//if it has one child on root.right
                root = root.left;
            } else if(root.left == null && root.right !=null){//if it has one child on root.left
                root = root.right;

            } else {//if the item is the root of the bst and has two children
                NodeType<T> data = pred(root.left);//logical pred is assigned to data to later switch and recursively delete the node.
                root.info = data.info;
                root.left = delete(root.left, data.info);
            }
        }

        return root; 
    }

    
    //method to get nodes with one child on it
    public NodeType<T> getSingleParent(NodeType<T> root){
      //checks to see if root is null or if the parent has no children;
      
        if(root == null ){
            return null; 
        } else if(root.left == null && root.right !=null){
            System.out.print(root.info + " ");
            return root;
            
        } else if(root.left != null && root.right ==null){
            System.out.print(root.info + " ");
            return root;
        } else{
            NodeType<T> leftSingle = getSingleParent(root.left);
            NodeType<T> rightSingle = getSingleParent(root.right);
            
            if(leftSingle != null){
                return rightSingle;
            } 
            if(rightSingle != null){
                return leftSingle;
            }

        }
        
        return null;

       
    }


    //this method returns and integer value.
    public int getNumLeafNode(NodeType<T> root){
        if(root == null){//if statment to check if bst is empty
            return 0;
        } else if(root.left == null && root.right == null){//if statment to see if there is only one node in tree and count for the last leaf node.
            return 1;
        }else {
            return getNumLeafNode(root.left) + getNumLeafNode(root.right);//since this works with a stack, we can keep track of how many recursive calls are being made.
        }

    }   
    //this method returns an array list containing the cousins of each node.
    public List<NodeType<T>> getCousin(NodeType<T> root, T item){



        List<NodeType<T>> cousins = new ArrayList<>();

        if(root == null){
            return cousins; 
        }

        Queue<NodeType<T>> queue = new LinkedList<>();
        queue.offer(root);

        //this while loop traverses through queue to find the parent of the given item
        while(!queue.isEmpty()){
            int size = queue.size(); 
            boolean Valuefound = false;
            for(int i = 0; i < size; i++){
                NodeType<T> currentPos = queue.poll();

                //this if statment checks if the sibling has been found for the parent.
                if((currentPos.left != null && item.compareTo(currentPos.left.info) == 0)||(currentPos.right != null && item.compareTo(currentPos.right.info) == 0 )) {
                    Valuefound = true;

                } else {//iif not then these else statment will run
                    if(currentPos.left != null){
                        queue.offer(currentPos.left);//queue.offer inserts an item to the back of the queue.
                    }
                    if(currentPos.right !=null){
                        queue.offer(currentPos.right);
                    }
                }
            }

            if(Valuefound){
                if(size == 1){
                    return cousins;
                }else {
                    for(int i = 0; i < size; i++){
                        NodeType<T> cousin = queue.poll(); //queue.poll removes the item from the front of queue.
                        if(cousin != null){
                            cousins.add(cousin);//adds it to the list cousins.
                        }
                        
                    }
                    return cousins;
                }
            } 
            
        }
        return cousins;
    }


  
}



    
