package Problem_Of_The_day;

public class Q44_Rearrange_a_string {
    
    public String arrangeString(String s)
    {
        //code here.
        
        int[] arr = new int[26] ;
        int sum = 0 ;  // this will be sum of integers in s
        
        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i) ;
            
            if(Character.isDigit(ch)){  // if current char is digit then add to sum
                sum += (ch-'0') ;
            }
            else{
                arr[ch-'A']++ ;  // increase the freq of each character of string.
            }
        }
        
        StringBuilder sb = new StringBuilder() ;
        
        for(int i = 0 ; i < arr.length ; i++){
            
            while(arr[i] > 0){
                sb.append( (char)(i+'A')) ; // now adding character in stringbuilder
                arr[i]-- ;
            }
        }
        
        
        return sb.toString() + sum ; // adding sum in end
        
    }

}
