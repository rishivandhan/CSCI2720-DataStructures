public class DoublyLinkedList<T extends Comparable<T>>{

    //all the functions that needs to be implemented goes here
    private NodeType<T> head; 
    private NodeType<T> tail; 
    private int length;
    

    //constructor for doubly linked list;
    public DoublyLinkedList(){
        this.head = null; 
        this.tail = null;
        
        
    }

    


    //method to insertItem. Itemtype class not required becaue we are using generics.
    //inserting in the middle doesnt work with strings
    public void insertItem(T item){
        length++;
        NodeType<T> node = new NodeType<T>();
        node.info = item;
        node.next = null; 
        node.back = null; 

        NodeType<T> tranverse = head;
        while(tranverse != null && tranverse.info.compareTo(item) < 0){
            tranverse = tranverse.next;

        }
        
        NodeType<T> itemchecker = head; 
        while(itemchecker != null){
            if(node.info.compareTo(itemchecker.info) == 0){
                System.out.print("Item already exists\n");
                return;
            }
            itemchecker = itemchecker.next;
        }

       

    
        if(head == null){//checking to see if the list is empty
            
            head = node;
            tail = node;
            return;


        }else if(item.compareTo(head.info) < 0){
            //to insert in the begining
            node.next = head; 
            head.back = node;
            head = node;
            return;
        } else if(item.compareTo(tail.info) > 0){
            //to inserti in the end
            tail.next = node;
            node.back = tail;
            tail = node;
            return;
        }else {

            NodeType<T> temp= tranverse.back;
            
            
            temp.next = node;
            node.back = temp;
            node.next = tranverse;
            tranverse.back = node;
            

        }

        
        
    }


    //delete method    
    public void deleteItem(T item){

        //delete doesnt work with strings. returns item not found;
       //checking to see if the list is empty
        if(head == null){
            System.out.println("You cannot delete from an empty list");
            

        }

        boolean isDeleted = false;
        NodeType<T> currentPos = head;//to traverse through the doubly linked list
        while(currentPos != null){


            if(currentPos.info.compareTo(item) == 0){

                //if statement checking to see if it is in front;
                if(currentPos == head){
                    head = currentPos.next;

                    if(head != null){
                        head.back = null; 
                    }
                //if statement checking to see if it is in the back;
                } else if (currentPos == tail){
                    tail = currentPos.back;
                    if(tail != null){
                        tail.next = null; 
                    }
                } else {

                    //if not in the front or the back;
                    currentPos.back.next = currentPos.next;
                    currentPos.next.back = currentPos.back;


                }

                length--; //length -- because we are removing a node from the list;
                isDeleted = true;
                return;
            }

            currentPos = currentPos.next;
        }

        if(!isDeleted){
            
            System.out.println("The item is not present in the list");

        }
        


    }



    //getLength method;
    public int getLength(){
        NodeType<T> tempNode = head;
        int counter = 0;
        while(tempNode != null){
            counter++;
            tempNode = tempNode.next;

        }
        
        System.out.print(counter);
        return counter;
    }



    public void print(){
        //first check to see if the list is empty:
        if( head == null){
            System.out.println("The list is empty");

        } else{ 

            NodeType<T> tempNode = head;
            while(tempNode != null){
                System.out.print(tempNode.info + " ");
                tempNode = tempNode.next;
            }
        }
        

    
    }


    public void printReverse(){

        //this method only printing out the reverse order. not modifying the actual list

        NodeType<T> currentPos = tail;
        while(currentPos != null){
            System.out.print(currentPos.info + " ");
            currentPos = currentPos.back; 

        }
    }


    public void delteSubsection(T lower, T upper){
        
        NodeType<T> first;
        if(head == null){
            return;

        }
        if(head.info.compareTo(upper) > 0){

            return;
        }

        if(tail.info.compareTo(lower) < 0){

            return;
        }

        first= head; 

        while(first != null && first.info.compareTo(lower) < 0){
            first = first.next;
        }

        if(first != null)
        {

            if(first.back == null && first.next == null){

                head = null; 
                tail = null; 
                first = null; 
                return;


            } else if(first.back == null){

                head = head.next; 
                head.back = null; 
                first = null;
                delteSubsection(lower, upper);
                return;
            }else if( first.next == null){
                tail = tail.back;
                tail.next = null; 
                first = null;
                return; 
            } else{
                NodeType<T> point= tail;
                while(point != null && point.info.compareTo(upper) > 0)
                {
                    point = point.back;
                }

                if(point.next == first){
                    return;
                }else { 
                    first.back.next = point.next; 
                    if(point.next != null){
                        point.next.back = first.back;
                    }
                    NodeType<T> t;
                    while(first != point){
                        t= first; 
                        first = first.next;
                        t = null;
                    }
                    first= null; 
                }
                return; 
            }
        }
    }


    public void reverseList(){
        //create  a new list in main to store the reverse list;
        //this method reverses the list;
        NodeType<T> tempNode = null;
        NodeType<T> currentPos = head;

            
        while(currentPos != null){
            tempNode = currentPos.back;
            currentPos.back = currentPos.next;
            currentPos.next = tempNode;
            currentPos = currentPos.back;

        }

        if(tempNode != null){

            head = tempNode.back;

        }

        
        
        //reversing list
    }


    public void swapAlternate(){

        if(head == null || tail == null){
            return;
        }
        //nodes created here
        NodeType<T> currentPos = head;
        NodeType<T> previousPos = null; 

        //while loop traverses the list while performing the algorithm to swap.
        while( currentPos != null && currentPos.next != null){
            NodeType<T> tempNode = currentPos.next;
            currentPos.next = tempNode.next;
            if(tempNode.next != null){
                tempNode.next.back = currentPos;
            }
            tempNode.next = currentPos;
            currentPos.back = tempNode;

            if(previousPos == null){
                head = tempNode; 
                tempNode.back = null;
            } else{
                previousPos.next = tempNode;
                tempNode.back = previousPos;

            }

            previousPos = currentPos;
            currentPos = currentPos.next;
        }
        if(currentPos == null){
            tail = previousPos;
        }

    }

}