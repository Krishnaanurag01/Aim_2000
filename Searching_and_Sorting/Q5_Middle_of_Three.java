package Searching_and_Sorting;

public class Q5_Middle_of_Three {
    public static void main(String[] args) {
        System.out.println(getMiddleElement(400, 321, 2321));
    }
    public static int getMiddleElement(int A , int B , int C) {
        if(A < B && A > C){
            return A;
        }
        else if( B < C && A < B){
            return B;
        }
        else{
            return C;
        }
    }
}
