package Problem_Of_The_day;
import java.util.*;

public class Q104_Repeated_DNS_Sequences {

    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> ll=new ArrayList<>();

        // storing all the 10 length sequence in hashmap.
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String a=s.substring(i,i+10);
            if(hm.containsKey(a)){
                hm.put(a,hm.get(a)+1);
            }
            else{
                hm.put(a,1);
            }
        }
        // if any sequence occurs more than once the add it to the answer.
        for(String key: hm.keySet()){
            int value= hm.get(key) ;
            if(value>1){
                ll.add(key);
            }
        }
        return ll;
    }
}
