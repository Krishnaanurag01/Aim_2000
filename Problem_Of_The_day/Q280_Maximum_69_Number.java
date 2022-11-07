package Problem_Of_The_day;

public class Q280_Maximum_69_Number {
    public int maximum69Number (int num) {
        StringBuilder n = new StringBuilder(num+"") ;
        
        for(int i = 0 ; i < n.length() ; i++){
            if(n.charAt(i) == '6'){
                n.setCharAt(i,'9');
                return Integer.parseInt(n.toString()) ;
            }
        }
        
        return num ;
    }
}
