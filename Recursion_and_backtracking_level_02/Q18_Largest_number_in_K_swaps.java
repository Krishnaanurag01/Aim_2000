package Recursion_and_backtracking_level_02;

public class Q18_Largest_number_in_K_swaps {

    public static void main(String[] args) {
        
        findMaximumNum("1234567", 4);
        System.out.println(max);
    }

    static String max = "0" ;
    public static String findMaximumNum(String str, int k)
        {
            //code here
            max = "0" ;
            // System.out.println(max);
            findMaximum(str,k) ;
            return max ;
        }
        
       
	public static void findMaximum(String str, int k) {

		if( k == 0){
		    
            if(isLarger(str,max)){
                max = str ;
            }
            
			return ;
		}
		
		for(int i = 0 ; i < str.length() ; i++){
			char num = str.charAt(i) ;
			for(int j = i+1 ; j < str.length() ; j++){
			char num2 = str.charAt(j) ;
			
			if(num2 > num){
				String swapped = swap(str,i,j) ;
			    findMaximum(swapped,k-1) ;
			}

			}
		}
	}
	
	public static boolean isLarger(String str, String max){
	    int i = 0 ; 
	    int j = 0 ;
	    
	    while(i < str.length() ){
	        if(str.charAt(i) > max.charAt(j)){
	            return true ;
	        }
	        
	        i++ ;
	        j++ ;
	    }
	    
	    return false; 
	    
	}
	
	public static String swap(String s , int i , int j){
		
		char ch1 = s.charAt(i) ;
		char ch2 = s.charAt(j) ;

		String left = s.substring(0,i) ;
		String mid = s.substring(i+1,j) ;
		String end = s.substring(j+1) ;


		return left + ch2 + mid + ch1 + end ; 
	}
    
}
