package Problem_Of_The_day;

public class Q236_Concatenation_of_Consecutive_Binary_Numbers {


    // method 01 : ( very bad complexity )
    public int concatenatedBinary(int n) {
     
        int ans = 0 ;
        int pow = 1 ;
     
        for(int i = n; i >= 1 ; i--){
            int val = i ;
            
            // finding the binary of val and at the same time converting into the decimal ans.
            while(val > 0){
                if(val % 2 == 0){
                    val = val/2 ;
                }
                else{
                    ans = (ans + pow) % M ;
                    val = val/2 ;
                }
                pow = (pow*2) % M ;
            }
        }
        
        
        return ans ;
    }
    
    // below functions though works in O(1) but combined takes alot of time.
    
    int M = (int)1e9+7 ;
    // long mod(long a) {
    //     return (a % M + M) % M ;
    // } 
    // long add(long a, long b){ return mod(mod(a) + mod(b)) ;} 




    //method 02 :  better approch.
    public int concatenatedBinary2(int n) {
     
        long ans = 0 ;
        for(int i = 1 ; i <= n ; i++){
            String binary_rep = Integer.toBinaryString(i) ; // binary representation of i. we just need the size of binary rep so that we can left shift the result and after that add current val       
            ans = (ans << binary_rep.length()) % M ;// shifting left so that we can add current num in right most side
            ans = (ans + i) % M ;
        }
     
        return (int)ans ;
    }


    // method 03 : optimal solution. 

    public int concatenatedBinary3(int n) {
     
        long ans = 0 ;
        int size = 0 ;
        for(int i = 1 ; i <= n ; i++){
            // below condition if gives 0 then it means that current binary rep length of i is greater than by 1 length as compared to i-1 binary rep
            if((i & (i-1)) == 0) size++ ; //  we just need the size of binary rep so that we can left shift the result and after that add current val.
            
            ans = (ans << size | i) % M ;// shifting left so that we can add current num in right most side
        }
        return (int)ans ;
    }

}
