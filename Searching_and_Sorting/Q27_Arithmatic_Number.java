package Searching_and_Sorting;

public class Q27_Arithmatic_Number {

    public static void main(String[] args) {
        
    }

    public static int inSequence(int A, int B, int C){

        if( C == 0 && A != B){
            return 0;
        }
        else if(C==0 && A==B){
            return 1;
        }
        else if(C < 0 && B > A){
            return 0 ;
        }
        else if( C > 0 && B < A){
            return 0;
        }
        
        if(Math.abs(B-A)%C != 0)
        return 0;
        
        return 1;
    }
    
}
