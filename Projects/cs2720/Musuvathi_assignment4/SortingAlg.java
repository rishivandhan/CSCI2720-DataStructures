import java.util.Stack;
import java.util.Random;


public class SortingAlg{
    
    private int ComparisonMerge = 0; //this is used by the merge and the mergesort method to keep track of the number of comparisons.
    private int ComparisonHeap = 0; //this si used by the heapsort methods to keep track of the number of comparisons done.
    private int ComparisonQuickFP = 0;
    private int ComparisonQuickRP = 0; 
    
    public void print(int[] Array){

        for(int i = 0; i< Array.length; i++){
            System.out.print(Array[i] + " ");
        }
    }
    //selection sort method - retrieved from the powerpoint
    public int SelectionSort(int[] Array){

        int NumberOfComparison = 0; 
        for(int i = 0; i < Array.length; i++){

            int minIndex =i;

            for(int j = i+1; j< Array.length; j++){
                NumberOfComparison++;
                if(Array[j] < Array[minIndex]){
                    
                    minIndex = j;
                }
            }

            int temp = Array[i];
            Array[i] = Array[minIndex];
            Array[minIndex] = temp;
        }

        return NumberOfComparison;


    }
    //MergeSort Method - retrieved from powerpoint.
    public void MergeSort(int[] Array, int first, int last){
        
       if(first < last){

        int middle = (first + last)/ 2;
        MergeSort(Array, first, middle);
        MergeSort(Array, middle + 1, last);


        Merge(Array, first, middle, middle + 1, last);

        
       }

       
    }

    //Merge method - helper method for MergeSort (retrieved from powerpoint)
    public void Merge(int[] Array, int leftFirst, int leftLast, int rightFirst, int rightLast){

        int [] tempArray = new int[Array.length];
        int index = leftFirst;
        int saveFirst = leftFirst;

        while((leftFirst <= leftLast) && (rightFirst <= rightLast)){
            ComparisonMerge++;
            if(Array[leftFirst] < Array[rightFirst]){
                tempArray[index]  = Array[leftFirst];
                leftFirst++;
            }else{
                tempArray[index] = Array[rightFirst];
                rightFirst++;
            }

            index++;
        }
        
        while(leftFirst <= leftLast){
            tempArray[index] = Array[leftFirst];
            leftFirst++;
            index++;
        }

        while(rightFirst <= rightLast){
            tempArray[index]= Array[rightFirst];
            rightFirst++; 
            index++;
        }


        for(index = saveFirst; index <= rightLast; index++){
            Array[index] = tempArray[index];
        }
        

    }

    

    public void HeapSort(int[] Array, int numValues){
        
        for(int index = numValues/2 - 1; index >= 0; index--){
            ReheapDown(Array, index, numValues -1, ComparisonHeap);
        }
        for(int index = numValues -1; index >= 1; index--){

            int temp = Array[0];
            Array[0] = Array[index];
            Array[index] = temp;
            ReheapDown(Array, 0, index -1, ComparisonHeap);
        }

        
    }

    public void ReheapDown(int [] Array, int root, int bottom, int Comparison){
        int maxChild = root * 2 +1;

        int leftChild = root * 2 + 1;
        int rightChild = root * 2 + 2;

        if(leftChild <= bottom){
            
            if(leftChild == bottom){
                maxChild = leftChild;

            } else{
                ComparisonHeap++;
                if(Array[leftChild] <= Array[rightChild]){
                    maxChild = rightChild;
                } else{
                    maxChild = leftChild;
                }
            }
            ComparisonHeap++;
            if(Array[root] < Array[maxChild]){
                
                int temp = Array[root];
                Array[root] = Array[maxChild];
                Array[maxChild] = temp;
                ReheapDown(Array, maxChild, bottom, ComparisonHeap);
            }

            
        }
        
        
    }

 

    // quickSortFP: this is the itterative version using stack; itterative version is being used
    //because the array is too big and the recursive version leads to a stack overflow error.

    public int quickSortFP(int [] Array, int low, int high){
        
        ComparisonQuickFP =0; 
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while(!stack.isEmpty()){
            high = stack.pop();
            low = stack.pop();

            int i = low;
            int j = high;
            int pivot = Array[low];

            while(i <= j ){
                while(Array[i] < pivot){
                    i++;
                    ComparisonQuickFP++;
                }

                while(Array[j] > pivot){
                    j--; 
                    ComparisonQuickFP++;
                }


                if(i <= j){
                    swap(Array, i, j);
                    i++;
                    j--;
                }
            }

            if(low < j){
                stack.push(low);
                stack.push(j);
            }

            if(i < high){
                stack.push(i);
                stack.push(high);
            }

        }

        return ComparisonQuickFP;

    }

    


    public int quickSortRP(int [] Array, int low, int high){
        
        ComparisonQuickRP =0; 
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while(!stack.isEmpty()){
            high = stack.pop();
            low = stack.pop();


            int pivotIndex = new Random().nextInt(high - low) + low;
            int pivot = Array[pivotIndex];  
            int i = low;
            int j = high;
            

            while(i <= j ){
                while(Array[i] < pivot){
                    i++;
                    ComparisonQuickRP++;
                }

                while(Array[j] > pivot){
                    j--; 
                    ComparisonQuickRP++;
                }


                if(i <= j){
                    swap(Array, i, j);
                    i++;
                    j--;
                }
            }

            if(low < j){
                stack.push(low);
                stack.push(j);
            }

            if(i < high){
                stack.push(i);
                stack.push(high);
            }

        }

        return ComparisonQuickRP;

    }




    private void swap(int [] Array, int i, int j){
        int temp = Array[i];
        Array[i] = Array[j]; 
        Array[j] = temp;
    }

    


    
    //printing the number of comparison methods using the private methods:
    public void printMergeComparison(){ //used by mergersort
        System.out.print(ComparisonMerge + "\n");
    }


    public void printHeapComparison(){// used by heapsort.
        System.out.println(ComparisonHeap);
    }
   

   





    

  

}