package Searching_Sorting_level_02;

public class Q12_Max_sum_in_the_configuration {

    int max_sum(int A[], int n)
    {
	// Your code here
	
	int sum = 0 ;
	int S0 = 0 ;
	
    // first calculating the sum and initial sum of Arr[i]*i 
	for(int i = 0 ; i < n ; i++){
	    sum += A[i] ;
	    S0 += A[i]*i ;
	}
	
	int max = S0;
	
	for(int i = 0 ; i < n - 1 ; i++){  // as we already found the first initial sum so running n-1 times
	    
        // this is new sum of arr[i]*i
	    int S0plusOne = S0 + sum - n*A[n-1-i]; // here the formula represents : next rotation will increase the multiplication number by 1 with each element of array which is actually the sum ( i.e 1a + 1b+ 1c ... = sum) so adding sum in previous sumation and the last element multiplier will be 0 becuase it will will be shifted to 0th indexand oth index val is 0*e = 0 so subtracting the sum of last element(n-1-i) . 
	    
	    if(S0plusOne > max) // updating answer
	    max = S0plusOne ;
	    
	    S0 = S0plusOne ; // S0plusOne becomes new S0 for next rotation.
	}
	
	return max ;
	
	
    }	
    
}
