package Strings;


// LPS = longest proper prefix which is also suffix. overlapping is allowed
public class Q18_LPS {

    public static void main(String[] args) {

        System.out.println(longestPrefixSuffix("ababCabab"));
    }
    public static int longestPrefixSuffix(String s){

        // check pep coding video for better explanation.

        int n = s.length();

        // i will denote index for lpa and start from 1 .
        int i = 1; 
        int len = 0;
        int[] lps = new int[n];

        // as string of length 1 can't have any prefix and suffix so its already zero thats why i is inialized with 1. and lps[0] = 0 by default.

        while (i < n) {
            if(s.charAt(i) == s.charAt(len)){ // if they are same then
                len++; // increase len 
                lps[i] = len; // store in lps[i]
                i++; // now increment i index
            }
            else{
                if(len > 0){ // if len is > 0 then find smaller len index
                    len = lps[len-1]; // going back to smaller len
                }
                else{ // if len becomes 0 then store 0 size and increment index.
                    lps[i] = 0 ;
                    i++;
                }
            }
        }
        return lps[n-1]; // returning answer.
        
    }
    
}
