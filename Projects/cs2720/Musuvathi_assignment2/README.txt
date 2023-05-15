Name: Rishivandhan Musuvathi
UGA ID:811756852

How to compile and run:
1. To compile code:
    - javac doublylinkedlist.java

2. To run code:
    -int data Type: java doublylinkedlist int-input.txt
    -double data type: java doublylinkedlist double-input.txt
    -string data type: java doublylinkedlist string-input.txt

    

Delete Subsection function:
-This method lets users delete a section of the list given the
lower bound and upper bound for any type of data type (generics).
-first the code checks to see if the doublylinkedlist is empty by checking
the head node. if the head node is null, then the list is empty
-then there are two if statements that set the lowerbound and the upperbound
based on the given lowerbounds and upperbounds. This uses the compareTo class
that compares each value on the list with the bounds. if the compareTo method 
sees that the value is lower(i.e. if the value is greater than 0), then it sets
the upperbound to the value. Same thing goes for the lowerbound.
-Once the lowerbound and the upperbound is set, the while loop is used to traverse
through this list to perform an algorithm that points the starting node to the ending node
- This function uses a recursive call to consequently point the previous node depending
on the lower and upperbounds
-The time complexity of this function is bigO(n) because since there is an itereation of n decreasing
in a linear amount of time.

ReverseList Method:
-This method lets users to reverse any data type given list(generics)
- First, two Nodes of NodeType Generics class is being created. One pointing to head
while the other pointing to null
- using the node pointing to head(currentPos), we can traverse the list by calling
currentPos.next.
-inside the list we are performing an algorithm that reverses each node
and makes it so that it points to the next node using tempnodes.
-The time complexity of this code will be bigO(1) because we are only assigning eachnode to another


SwapAlt Method:
-in this method, two nodes are created again.
-With the use of one of the nodes,we can traverse the list
- inside this while loop, there are two if statements that checks to sees
if the tempnode.next is ever going to be null. These two statemetns assign and point to the
previous and the next node to swap between each node.
- if none of these else statements are true, then to traverse the list the next node and the previoius node is assigned 
and checked again.
-The bigO complexity for this function will be constant time beacause we are only assigning and
pointing to previos and next node to perform the swapAlt method on any list.
