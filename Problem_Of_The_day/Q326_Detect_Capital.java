package Problem_Of_The_day;

public class Q326_Detect_Capital {

    public boolean detectCapitalUse(String word) {
        
        int cap = 0 ;
        
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)){
                cap++ ;
            }
        }
        
        if(cap == 0 || cap == word.length()) return true ;
        if(cap == 1 && Character.isUpperCase(word.charAt(0))) return true ;
        
        return false;
    }
}
