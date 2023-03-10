package Problem_Of_The_day ;
public class Q373_Delete_without_head_pointer {
    
    class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}


//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
         del.data = del.next.data ; // next node ko copy kar do
         del.next = del.next.next ; // aur next node ko delete kar do
    }
}
}
