package Problem_Of_The_day;
import java.util.*;

public class Q255_Check_if_the_Sentence_Is_Pangram {

    public boolean checkIfPangram(String sentence) {
        
        HashSet<Character> set = new HashSet<>() ;
        for(char ch : sentence.toCharArray()){
            set.add(ch) ;
        }
        
        return set.size() == 26;
    }
}
