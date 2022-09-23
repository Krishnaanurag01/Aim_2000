package Strings;

public class Q48_String_Compression {

    public int compress(char[] chars) {
        
        int m = 0 ; // index where next char and m+1 is count location in chars.
        for(int i = 0 ; i < chars.length ;){
           
            char ch = chars[i] ; // current char.
            int count = 1 ; // curr count.
            
            // checking if next characters are also same.
            int j = i+1 ;
            while(j < chars.length && chars[j] == ch){
                count++ ;
                j++ ;
            }
            
            // if count is 1 then 
            if(count == 1){
                chars[m] = ch ; // store only char.
                m++ ;
                i++ ;
            }
            else{// otherwise store char and it's count (when count > 9 like 12 then store 1 and 2 at diff location)
                chars[m++] = ch ;  // store char.
                StringBuilder sb = new StringBuilder() ;
                sb.append(count) ;
                int k = 0 ;
                while(k < sb.length()){
                    chars[m++] = sb.charAt(k++) ; // storing count.
                }
                
                i = j ; // moving  next character.
            }
        }
        
        return m  ;// return length of compressed 
    }
}
