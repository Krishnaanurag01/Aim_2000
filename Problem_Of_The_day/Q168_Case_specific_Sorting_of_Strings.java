package Problem_Of_The_day ;
public class Q168_Case_specific_Sorting_of_Strings {
    

    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
    int[] small = new int[26] ;
    int[] large = new int[26] ;
       
       for(char ch : str.toCharArray()){
           if(ch > 90){ // if ascii is greater than it's the small char sp add it in small
               small[ch-'a']++;
           }
           else{ // else large added in it's array
               large[ch-'A']++;
           }
       }
    
       StringBuilder sb = new StringBuilder() ;
       int s = 0 ;
       int l = 0 ;
       
       for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(ch > 90){ // means we have to select lower letter
              
              while(small[s] == 0){ // find the letter which has some freq
                  s++;
              }    
              sb.append( (char)(s +'a'));
              small[s]-- ;
            }
            else{ // same as above for larger char
               while(large[l] == 0){
                  l++;
              }    
              sb.append( (char)(l +'A'));
              large[l]-- ;
            }
       }
       
       return sb.toString() ;
    }
}
