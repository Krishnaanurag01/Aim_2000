package Arrays_and_string ;

public class Q30_Multiply_Strings {

    public static void main(String[] args) {
        
        multiply("9133", "0") ;
    }

    public static String multiply(String num1, String num2) {
        
        if(num1.equals("0") || num2.equals("0") ) return "0" ;
        
        int n1 = num1.length() ;
        int n2 = num2.length() ;
        
        int[] res = new int[n1+n2] ;
        
        int i = n2 - 1 ;
        int pf = 0 ;
        
        while(i >= 0){
            int val1 = num2.charAt(i) - '0'  ;
            int k = res.length - 1 - pf ;
            int carry = 0 ;
            
            int j = n1 - 1 ;
            
            while(j >= 0 || carry > 0 ){
                int val2 = j >= 0 ? num1.charAt(j) - '0' : 0;
                int result = val1*val2 + carry + res[k]; 
                
                res[k] = result % 10 ;
                carry = result/10 ;
                
                j-- ;
                k--;
            }
              
            i-- ;
            pf++ ;
        }
        
        StringBuilder sb = new StringBuilder() ;
        boolean flag = true ;
        for(int p = 0 ; p < res.length ; p++){
            if(res[p] == 0 && flag == true){
                  continue ;
            }
            else{
                sb.append(res[p]) ;
                flag = false;
            }
        }
        
        return sb.toString() ;
    }
    
    

}