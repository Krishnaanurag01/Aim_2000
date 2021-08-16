package Strings;

// finding same thing which was done in Q 17.
public class Q18_KMP_Algo {
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        KMP_Algo(txt, pat);
    }

    public static void KMP_Algo(String txt , String ptr) {
        
        int n = txt.length(); // size of text
        int m = ptr.length(); // size of pattern.

        int[] lps = new int[m];

        findLpsArray(ptr , lps ,m);
        int j = 0 ; // for pattern
        int i = 0 ; //for text

        while (i < n) {
            if(ptr.charAt(j) == txt.charAt(i)){
                j++;
                i++;
            }
            if(j == m){
                System.out.println(ptr + " Occurence present at " + (i-j) +" index.");
                j = lps[j-1];
            }
            else if (i < n && ptr.charAt(j) != txt.charAt(i)){
                if(j > 0){

                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
    }

    // checkout lps solution in Q19_LPS
    public static void findLpsArray(String ptr , int[] lps , int m) {
        int len = 0 ;
        int i = 1;

        while (i < m) {
            if(ptr.charAt(i) == ptr.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len > 0){
                    len = lps[len - 1];
                }
                else{
                    lps[i] = 0 ;
                    i++;
                }
            }


        }
    }
}
