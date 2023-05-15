import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Random;

public class SortDriver {

    public static void main(String[] args) throws Exception {
        
        SortingAlg sortingAlg = new SortingAlg();


        Scanner scan = new Scanner(System.in);
        System.out.println("Selection Sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q) quick-sort-rp (r)");
        System.out.print("Enter the algorithm: ");
        char algo = scan.next().charAt(0); //what type of algorithm

        File file =new File(args[0]);
        Scanner fileScan = new Scanner(file);
        int counter = 0;

        
        
        
        while(fileScan.hasNextInt()){
            counter++;//counter variable used here to keep track of the length 
            fileScan.nextInt();
        }
        int[] array = new int[counter];

        Scanner insertScan = new Scanner(file);
        while(insertScan.hasNextInt()){
            for(int i = 0; i < array.length; i++){
                array[i] = insertScan.nextInt();
            }
        }

        

        if(algo == 's'){
           
           
            int Comparison = sortingAlg.SelectionSort(array);
            sortingAlg.print(array);
            System.out.println("\n#Selection-Sort Comparison: " + Comparison);
            return;
        }
        else if(algo =='m'){
            
           
            sortingAlg.MergeSort(array, 0, array.length -1 );
            sortingAlg.print(array);
            System.out.print("\n#Merge-Sort Comparison: ");
            sortingAlg.printMergeComparison(); //method being called here to print out the number of comparisons done in mergesort
            return;

        }else if(algo == 'h'){
            
            sortingAlg.HeapSort(array, array.length );
            sortingAlg.print(array);

            System.out.print("\n#Heap-Sort Comparison: ");
            sortingAlg.printHeapComparison();//method being called here to print out the number of comparisons done in heapsort

            return;

        }else if(algo == 'q'){
            
            int comparisons = sortingAlg.quickSortFP(array, 0, array.length -1 );
            sortingAlg.print(array);
            System.out.print("\n#Quick-Sort-fp Comparison: ");
            
            System.out.println(comparisons);
            //call method here
            return;

        }else if(algo == 'r'){
            
           
            int comparisons = sortingAlg.quickSortRP(array, 0, array.length -1); 
            sortingAlg.print(array);   
            System.out.print("\n#Quick-Sort-rp Comparison: ");
            
            System.out.println(comparisons);
            
            //call method here
            return;

        }

       
    }


}
