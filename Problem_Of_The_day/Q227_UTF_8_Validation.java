package Problem_Of_The_day;

public class Q227_UTF_8_Validation {

    public boolean validUtf8(int[] data) {
        
        boolean found_head = false;
        int size = 0 ;
        
        for(int i = 0 ; i < data.length ; i++){
            String s = Integer.toBinaryString(data[i]) ;
            // System.out.println(data[i] + " -- "+ s) ;
            
            if(found_head == false){ // means abhi koi parent value nhi mili jiski koi sequence ho.
                if(data[i] < 128) continue ; // jab value  128 se less hoga the msb par 1 nhi hoga 1 bhi toh wo bas 1 size ka sequence h so continue.
                
                found_head =  true ; // otherwise esko true kar do taki further few steps k liy koi edhar na aaye.
                
                for(char ch : s.toCharArray()){  
                    if(ch == '1') size++ ; // jab tak 1 miltey rhe size increase it.
                    else break ; // jab 0 mil jaye to break it.
                }
                
                if(size == 1) return false; // yha false return kardo kyuki 1 size ka koi sequence nhi ban sakta
                if(size == 0) size = 1 ;
                
                if(size < 1 || size > 4) return false;
                // System.out.println(size) ;
                size-- ; // matlab etne sequence chahiy 10 wale.
            }
            else{
                
                if(size == 0){ // jab sare relatove sequecne mil jaye tab wapas se parent sequence rhundo
                    found_head = false;
                    i-- ;
                    continue ;
                }
                
                // System.out.println(Integer.toBinaryString(data[i]).substring(0,2).equals("10")) ;
                
                if(data[i] < 128 ) return false;
                
                if(Integer.toBinaryString(data[i]).substring(0,2).equals("10") == false) return false;
                
                size-- ;
            }
        }
        
        return size == 0 ;
    }
}
