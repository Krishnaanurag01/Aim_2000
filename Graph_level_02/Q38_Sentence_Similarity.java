package Graph_level_02;
import java.util.*;

public class Q38_Sentence_Similarity {
    
    // using DSU with hashmap becuase we have to merged Strings and we can't use for string.(because we won't be able to figure our the index.)

    static HashMap<String,String> parent ;
  static HashMap<String,Integer> rank ;
  public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {

    parent = new HashMap<>() ;
    rank = new HashMap<>() ;

    // merging
    for(String[] pair : pairs){
      union(pair[0],pair[1]) ;
    }

    // if length is not equal then return directly
    if(Sentence1.length != Sentence2.length){
      return false ;
    }


    // check each parent
    for(int i = 0 ; i < Sentence1.length ; i++){
      String w1 = Sentence1[i] ;
      String w2 = Sentence2[i] ;

      if(w1.equals(w2) == false && find(w1).equals( find( w2 ) ) == false)
      return false ;
    }

    return true ;
  }



  public static boolean union(String x , String y){

    String lx = find(x) ;
    String ly = find(y) ;

    if( lx.equals(ly) == false ){

      if (rank.get(lx) < rank.get(ly) ) {
        parent.put(lx,ly) ;
      } else if( rank.get(ly) < rank.get(lx) ) {
        parent.put(ly,lx) ;
      }
      else{
        parent.put(lx,ly) ;
        rank.put( ly, rank.get(ly)+1 ) ;
      }

      return true ;
    }
    else{
      return false ;
    }
  }



  public static String find(String x){

    // intializing at the time of traversing.
    if(parent.containsKey(x) == false){
      parent.put(x,x) ;
      rank.put(x,1) ;
    }

    if(parent.get(x).equals(x)){
      return x ;
    }

    String temp = find(parent.get(x)) ;
    parent.put(x,temp) ;

    return temp ;
  }
}
