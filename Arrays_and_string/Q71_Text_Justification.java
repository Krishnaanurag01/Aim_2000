package Arrays_and_string;

import java.util.ArrayList;
import java.util.List;

public class Q71_Text_Justification {

    public List<String> fullJustify(String[] words, int maxWidth) {
     
        List<String> ans = new ArrayList<>() ;
        int i = 0 ;
        int n = words.length ;

        while (i < words.length) {
            
            int wc = words[i].length() ; // adding fist word length in wc. 
            int j = i + 1 ; // next word

            int can = 0 ; // candidate count -> intialized with 0 as ignoring the first word, here it working as telling us about how many space(1 space that we give after each word ) given so far in the current paragraph.

            while (j < n && wc + can + words[j].length() + 1 <= maxWidth ) {
                
                wc += words[j].length()  ;
                can++ ;
                j++ ;
            }

            int vacant = maxWidth - wc ;              // denotes the vacant space (the space after last word) in current paragraph.

            int atleast = can == 0 ? 0 : vacant/can ; // this is the space that we must give after each word(except the last one) so that, after the last word there will not be any space.

            int extra = can == 0 ? 0 : vacant % can ; // this is the extra space that we have to give so that, after the last word there will not be any space. (forx ex : if maxwidth is 10 and we are left with 4 extra space and total candidate(word) is 3 
           // so  10/3 = 3 is the atleast space that we have to give after each word and 10 % 3 => 1 is the extra space that we have to assign after first word.

           if (j == words.length ) { // when it is the last paragraph then don't give extra space (don't manage the extra space that is left after the last word of paragraph)
               atleast = 1 ;
               extra = 0 ;
           }


           StringBuilder sb = new StringBuilder() ;

           // now adding word in string
            for (int k = i ; k < j ; k++) {
                sb.append(words[k]) ;
               if(k == j-1) break ; // if it is the last word then break directly and don't give extra space.

               // extra space that we must give after each word.
               for (int p = 0; p < atleast ; p++) {
                   sb.append(" ") ;
               }

               if (extra > 0) { // if extra space is also present then give it to the string.
                   sb.append(" ") ;
                   extra-- ;
               }
            }

            if (sb.length() < maxWidth) {
                sb.append(" ") ;
            }

            i = j ;

            ans.add(sb.toString()) ;
        }
        
        return ans ;
    }
    
}
