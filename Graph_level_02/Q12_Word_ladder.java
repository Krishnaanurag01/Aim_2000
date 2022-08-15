package Graph_level_02;
import java.util.*;

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
    










    

    // approach 2 : 

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        wordList.add(beginWord) ; // adding begin word as it is not present intially in wordList
        HashMap<String, ArrayList<String>> map = new HashMap<>() ; // this is graph (node -> list of nbrs)
        HashSet<String> set = new HashSet<>() ;
        boolean isPresent = false ;
        
        for(String word : wordList){
            set.add(word) ;
            if(word.equals(endWord)){
                isPresent = true;
            }
        }
        
        if(isPresent == false){ // if end word is not present then return 0 directly.
            return 0 ;
        }
        
        // forming a graph.
        
        for(String curr : wordList){
            for (int i = 0; i < curr.length() ; i++) {    
                StringBuilder sb = new StringBuilder(curr) ; // we will check each word by updating one char only
                for (char j = 'a' ; j <= 'z' ; j++) {
                        sb.setCharAt(i, j);
                        String temp = sb.toString() ;
                        if (set.contains(temp)) { // if the new word present in our set list then add in map as a nbr.
                           ArrayList<String> a = map.getOrDefault(curr, new ArrayList<>()) ;
                            a.add(temp) ;
                            map.put(curr,a) ;
                        }
                }
            }
        }
        
        return wordLadderLength(beginWord, endWord, map) ;
    }

    
    public int wordLadderLength(String startWord, String targetWord, HashMap<String,ArrayList<String>> map)
    {

        // now using BFS.
        
        // System.out.println(map) ;

        int level = 0 ;
        LinkedList<String> queue = new LinkedList<>() ;
        HashSet<String> visited = new HashSet<>() ;
        visited.add(startWord) ;
        queue.add(startWord) ;

        while (queue.size() > 0) {
            int size = queue.size() ;
            level++ ;

            while (size-- > 0) {
                String curr = queue.removeFirst() ;
                if(map.containsKey(curr) == false) continue ;
                
                for(String nbrs : map.get(curr)){ // checking all nbrs 
                    if(visited.contains(nbrs) == false){ // if not visited add it in queue
                        visited.add(nbrs) ;
                        queue.add(nbrs) ;
                        
                        if(nbrs.equals(targetWord)) return level+1; // if answer then return level
                        
                    }
                }
            }
        }

        return 0 ;
    }
}
