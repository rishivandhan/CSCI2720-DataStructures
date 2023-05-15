import java.util.Scanner;
import java.io.File;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeDriver{

    public static void main(String[]args) throws Exception{

        Scanner scan = new Scanner(System.in);

        BinarySearchTree<Integer> inttree = new BinarySearchTree<Integer>();
        BinarySearchTree<Double> DoubleTree = new BinarySearchTree<Double>();
        BinarySearchTree<String> StringTree = new BinarySearchTree<String>(); 


        NodeType<Integer> intRoot = inttree.getRoot();
        NodeType<Double> doubleRoot = DoubleTree.getRoot();
        NodeType<String> stringRoot = StringTree.getRoot();


        System.out.print("Enter list type(i - int, d - double, s - string)");
        char DataType = scan.next().charAt(0);
            
        boolean TreeCreated = false;


        if( DataType == 'i'){
                
            
            File file = new File(args[0]);
            Scanner FileScan = new Scanner(file);

            while(FileScan.hasNextInt()){
                int x = FileScan.nextInt();
                intRoot = inttree.insert(intRoot, x); 

            }
            
            TreeCreated = true;
                
           
        } else if (DataType == 'd'){

            File file = new File(args[0]);
            Scanner FileScan = new Scanner(file);

            while(FileScan.hasNextDouble()){
                double x = FileScan.nextDouble();
                doubleRoot = DoubleTree.insert(doubleRoot, x); 

            }

            TreeCreated = true;
                
                
        } else if(DataType == 's'){

            File file = new File(args[0]);
            Scanner FileScan = new Scanner(file);

            while(FileScan.hasNext()){
                String x = FileScan.next();
                stringRoot = StringTree.insert(stringRoot, x); 

            }

            TreeCreated = true;
                
                
        }


        System.out.println("Commands: ");
        System.out.println("(i) - Insert Item");
        System.out.println("(d) - Delete Item");
        System.out.println("(p) - Print Tree");
        System.out.println("(r) - Retrieve Item");
        System.out.println("(l) - Count Leaf Nodes");
        System.out.println("(s) - Find Single Parents");
        System.out.println("(c) - Find Cousins");
        System.out.println("(q) - Quit Program");

        boolean play = true;

        while(play){

        
        Scanner UIinput = new Scanner(System.in);
        System.out.print("Enter a Command: ");
        char command = UIinput.next().charAt(0);
        


       
        if(TreeCreated == true){
           
            switch(command){

                case 'i':{
                   
                    if(DataType == 'i'){
                        System.out.print("in-order: ");
                        inttree.inOrder(intRoot);
                        System.out.print("\nEnter a number to insert: ");
                        int userNumber = scan.nextInt();
                        inttree.insert(intRoot,userNumber);
                        System.out.print("In-order: ");
                        inttree.inOrder(intRoot);
                        System.out.print("\n");

                    } else if(DataType == 'd'){
                        System.out.print("in-order: ");
                        DoubleTree.inOrder(doubleRoot);
                        System.out.print("\nEnter a number to insert: ");
                        double userNumber = scan.nextDouble();
                        DoubleTree.insert(doubleRoot,userNumber);
                        System.out.print("In-order: ");
                        DoubleTree.inOrder(doubleRoot);
                        System.out.print("\n");

                    } else if(DataType ==  's'){
                        System.out.print("in-order: ");
                        StringTree.inOrder(stringRoot);
                        System.out.print("\nEnter a string to insert: ");
                        String userNumber = scan.next();
                        StringTree.insert(stringRoot,userNumber);
                        System.out.print("In-order: ");
                        StringTree.inOrder(stringRoot);
                        System.out.print("\n");
                    }

                  break;   
                } 
                case 'd':{
                    
                    if(DataType =='i'){
                        System.out.print("In-Order:"); 
                        inttree.inOrder(intRoot);
                        System.out.print("\nEnter a number to delete: ");
                        int deleteVal = scan.nextInt();
                        inttree.delete(intRoot, deleteVal);
                        System.out.print("In-order: ");
                        inttree.inOrder(intRoot);
                        System.out.print("\n");

                    } else if(DataType == 'd'){
                        System.out.print("In-Order:"); 
                        DoubleTree.inOrder(doubleRoot);
                        System.out.print("\nEnter a number to delete: ");
                        double deleteVal = scan.nextDouble();
                        DoubleTree.delete(doubleRoot, deleteVal);
                        System.out.print("In-order: ");
                        DoubleTree.inOrder(doubleRoot);
                        System.out.print("\n");

                    } else if(DataType == 's'){
                        System.out.print("In-Order:"); 
                        StringTree.inOrder(stringRoot);
                        System.out.print("\nEnter a string to delete: ");
                        String deleteVal = scan.next();
                        StringTree.delete(stringRoot, deleteVal);
                        System.out.print("In-order: ");
                        StringTree.inOrder(stringRoot);
                        System.out.print("\n");


                    }
                    break;
                } 
                case 'p':{
                    
                    if(DataType == 'i'){
                        System.out.print("In-Order: ");
                        inttree.inOrder(intRoot);
                        System.out.print("\n");
                    } else if(DataType == 'd'){
                        System.out.print("In-Order: ");
                        DoubleTree.inOrder(doubleRoot);
                        System.out.print("\n");
                
                    } else if(DataType == 's'){
                        System.out.print("In-order: ");
                        StringTree.inOrder(stringRoot);
                        System.out.print("\n");
                   }


                    break; 
                }
                case 'r':{
                    
                    if(DataType == 'i'){
                        System.out.print("In-order: ");
                        inttree.inOrder(intRoot);

                        System.out.print("\nEnter a number to search: ");
                        int searchNumber = scan.nextInt();
                        boolean found = inttree.retrieve(intRoot, searchNumber);
                        
                        if(found){

                            System.out.println("Item is present in tree");

                        }else{
                            System.out.println("Item is not present in tree");
                        }

                    } else if(DataType == 'd'){
                        System.out.print("In-order: ");
                        DoubleTree.inOrder(doubleRoot);

                        System.out.print("\nEnter a number to search: ");
                        double searchNumber = scan.nextDouble();
                        boolean found = DoubleTree.retrieve(doubleRoot, searchNumber);
                        
                        if(found){

                            System.out.println("Item is present in tree");

                        }else{
                            System.out.println("Item is not present in tree");
                        }

                    } else if(DataType == 's'){
                        System.out.print("In-order: ");
                        StringTree.inOrder(stringRoot);

                        System.out.print("\nEnter a string to search: ");
                        String searchNumber = scan.next();
                        boolean found = StringTree.retrieve(stringRoot, searchNumber);
                        
                        if(found){

                            System.out.println("Item is present in tree");

                        }else{
                            System.out.println("Item is not present in tree");
                        }

                    }
                    break;
                }
                case 'l':{
                    if(DataType =='i'){
                        int countLeaf = inttree.getNumLeafNode(intRoot);
                        System.out.print("The number of leaf nodes are " + countLeaf + "\n");

                    } else if(DataType == 'd'){
                        int countLeaf = DoubleTree.getNumLeafNode(doubleRoot);
                        System.out.print("The number of leaf nodes are " + countLeaf + "\n");

                    }else if(DataType == 's'){
                        int countLeaf = StringTree.getNumLeafNode(stringRoot);
                        System.out.print("The number of leaf nodes are " + countLeaf + "\n");



                    }
                    
                    break;
                }
                case 's':{
                    
                    if(DataType == 'i'){
                        System.out.print("Single Parents: ");
                        inttree.getSingleParent(intRoot);
                        System.out.print("\n");
                    } else if(DataType == 'd'){
                        System.out.print("Single Parents: ");
                        DoubleTree.getSingleParent(doubleRoot);
                        System.out.print("\n");
                    } else if(DataType == 's'){
                        System.out.print("Single Parents: ");
                        StringTree.getSingleParent(stringRoot);
                        System.out.print("\n");
                    }
                    break;
                }
                case 'c':{
                    if(DataType == 'i'){
                        System.out.print("In-Order:");
                        inttree.inOrder(intRoot);

                        System.out.print("\nEnter a number: ");
                        int value = scan.nextInt();

                        List<NodeType<Integer>> cousins = inttree.getCousin(intRoot, value);
                        
                        if(cousins.isEmpty()){

                            System.out.print(value + " cousins: ");
                        } else {
                            System.out.print(value + " cousins: ");
                            for(int i = 0; i < cousins.size(); i++){
                                NodeType<Integer> cousin = cousins.get(i);
                                System.out.print(cousin.info + " ");
                            }
                        }
                        System.out.print("\n");
                    } else if(DataType == 'd'){
                        System.out.print("In-Order:");
                        DoubleTree.inOrder(doubleRoot);

                        System.out.print("\nEnter a number: ");
                        double value = scan.nextDouble();

                        List<NodeType<Double>> cousins = DoubleTree.getCousin(doubleRoot, value);
                        
                        if(cousins.isEmpty()){

                            System.out.print(value + " cousins: ");
                        } else {
                            System.out.print(value + " cousins: ");
                            for(int i = 0; i < cousins.size(); i++){
                                NodeType<Double> cousin = cousins.get(i);
                                System.out.print(cousin.info + " ");
                            }
                        }
                        System.out.print("\n");
                    } else if(DataType == 's'){
                        System.out.print("In-Order: ");
                        StringTree.inOrder(stringRoot);

                        System.out.print("\nEnter a string: ");
                        String value = scan.next();

                        List<NodeType<String>> cousins = StringTree.getCousin(stringRoot, value);
                        
                        if(cousins.isEmpty()){

                            System.out.print(value + " cousins: ");
                        } else {
                            System.out.print(value + " cousins: ");
                            for(int i = 0; i < cousins.size(); i++){
                                NodeType<String> cousin = cousins.get(i);
                                System.out.print(cousin.info + " ");
                            }
                        }
                        System.out.print("\n");
                    }
                    break; 
                }
                case 'q':{

                    System.out.println("Exiting the Program...");
                    play = false; 
                    System.exit(0);
                    break;
                }
            }
        }

        }
         


    }
}