package Graph_level_02;

import java.util.HashSet;
import java.util.LinkedList;

public class Q12_Word_ladder {


    // Expected Time Compelxity: O(N2 * M).
// Expected Auxiliary Space: O(N * M) where N = length of wordList and M = |wordListi|.

    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
    

        HashSet<String> set = new HashSet<>() ; // this will contain all the strings as it will search element in o(1) time so using this.

        boolean isPresent = false ;

        for (int i = 0; i < wordList.length; i++) {
            
            if(wordList[i].equals(targetWord)){ // if the target element is present in the list then make ispresent true
                isPresent = true ;
            }

            set.add(wordList[i]) ; // adding each string.
        }

        if(isPresent == false){ // if element is not present then return 0.
            return 0 ;
        }
        

        // now using BFS.

        int level = 0 ;

        LinkedList<String> queue = new LinkedList<>() ;

        queue.add(startWord) ; // adding first word.

        while (queue.size() > 0) {
            
            int size = queue.size() ; // for level order traversal.

            level++ ;

            while (size-- > 0) {
                
                String curr = queue.removeFirst() ; // removing first string.

                // now running loop for each removed string.

                for (int i = 0; i < curr.length() ; i++) {
                    
                    StringBuilder sb = new StringBuilder(curr) ; // using this so that we can easily change some character inbetween the string.

                    for (char j = 'a' ; j <= 'z' ; j++) {

                        sb.setCharAt(i, j); // changing a to z on ith index.

                        String temp = sb.toString() ;

                        if(temp.equals(curr)){
                            continue ; // if string becomes equal to  where it was before then skip.
                        }
                        
                        if(temp.equals(targetWord)){ // if we find our string then return level + 1 ;
                            return level+1 ;
                        }

                        if (set.contains(temp)) { // else check if the new word is in the wordlist if it is then add it to the queue and remove current string from set.
                            queue.add(temp);
                            set.remove(curr) ;
                        }
                    }
                }
            }
        }

        return 0 ;
    }
    
}
