Name: Rishivandhan Musuvathi Senthil Kumar
UGA ID: 811756852
UGA Mail: rm43733@uga.edu

To compile:
javac LinkedListDriver.java 

To run:
java LinkedListDriver input.txt


Merge Operation:
pseudocode:
-The merge operation is performed in the driver class.
-first a boolean variable "donePrinting" is set true which is
set to check if everything is done printing onto the terminal
-Since Merge item involves the user in inputing different numbers given
the length, a for loop is built that loops until the i = length which allows
the user to insert the numbers into a new SortedLinkList 'linklisttwo' and SortedLinkList 'list'.
- The same methods, initialize and insertItem are being used to sort and check for
duplicates in the SortedLinkList 'list', finally returning the merged list as a new sorted and merged list.

-COMPLEXITY OF THE BIG O:
this merge operation has a big(o) complexity of bigO(n) because it uses the other functions, insert and initlize which is also 
a bigO(n).

Intersection Operation:
pseudocode:
-the intersection operation uses two nested while loops to traverse between two lists.
- the first list being the given list while the second list being the user given numbers
-since the while loop is nested inside another while loop, its going to compare the first node of the given list to all the nodes
of the user given list. if the first node of the given list is equal to any numbers that are in the usergiven list, then the value will be
printed out. once the inside loop is done comparing with the outer loop, the NodeType secCurr resets to the head so that the outer loop updates
to the next node and then comares with eveynode in the inner loop.
-this process will be repeated until the outer loop node eqals to null, meaning that there are no other values after the last node.
- the intersected values will be printed out.

-COMPLEXITY OF THE BIG O:
this Intersection Operation has a big(o) complexity of bigO(n^2) because it is a nested loop which multiplies the outer loop with inner loop



