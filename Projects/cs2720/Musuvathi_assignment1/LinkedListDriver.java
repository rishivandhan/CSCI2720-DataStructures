import java.util.Scanner;
import java.io.File; 




public class LinkedListDriver
{
    public static void main(String []args) throws Exception{
       
        SortedLinkedList list = new SortedLinkedList();

        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        Scanner UI = new Scanner(System.in);
        Scanner MergeListUI = new Scanner(System.in);
       
        
        while(scan.hasNextInt()){
            
            int x= scan.nextInt(); 
            ItemType item = new ItemType(x);
            item.initialize(x); 
            list.insertItem(item);
            
        }

       while(true)
       {
        char Command;
        
        System.out.println("");
        System.out.print("Enter a Command:");
        Command = UI.next().charAt(0);
        

        switch(Command){
            
            //switch case for insert command;
            case 'i':{
                String Number; 
                System.out.print("Enter a number to insert: ");
                Number = UI.nextLine();
                
                

                if(Number.equals("")){
                    Number = UI.nextLine();  

                }

                int insertValue = Integer.parseInt(Number);
                System.out.println("Original list: "); 
            
                list.printlist(); 

                    
                ItemType numType = new ItemType(insertValue);
                list.insertItem(numType);
                System.out.println("");
                
                System.out.print("New List: "); 
                list.printlist(); 
                System.out.println("");
                break; 
                
            }
            case 'd':{
                System.out.print("Enter a number to delete:");
                int Number = UI.nextInt();
                System.out.print("Original list: "); 
                list.printlist();
                
                ItemType enter = new ItemType(Number);
                list.deleteItem(enter);
                System.out.println("");
                System.out.print("New list: "); 
                list.printlist();

                break; 
            }

            case 's':{
                System.out.print("Enter a number to search:");
                int number = UI.nextInt();
                
                ItemType num = new ItemType(number);
                System.out.print("Original list: "); 
                
                list.printlist(); 
                list.searchItem(num);

                break;
            }

            case 'p':{
                System.out.print("The list is: ");
                list.printlist();
                break;
            }

            case 'n':{
               
                list.getNextItem(); 
                break; 
                

            }

            case 'r':{
                list.resetList();
                break; 
            
            }

            case 'm':{

                boolean donePrinting = true; 
                System.out.print("Enter the length of the new list:");
                int newListLength = MergeListUI.nextInt();
                SortedLinkedList linkListTwo = new SortedLinkedList(); 
                

                System.out.print("Enter the Numbers:");
                
                for(int i = 0; i < newListLength; i++){

                    int newNumbers = MergeListUI.nextInt();
                    ItemType item = new ItemType(newNumbers);
                    if(donePrinting){
                        System.out.print("list 1: ");
                        list.printlist(); 
                        System.out.println("");
                        donePrinting = false; 
                    }
                    item.initialize(newNumbers);
                    list.insertItem(item);
                    linkListTwo.insertItem(item);
                    
                }  


                
                System.out.print("List 2: ");
                linkListTwo.printlist(); 
                System.out.println("");
                System.out.print("Merged List: "); 
                list.printlist();
                System.out.println("");


               
                break; 
            }

            case't': {

                System.out.print("Enter the length of the new list: ");
                int lengthNewList =MergeListUI.nextInt(); 
                SortedLinkedList linkListThree = new SortedLinkedList(); 
                
                System.out.print("Enter the numbers: ");
                for(int i = 0; i < lengthNewList; i++){
                    
                    int listNumbers = MergeListUI.nextInt();
                    ItemType item = new ItemType(listNumbers);
                    item.initialize(listNumbers);
                    linkListThree.insertItem(item);
                }

                list.intersection(linkListThree.getHead());
                break; 
            }

            case 'a':{
                System.out.print("Original List: ");
                list.printlist(); 
                System.out.println("");
                System.out.print("New List: ");
                list.deleteAltNodes(); 
                list.printlist(); 
                
                break; 

            }

            case 'l':{
                System.out.print("The length of the list is: ");
                list.getLength();
            }

            case 'q':{
                System.out.println("Exiting the Program...");
                System.exit(0);
            }
            
            default:{
                System.out.println("Invalid Command try again");
            }
        }
           

     

        }
       
        
        

        


        
      

        
    }
}



