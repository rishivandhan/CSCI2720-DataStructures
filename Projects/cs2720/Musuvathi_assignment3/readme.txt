Name: Rishivandhan Musuvathi
UGA Mail: rm43733@uga.edu
UGA ID: 811756852

How to compile and run code:

Compile:
javac BinarySearchTreeDriver.java

To run compiled file (input.txt):
java BinarySearchTreeDriver.java int-input.txt 

To run compiled file (double.txt):
java BinarySearchTreeDriver.java double-input.txt 

To run compiled file (string.txt):
java BinarySearchTreeDriver.java string-input.txt 

Time complexity of code:

getSingleParent: 
* The main purpose of this method is return Nodes in the Binary Search tree that has only one child. The time complexity 
of this method is O(N) because this recursive method meets each node in the binary search tree to find the node with a single child.
The base cases for this methods are if the root of the bst is null, if the parent node's left child is null and if there is a value
on the parent's right child, if the parent's left child has a value and parent's right child is null. 
However if the the parent has two child, then it goes to the recursive case which helps us traverse through the binary search tree to
find a node with single child.

getNumLeafNodes:

* The main purpose of this method is return an integer value of the number of nodes with no children. The time complexity of this method is
also O(N) because in order to cound the number of leaf nodes, we must be able to traverse and visit each node on binary search tree. This is done
by recursively traversing and adding the number of times the method has been called recursively. Since we know that, recursions work on a stack, 
we can later use this to retrun an integer value of how many times the recursive method has been called.

getCousins: 

* The main purpose of this method is to return the cousin of any given item on the binary search tree. This was accomplished by first coming to a conclusion
that this method must return a list of all the cousins found in the binary search tree. This method uses Queues with the binary search tree to find the parent of
any given item. Once a queue is created, we define and integer value size that keeps track of the size of queue. We will be then traversing through the queue by using
the size of the queue and the for loop. After each itteration throught the queue, we keep track of the current position (currentPos) while comparing the given item to the 
currentPos on the left side and the right side. If none of these items matches, we then push into the queue the next itterative queue call (queue.offer). Once Eventually we find
the item, we then use the queue to retrieve the parent and recursively find the cousin of the given item in the bianry search tree.
This method has a time complexity of O(n) because we traversed through the entire binary search tree to find the item.