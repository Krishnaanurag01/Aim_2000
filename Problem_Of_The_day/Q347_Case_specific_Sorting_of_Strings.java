package Problem_Of_The_day;

public class Q347_Case_specific_Sorting_of_Strings {

    public static String caseSort(String str)
    {
        // using array for uppar and lower case char
        int[] lc = new int[26] ;
        int[] uc = new int[26] ;
         
        for(char ch : str.toCharArray()){
            if(ch - 'Z' <= 0){ // store upper char in its array
                uc[ch-'A']++;
            }
            else{
                lc[ch-'a']++; // and lower in lower array
            }
        }
        
        int l = 0 ;
        int u = 0 ;
        
        StringBuilder sb = new StringBuilder() ;
        for(char ch : str.toCharArray()){
            if(ch - 'Z' <= 0){ // if current char is upper
                while(uc[u] <= 0){ // then take first smallest uppper case char that is available
                    u++ ;
                }
                sb.append((char)(u+'A')) ; // store in sb
                uc[u]-- ; // and reduce this char freq
            }
            else{ // same goes for lower case.
                while(lc[l] <= 0){
                    l++ ;
                }
                sb.append((char)(l+'a')) ;
                lc[l]-- ;
            }
        }
        
        return sb.toString() ;
    }
}
