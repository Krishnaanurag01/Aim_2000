package Problem_Of_The_day;
/**
 * Q379_Special_Palindrome_Substrings
 */
public class Q379_Special_Palindrome_Substrings {

    public  static int specialPalindrome(String a, String b){
        
        char[] tempA = a.toCharArray() ; // making a temp string array eqauls to a.
        int min = (int)1e9 ;
        
        for(int i = 0 ; i <= a.length() - b.length() ; i++){
            // searching in every window of a of b's length, that min operation of window where we can make a substring equals to b
            int opr = 0 ;
            for(int j = 0 ; j < b.length() ; j++){
                if(a.charAt(i+j) != b.charAt(j)) opr++ ; // if char not same means we perform one operation here to change it
                tempA[i+j] = b.charAt(j) ;
            }
            
            int minOprToPLDRM = getMinOpr(tempA, i, b.length()) ;
            min = Math.min(min, opr + minOprToPLDRM) ; // subtring ko total operation + palindrome banane ka total operation
            tempA = a.toCharArray() ;
        }
        
        return min == (int)1e9 ? -1 : min ;
    }
    
    static int getMinOpr(char[] a, int lbow, int rbow){
        // lbow, rbow = left and right boundary of window where we just made change in orignal a and formed new a which we pass in this function
        
        int left = 0 ;
        int right = a.length -1 ;
        int opr = 0 ;
        
        while(left <= right){
            if(a[left] != a[right]){
                if(left >= lbow && right <= (rbow + lbow - 1)) return (int)1e9 ; // matlab jo char match nhi ho rha woh wahi character h jisko humne temp a me replace kia tha (eg -- a = abbd , b == mr yha agar temp a = amrd karety hai toh mr ko hum replace nhi kar saktey because humne esko substring banaya h)
                opr++ ; // else replace kar saktey toh increase the operation
            }
            left++ ;
            right-- ;
        }
        
        return opr ;
    }
    
}