import java.util.Scanner;
import java.util.Random; 

public class UserInterface{

    public static void main(String[] Args){

        Scanner UI = new Scanner(System.in);
        Random rand = new Random();
        SortingAlg sortingAlg = new SortingAlg();


        System.out.print("Enter the input size: ");
        int n = UI.nextInt();

        int [] newArray = new int[n];

        for(int i = 0; i < newArray.length; i++){
            newArray[i] = i+1;

        }


        for(int i = newArray.length -1; i > 0; i--){
            int index = rand.nextInt(i+1);
            int temp = newArray[index];
            newArray[index] = newArray[i];
            newArray[i] = temp;
        }

    

        Scanner scan = new Scanner(System.in);
        System.out.println("Selection Sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q) quick-sort-rp (r)");
        System.out.println("Enter the algorithm: ");
        char algo = scan.next().charAt(0);

        if(algo == 's'){
           
           
            int Comparison = sortingAlg.SelectionSort(newArray);
            sortingAlg.print(newArray);
            System.out.println("\n#Selection-Sort Comparison: " + Comparison);
            return;
        }
        else if(algo =='m'){
            
           
            sortingAlg.MergeSort(newArray, 0, newArray.length -1 );
            sortingAlg.print(newArray);
            System.out.print("\n#Merge-Sort Comparison: ");
            sortingAlg.printMergeComparison(); //method being called here to print out the number of comparisons done in mergesort
            return;

        }else if(algo == 'h'){
            
           sortingAlg.HeapSort(newArray, newArray.length );
            sortingAlg.print(newArray);

            System.out.print("\n#Heap-Sort Comparison: ");
            sortingAlg.printHeapComparison();//method being called here to print out the number of comparisons done in heapsort

            return;
        }else if(algo == 'q'){
            
            int comparisons = sortingAlg.quickSortFP(newArray, 0, newArray.length -1 );
            sortingAlg.print(newArray);
            System.out.print("\n#Quick-Sort-fp Comparison: ");
            
            System.out.println(comparisons);
            //call method here
            return;

        }else if(algo == 'r'){
            
           
            int comparisons = sortingAlg.quickSortRP(newArray, 0, newArray.length -1); 
            sortingAlg.print(newArray);   
            System.out.print("\n#Quick-Sort-rp Comparison: ");
            
            System.out.println(comparisons);
            
            //call method here
            return;

        }



    }
}