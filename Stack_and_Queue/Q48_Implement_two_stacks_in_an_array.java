package Stack_and_Queue;

public class Q48_Implement_two_stacks_in_an_array {

    class TwoStack
{

	int size;
	int top1,top2;
	int arr[] = new int[100];

	TwoStack()
	{
		size = 100;
		top1 = -1; // stack 1 top starts from 0
		top2 = size; // and stack 2 start from size.
	}
}

    class Stacks
{
    //Function to push an integer into the stack1.
    void push1(int x, TwoStack sq)
    {
        sq.arr[++sq.top1] = x ;
    }

    //Function to push an integer into the stack2.
    void push2(int x, TwoStack sq)
    {
         sq.arr[--sq.top2] = x ;
    }

    //Function to remove an element from top of the stack1.
    int pop1(TwoStack sq)
    {
        if(sq.top1 == -1){
            return -1 ;
        }
         return sq.arr[sq.top1--] ;
    }

    //Function to remove an element from top of the stack2.
    int pop2(TwoStack sq)
    {
        if(sq.top2 == sq.size){
            return -1 ;
        }
        return sq.arr[sq.top2++] ;
    }
}
    
}
