package Problem_Of_The_day;

public class Q39_Palindrome_Pairs {
    
    static int palindromepair(int N, String arr[]) {
        
        for(int i = 0 ; i < N-1 ; i++){
            for(int j = 0 ; j < N ; j++){
                
                if(i != j && isPalind(arr[i],arr[j]) ){
                    return 1 ;
                }
            }
        }
        
        return 0 ;
    }
    
    static boolean isPalind(String s , String m){
        
        StringBuilder sb = new StringBuilder(s) ;
        sb.append(m) ;
        
        
        int i = 0 ;
        int j = sb.length() -1 ;
        
        while(i < j ){
          if(sb.charAt(i) != sb.charAt(j)){
              return false;
          }
          i++ ;
          j-- ;
        }
        
        return true ;
    }
}
