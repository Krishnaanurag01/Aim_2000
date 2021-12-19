package Problem_Of_The_day;

public class Q26_Encrypt_the_string2 {



    public static void main(String[] args) {
        
        System.out.println(encryptString("aaaaaaaaaaa"));
    }

    static String encryptString(String S){
        // code here
        StringBuilder ans = new StringBuilder() ;
        
        for(int i = 0 ; i < S.length() ; i++){
            
            int c = 1 ;
            while(i+1 < S.length() && S.charAt(i) == S.charAt(i+1)){
                c++ ;
                i++ ;
            }
            
            String hex = Integer.toHexString(c) ;
            StringBuilder sb = new StringBuilder(hex) ;
            ans.append(S.charAt(i)) ;
            sb.reverse() ;
            ans.append(sb) ;
            
        }
        
        return ans.reverse().toString() ;
    }
    
}
