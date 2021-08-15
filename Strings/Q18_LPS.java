package Strings;


// LPS = longest proper prefix which is also suffix. overlapping is allowed
public class Q18_LPS {

    public static void main(String[] args) {

        System.out.println(longestPrefixSuffix("ababCabab"));
    }
    public static int longestPrefixSuffix(String s){

        // check pep coding video for better explanation.

        int n = s.length();
        int i = 1;
        int len = 0;
        int[] lps = new int[n];

        // as string of length 1 can't have any prefix and suffix so its already zero thats why i is inialized with 1. and arr[0] = 0 by default.

        while (i < n) {
            if(s.charAt(i)== s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len > 0){
                    len = lps[len-1];
                }
                else{
                    lps[i] = 0 ;
                    i++;
                }
            }
        }
        return lps[n-1];
        
    }
    
}
