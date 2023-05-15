//not reading through sting file properly


import java.util.Scanner;
import java.io.File; 



public class DoublyLinkedListDriver {

    public static void main(String[]args) throws Exception{
        
        Scanner scan = new Scanner(System.in); //scanner class used for arguments passed with compiler
        Scanner UI = new Scanner(System.in); //Scanner class takes in UserInput: i, d, s;
       
        //all the lists are initilialized and declared outside to recognized
        DoublyLinkedList<Integer> intlist = new DoublyLinkedList<>();
        DoublyLinkedList<Double> doublelist = new DoublyLinkedList<Double>();  
        DoublyLinkedList<String> stringlist = new DoublyLinkedList<String>();  


        //reverse lists;
        DoublyLinkedList<Integer> reverseint = new DoublyLinkedList<>();
        DoublyLinkedList<Double> reversedouble = new DoublyLinkedList<Double>();  
        DoublyLinkedList<String> reversestring = new DoublyLinkedList<String>(); 
        


       
        

        System.out.print("Enter List Type: (i -int, d -double, s - std:strings)");
        char DataTypeChar = scan.next().charAt(0);
        

        boolean listCreated = false;

        if(DataTypeChar == 'i'){

            File file = new File(args[0]);
            Scanner FileScan = new Scanner(file); //scanner class to scan through file;
            

            //while loop reads through the integer file;
            while(FileScan.hasNextInt()){
                int x = FileScan.nextInt();
                intlist.insertItem(x); 
               
                    
                
            }
               
            listCreated = true;
            


        } else if (DataTypeChar == 'd'){
            File file = new File(args[0]);
            Scanner FileScan = new Scanner(file);

            //while loop reads through the integer file;
            while(FileScan.hasNextDouble()){
               
                double x = FileScan.nextDouble();
                doublelist.insertItem(x);
               
                
                
            }
        
            listCreated = true;
            




        } else if(DataTypeChar == 's'){
            File file = new File(args[0]);
            Scanner FileScan = new Scanner(file); 

            //not reading though the file properly - length = 1;
            //while loop reads through the integer file;
            while(FileScan.hasNext()){
               
                String x = FileScan.next();
                stringlist.insertItem(x); 
                
                
                    
                
            }
               
            listCreated = true;
            

        }
 

        listCreated = true; 
        System.out.println("Commands:");
        System.out.println("(i) - Insert Value");
        System.out.println("(d) - delete Value");
        System.out.println("(p) - print list");
        System.out.println("(l) - Length");
        System.out.println("(t) - Print Reverse");
        System.out.println("(r) - Reverse List");
        System.out.println("(b) - Delete Subsection");
        System.out.println("(s) - Swap Alternate");
        System.out.println("(q) - quit program");
        

        while(true){
        System.out.print("\nEnter a Command: ");
        char command = UI.next().charAt(0);

        Scanner s = new Scanner(System.in);
        boolean play = true;
        

        
        if(listCreated == true){
            switch(command){

            case 'i':{
                
                if(DataTypeChar == 'i'){
                    System.out.print("The list is: ");
                    intlist.print();

                    
                    System.out.print(" \nEnter a number to insert: ");
                    int intinput = s.nextInt();
                    intlist.insertItem(intinput);
                    System.out.print("The list is: ");
                    intlist.print(); 
                    System.out.print("\nThe reverse list: ");
                    intlist.printReverse();
                   //printreverse method called here 
                    
                } else if(DataTypeChar == 'd'){
                    System.out.print("The list is: ");
                    doublelist.print();

                    
                    System.out.print(" \nEnter a number to insert: ");
                    double doubinput = s.nextDouble();
                    doublelist.insertItem(doubinput);
                    System.out.print("The list is: ");
                    doublelist.print();
                    System.out.print("\nThe reverse list: ");
                    doublelist.printReverse();
                   //printreverse method called here 

              
                }else if(DataTypeChar == 's'){
                    //cannot put in the middle
                    //cannot put in the beginining
                    System.out.print("The list is: ");
                    stringlist.print();
                    System.out.print(" \nEnter a string to insert: ");
                    String name = s.next();
                    stringlist.insertItem(name);
                    System.out.print("The list is: ");
                    stringlist.print();
                    System.out.print("\nThe reverse list: ");
                    stringlist.printReverse();
                     //printreverse method called here 
                    
                    


                    


                }
 

                //insert case
                break;
            }

            case 'd':{
                if(DataTypeChar == 'i'){
                    System.out.print("The list is: ");
                    intlist.print();
                    
                    System.out.print("\nEnter a number to delete: ");
                    int numbertodelete = s.nextInt();
                    intlist.deleteItem(numbertodelete);
                    
                    System.out.print("The list is: ");
                    intlist.print();
                    System.out.print("\nThe reverse list: ");
                    intlist.printReverse();
                    

                    
                }else if(DataTypeChar == 'd'){
                    System.out.print("The list is: ");
                    doublelist.print();
                    
                    System.out.print("\nEnter a number to delete: ");
                    double decimaltodelete = s.nextDouble();
                    doublelist.deleteItem(decimaltodelete);
                   
                    System.out.print("the list is:");
                    doublelist.print();
                    System.out.print("\nThe reverse list: ");
                    doublelist.printReverse();

                 

                }else if(DataTypeChar == 's'){

                    System.out.print("The list is: ");
                    stringlist.print();
                    
                    System.out.print("\nEnter a string to delete: ");
                    String stringtodelete = s.next();
                    stringlist.deleteItem(stringtodelete);
                   
                    System.out.print("the list is:");
                    stringlist.print();
                    System.out.print("\nThe reverse list: ");
                    stringlist.printReverse();
                  
                }
                //delete case;
                break;
            }

            case 'p':{
               
               if(DataTypeChar == 'i'){
                System.out.print("The list is: ");
                intlist.print();
               } else if( DataTypeChar == 'd'){
                System.out.print("The list is: ");
                doublelist.print();
               }else if(DataTypeChar == 's'){
                System.out.print("The list is: ");
                stringlist.print();
               }
               
               
                break;
            }


            case 'l': {
                System.out.print("The length of the list is ");
                if(DataTypeChar == 'i'){
                    intlist.getLength(); 

                    
                }else if(DataTypeChar == 'd'){
                    
                   doublelist.getLength(); 

                }else if(DataTypeChar == 's'){

                   stringlist.getLength();
                }
                
                break;

            }


            case 't':{ 
                
                System.out.print("The reverse list: ");
                if(DataTypeChar == 'i'){
                    
                    intlist.printReverse();

                } else if(DataTypeChar == 'd'){
                    
                    doublelist.printReverse();
                } else if(DataTypeChar == 's'){
                    

                    stringlist.printReverse();
                }
                break;

                //Print reverse method
               
            }

            case 'r':{

                if(DataTypeChar == 'i'){
                    System.out.print("\nThe original list: ");
                    intlist.print();
                    intlist.reverseList();
                    System.out.println("");
                    System.out.print("The reversed list: ");
                    intlist.print();

                } else if(DataTypeChar == 'd'){
                    System.out.print("\nThe original list: ");
                    doublelist.print(); 
                    doublelist.reverseList();
                    System.out.println("");
                    System.out.print("The reversed list: ");
                    doublelist.print();

                } else if(DataTypeChar == 's'){
                    System.out.print("\nThe original list: ");
                    stringlist.print(); 
                    stringlist.reverseList();
                    System.out.println("");
                    System.out.print("The reversed list: ");
                    stringlist.print();


                }
                break;
            }


            case 'b':{
        
            
                if(DataTypeChar == 'i'){
                    
                    Scanner bounds = new Scanner(System.in);
                    System.out.print("Enter the lower bound: ");
                    int low = bounds.nextInt();

                    System.out.print("Enter the upper bound: ");
                    int upper = bounds.nextInt();
                    System.out.print("The original list: ");
                    intlist.print();

            

                    intlist.delteSubsection(low, upper); 
                    
                    System.out.print("\nThe modified list: ");
                    intlist.print();
                    System.out.print("\nThe reverse list: ");
                    intlist.printReverse();

                }else if(DataTypeChar == 'd'){
                    
                    Scanner bounds = new Scanner(System.in);
                    System.out.print("Enter the lower bound: ");
                    double low = bounds.nextDouble();

                    System.out.print("Enter the upper bound: ");
                    double upper = bounds.nextDouble();
                    System.out.print("The original list: ");
                    doublelist.print();

            

                    doublelist.delteSubsection(low, upper); 
                    
                    System.out.print("\nThe modified list: ");
                    doublelist.print();
                    System.out.print("\nThe reverse list: ");
                    doublelist.printReverse();

                }else if(DataTypeChar == 's'){
                    
                    Scanner bounds = new Scanner(System.in);
                    System.out.print("Enter the lower bound: ");
                    String low = bounds.next();

                    System.out.print("Enter the upper bound: ");
                    String upper = bounds.next();
                    System.out.print("The original list: ");
                    stringlist.print();

            

                    stringlist.delteSubsection(low, upper); 
                    
                    System.out.print("\nThe modified list: ");
                    stringlist.print();
                    System.out.print("\nThe reverse list: ");
                    stringlist.printReverse();

                }
                break;

            }
          

            

            case 's': {
                
                if(DataTypeChar == 'i'){
                    System.out.print("The original list: ");
                    intlist.print(); 

                    intlist.swapAlternate();
                    System.out.print("\nThe modified list: ");
                    intlist.print();
                    System.out.print("\nThe reverse list: ");
                    intlist.printReverse();
                }else if(DataTypeChar == 'd'){
                    System.out.print("The original list: ");
                    doublelist.print(); 

                    doublelist.swapAlternate();
                    System.out.print("\nThe modified list: ");
                    doublelist.print();
                    System.out.print("\nThe reverse list: ");
                    doublelist.printReverse();
                }else if(DataTypeChar =='s'){
                    System.out.print("The original list: ");
                    stringlist.print(); 

                    stringlist.swapAlternate();
                    System.out.print("\nThe modified list: ");
                    stringlist.print();
                    System.out.print("\nThe reverse list: ");
                    stringlist.printReverse();

                }
                 
                    

                break;
             

            }


            case 'q':{

                System.out.println("Exiting the Program...");
                System.exit(0);
                break;
            }

        

            }

        
        }
        }


        
       


    
           
             
             
      
       



    }

}