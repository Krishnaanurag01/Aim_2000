package Problem_Of_The_day;

public class Q398_Make_Palindrome {
    public static boolean makePalindrome(int n, String[] arr) {
        if(n == 1){
            return isPalindrome(arr[0]);
        }
        HashMap<String,Integer> map = new HashMap<>() ;
        
        for(String s : arr){ // storing key with freq
            map.put(s, map.getOrDefault(s,0)+1) ;
        }
        
        int odd = 0 ; // count of odd words whose palindrome is not present
        
        for(String key : map.keySet()){
            int freq = map.get(key) ;
            String reverse = new StringBuilder(key).reverse().toString() ; // getting the reverse of current word
            int freq2 = map.getOrDefault(reverse,0) ; // and fetching it's freq
            
            if(freq != freq2){
                odd += Math.abs(freq - freq2) ;
            }
        }
        
        return odd <= 1 ;
    }
    
    public static boolean isPalindrome(String s){
        int si = 0 ;
        int ei = s.length() - 1 ;
        
        while(si <= ei){
            if(s.charAt(si) != s.charAt(ei)) return false ;
            si++ ;
            ei-- ;
        }
        
        return true ;
    }
}
