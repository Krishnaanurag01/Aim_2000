package Arrays_and_string_level_02 ;

/**
 * Q53_Push_Dominoes
 */
public class Q53_Push_Dominoes {

     public String pushDominoes(String dominoes) {
        
        int n = dominoes.length() ;
        /// adding L and R in left and right side of the string which helps in partitioning :  L+dominoes+R 

        char[] arr = new char[n+2] ; // makiing an arry of n+2 size 
        // and adding L in left
        arr[0] = 'L' ;
        // adding R in right
        arr[n+1] = 'R' ;
        
        // Storing in characters of dominoes in arr. as we added L in 0th index and R in N+1 index so adding string dominoes in 1 to N index.
        for(int i = 1 ; i <= n ; i++){
            arr[i] = dominoes.charAt(i-1) ;
        }
        

        // j denotes the left side of section.
        int j = 0 ;
        

        // now we are traversing the string with k
        int k = 1 ;
        
        while(k < arr.length ){
            while(arr[k] == '.'){ // finding the next L || R
                k++;
            }
            
            // now sending the section of J to K in helper function.
            // J is the left side of the section and K is right side of the section
                solveDominoesConfig(arr,j,k) ;
                // now J becomes the new left side of next section
                            j = k ;

                            k++ ;

        }

        // now adding to string.
        // as 0th index and N+1 index is added explicitly so we won't take that in our answer string. so adding 1 to N string in answer.
        StringBuilder sb = new StringBuilder() ;
        
        for(int i = 1  ; i < arr.length - 1 ; i++)
            sb.append(arr[i]) ;
        
        return sb.toString() ;
        
    }
    
    public void solveDominoesConfig(char[] arr,int j, int k){
        
        // when Both side is left then make inner part left
        if(arr[j] == 'L' && arr[k] == 'L'){
            
            for(int i = j+1 ; i < k ; i++){
                arr[i] = 'L' ;
            }
            
        } // when both side is right then make inner part right
        else if(arr[j] == 'R' && arr[k] == 'R'){
            
            for(int i = j+1 ; i < k ; i++){
                arr[i] = 'R' ;
            }
            
        } // when left side L and right side is R then in between dominoes will not be affected so nothing.
        else if(arr[j] == 'L' && arr[k] == 'R'){
            // do nothing.
        }
        else{// else when left is R and right is L then find the length if length is even then make first half right and second half left .
            // if length is odd then make first half till mid-1 right and mid +1 till end left the middle element will not be affected.
            
            int size = k-j-1 ;
            int Mid = (k+j)/2 ;
            
            if(size % 2 == 0){
                // when size is evem
                for(int i = j+1 ; i <= Mid ; i++ ){
                    arr[i] = 'R' ;
                }
                
                for(int i = Mid+1  ; i < k ; i++ ){
                    arr[i] = 'L' ;
                }
            }
            else{
                
                for(int i = j+1 ; i < Mid ; i++ ){
                    arr[i] = 'R' ;
                }
                
                for(int i = Mid + 1 ; i < k ; i++ ){
                    arr[i] = 'L' ;
                }
                
            }
            
        }
        
    }
}