package Strings;

public class Q17_Rabin_Karp_Algo {
    public static void main(String[] args) {
        String txt = "AABAACAADAABAAABAA";
        String pat = "AABA";
        // search(txt, pat);
       

    }


    // Brute force : time comp :- O(m*(n-m+1)) which is not efficient.

    // public static void search(String txt, String pat) {

    //     int txtIndex = txt.length();
    //     int patIndex = pat.length();

    //     for (int i = 0; i <= txtIndex - patIndex; i++) {

    //         int j =0;
    //         for ( j= 0; j < patIndex; j++) {
    //             if (txt.charAt(i + j) != pat.charAt(j)) {
    //                 break;
    //             }
               
    //         }
    //         if (j == patIndex) {
    //             System.out.println("Found it at the : " + i + "Index");
    //         }
    //     }
    // }




    // The average and best-case running time of the Rabin-Karp algorithm is O(n+m), but its worst-case time is O(nm). Worst case of Rabin-Karp algorithm occurs when all characters of pattern and text are same as the hash values of all the substrings of txt[] match with hash value of pat[]. For example pat[] = “AAA” and txt[] = “AAAAAAA”.

    private static final int p = 26; // took 26 because there are 26 characters alphabet.
    private static final int d = 5381; // larger prime number gives lesser conflicts.

    public static void rabin_Karp_search(String text , String ptr) {


        // initializing hashvalue of text and pattern.

        int textHash = 0;
        int ptrHash = 0;

        for (int i = 0; i < ptr.length(); i++) {  // Generating Hash values for pattern and first window text
            ptrHash = ptrHash * p;
            textHash = textHash * p;

            ptrHash = ptrHash + ((ptr.charAt(i) - 'A' + 1) % d);
            textHash = textHash + ((text.charAt(i) - 'A' + 1) % d);
        }

        for (int i = 0; i < text.length(); i++) {
            
            // if out textHash pattern is equal to pattern hash then we have found the searched pattern so we'll print it.
            if(ptrHash == textHash){
                System.out.println("Search Found at : " + i +" index.");
            }

            // now searching in forward.
            if(i < text.length()-ptr.length()){ // this defines if we have a text lengt which is not smaller than i. so that it will help in not giving error in second next line of code.

                // for this we'll first remove the first character hash from textHash.
                textHash = textHash - ((text.charAt(i) - 'A'+1)*(int) Math.pow(p, ptr.length()-1));
            
                // now adding the next character hash in textHash.

                textHash = textHash * p + (text.charAt(i + ptr.length()) - 'A'+1); // i + ptr.length will take index of lastchar which is  to added.

            }
        }
        
    }
}
