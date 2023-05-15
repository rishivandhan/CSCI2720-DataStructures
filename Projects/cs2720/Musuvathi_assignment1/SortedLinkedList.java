public class SortedLinkedList{

    private int length;
    private NodeType head;
    private NodeType currentPos;

    public NodeType getHead(){
        return head;
    }
    //sorted link list function starts here
    public void sortedLinkedList(){
        length = 0; 
        head = null;
        currentPos = null;


       

    }
    
    //function that returns the length of the linked list.
    public int getLength(){

        NodeType TempNode = head;
        int i = 0; 
        while(TempNode != null){
            i++;
            TempNode = TempNode.next;
        }
        System.out.println(i);
        return i;

    }


    //Insert item function: General case and Special Case;
    public void insertItem(ItemType item){
        
        length++;
        NodeType NodeTemp = new NodeType(item);
        
        //checks to see if list is empty; if it is empty then adds it to the list
        if (head == null){
            head = NodeTemp;
            return;

        }
        NodeType traverse = head; 

        
        while(traverse != null){
            if(item.getValue() == traverse.item.getValue()){
                System.out.println("");
                System.out.println("Item already Exists");
            }
            traverse = traverse.next;

        }
        NodeTemp.item = item;
        NodeType currentPos = null;  //current node;
        NodeType test = head; 
        //made sure that if item is less than head. 
        //This function is helping with adding the numbers to the list
       
        //this uses the compareTo method from itemType class; 
        if(NodeTemp.item.compareTo(test.item) < 0){

            NodeTemp.next = head;
            head = NodeTemp;
            return;

        }

    
        while(test.next != null){
           
            
            currentPos = test;
            test = test.next;
            //new item is bigger than current node and smaller than previous node;
            if((currentPos.item.getValue() < item.getValue()) && (item.getValue() < test.item.getValue())){
                NodeTemp.next = test; 
                currentPos.next = NodeTemp;
            }

        
        }

        if(test.item.getValue() < item.getValue()){

            test.next = NodeTemp;
        }
       

    }

    //DeteleItem function: General case and special case;
    public void deleteItem(ItemType item){  

       if(head == null){
        System.out.println("List is empty ");
        return;

       }
        //if item was found on the first node;
        if(head.item.getValue() == item.getValue()){

            head = head.next;
            return;
        }


         
        NodeType currentPos = head;
        NodeType previousNode = head;
        boolean isDeleted = false;
        while(currentPos !=null)
        {   
            if(currentPos.item.getValue() == item.getValue())
            {
                previousNode.next = currentPos.next;
                isDeleted = true;
                break;
            }
            else
            {
                 previousNode = currentPos;
                 currentPos = currentPos.next;
            }
        }

        if(!isDeleted)
        {
            System.out.println("");
            System.out.println("Item not found");
        }


    }   




    //function to implement searchItem;
    public int searchItem(ItemType item){
      

        int index = 0;
        boolean isFound = false;

        NodeType currentPos = head; 
        if(currentPos == null){
            System.out.println("");
            System.out.println("The list is empty");
            return -1;
        }
            
       

        while(currentPos !=null){
            index++;

            if(currentPos.item.getValue() == item.getValue()){
                System.out.println("");
                System.out.println("The item is present at " + index);
                isFound = true;
                return index;
            }else {
                currentPos = currentPos.next;
            }
        }

        if(!isFound){
            System.out.println("");
            System.out.println("Item is not present in the list");
            return 0;    
        }
        return 0; 
    }

    public ItemType getNextItem(){
    
      

        if(currentPos == null){
            currentPos = head;
            System.out.println(currentPos.item.getValue());
            currentPos = currentPos.next;
            return currentPos.item;
        }else {
            System.out.println(currentPos.item.getValue());
            currentPos = currentPos.next;
            return currentPos.item;

            
        }

        
    }

    //method to implement imtersection.
    public void intersection(NodeType headNode){
    
       NodeType curr = head;
       NodeType secCurr = headNode;

        System.out.print("Intersection of lists: "); 
       while(curr != null){
         

        while (secCurr != null){
            
            if(curr.item.getValue() == secCurr.item.getValue()){
                System.out.print(curr.item.getValue() + " ");
                break;
            } else {
                secCurr = secCurr.next;
            }
        }
        secCurr = headNode;
        curr = curr.next;
       }

    }   

    //method to delete alternate nodes.
    public void deleteAltNodes(){
        
        int counter =  1;
        NodeType currentPos = head;
        NodeType previousNode = head;
        
        
       
        while(currentPos != null){
            
        if(counter %2 == 0)
        {
            previousNode.next = currentPos.next;
        }
        else
        {
            previousNode = currentPos;
            currentPos = currentPos.next;
        } 

        counter++;
    }
    
        

        


    }

    //method to reset the current position of the list.
    public void resetList(){

        currentPos = head; 
        System.out.println("Iterator is Reset");

       

    }




    //method to print the values in each node.
    public void printlist(){
        NodeType temp = head; 
        
        while(temp != null){
            System.out.print(temp.item.getValue() + " ");
            
            temp = temp.next;
        }
       
    }

}