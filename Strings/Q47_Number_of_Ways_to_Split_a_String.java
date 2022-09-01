package Strings;

public class Q47_Number_of_Ways_to_Split_a_String {

    public int numWays(String s) {
        long n = s.length() ;
        long ones = 0 ;
        for(char ch : s.toCharArray()){
            if(ch == '1') ones++ ;
        }
        
        if(ones % 3 != 0 ) return 0 ; // means we can't divide ones in three substring
        // else .
        if(ones == 0){ // when our string holds one 0's.
            long positionWhereWeCanCut =  n - 1 ; // 000 -> we can cut on 0|00 or 00|0 so n-1
             return (int)((((positionWhereWeCanCut)*(positionWhereWeCanCut-1))/2)%M);
        }
        
        long oneCount = ones/3 ; // each string will hold this amount of 1.
        long[] gap = new long[2] ;
        int k = 0 ; // gap index.
        int osf = 0 ; // one so far.
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i) ;
            if(ch == '1') osf++ ;
            
            if(osf == oneCount){
                if(k == 2) break ;
                // System.out.println(i) ;
                int zib = 0 ; // count the zeros in between the two substring.
                i++ ;
                while(i < s.length() && s.charAt(i) != '1'){
                    i++;
                    zib++ ;
                }
                
                i-- ;
                gap[k++] = zib + 1 ; // because we make split 00 in following way -> |0|0|
                osf = 0 ;
            }
        }
    
        return (int)(multiply(gap[0] , gap[1]) ) ;
    }
    
    
    // mod operations : 
    final long M = (int)1e9+7 ;
    
    long mod(long a){
        return ((a%M + M)%M) ;
    }
    
    long add(long a, long b){
        return mod(mod(a) + mod(b)) ;
    }
    
    long multiply(long a, long b){
        return mod(mod(a)*mod(b)) ;
    }
    
}
