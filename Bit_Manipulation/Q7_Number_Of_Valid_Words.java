package Bit_Manipulation ;
import java.util.*;

public class Q7_Number_Of_Valid_Words {

    public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Character, ArrayList<Integer> > map = new HashMap<>() ;
      
      // initialzing list for each char from a to z in map
      for(char ch = 'a' ; ch <= 'z' ; ch++ ){
          map.put(ch,new ArrayList<>()) ;
      }
      
      // System.out.println(map) ;
      
      // now creating mask for each word and then allocating them with corresponing map field
      for(String word : words){
          int mask = 0 ;
          
          // creating mask
          for(char ch : word.toCharArray()){
              int bit = ch - 'a' ;
              mask = mask | (1 << bit ) ;
          }
          
          // now again acessing each char of current string and then adding current string mask correspond to each char in map. this denotes that this word contains the current char.
          
          HashSet<Character> unique = new HashSet<>(); // using this for adding current word with distinct char.
          
          for(char ch : word.toCharArray()){
              
              if(unique.contains(ch))
                  continue ;
              
              // else
              unique.add(ch) ;
              map.get(ch).add(mask) ;
          }
      }
      
      
      // step 03: 
      
      // making mask for each puzzle word
      
      ArrayList<Integer> ans = new ArrayList<>() ;
      
      for(String puzzle : puzzles){
          int count = 0 ;
          
          // create mask first for current puzzle
          int PuzzleMask = 0 ;
          
          for(char ch : puzzle.toCharArray()){
              int bit = ch - 'a' ;
              PuzzleMask = PuzzleMask | (1 << bit ) ;
          }
          
          // now getting all mask(string words) from map which contains the first char of current puzzle
          ArrayList<Integer> masks = map.get( puzzle.charAt(0) );
          
          // now traverse each map and check
          
          for(Integer mask : masks){
              
              // check if "And" of puzzle and mask gives same mask
              // it will give same mask when all the char of mask(word) is present in puzzle(means if same position has 1 bit)
              if( (PuzzleMask & mask) == mask){
                  count++ ; // counting total match for current word
              }
              
          } 
          // and adding total match for current puzzle in answer.
          ans.add(count) ;
          
      }
      
      
      return ans ;
   }

  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      String[] words = new String[n];
      for(int i = 0 ; i < words.length; i++) {
          words[i] = scn.next();
      }
      int m = scn.nextInt();
      String[] puzzles = new String[m];
      for(int i = 0 ; i < m ;i++) {
          puzzles[i] = scn.next();
      }
      ArrayList<Integer> ans = findNumOfValidWords(words,puzzles);
      for(int i = 0 ; i < puzzles.length ; i++) {
          System.out.println(puzzles[i] + " -> " + ans.get(i));
      }
      scn.close();
  }
    
}
