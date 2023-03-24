package Problem_Of_The_day;

public class Q381_Remove_and_Reverse {

    String removeReverse(String S) 
    { 
       int si = 0 ;
       int ei = S.length() - 1;
       int direc = 0 ; // means left to right and vice versa for 1
       
       int[] freq = new int[26] ; //  storing freq of each char helps in determining whether current is duplicate or not.
       for(char ch : S.toCharArray()){
           freq[ch-'a']++ ;
       }
       
       StringBuilder sb = new StringBuilder() ;
       
       while(si <= ei){
           if(direc == 0){ // means move left to right
               char ch = S.charAt(si) ;
               if(freq[ch-'a'] > 1){ // means current char is first duplicate and it has other copies ahead
                   freq[ch-'a'] -- ; // so remove it
                   direc = 1 ;// and change the  direction
               }
               else if(freq[ch-'a'] == 1){ // jab freq 1 ho jaye to index store kar do last char ka
                   freq[ch-'a'] = si ; // this denotes ki ye wale char ka last freq si par stored hai
               }
               si++ ;
           }
           else{ // means move right to left
               char ch = S.charAt(ei) ;
               if(freq[ch-'a'] > 1){ // means current char is first duplicate and it has other copies ahead
                   freq[ch-'a'] -- ; // so remove it
                   direc = 0 ;// and change the  direction
               }
               else if(freq[ch-'a'] == 1){ // jab freq 1 ho jaye to index store kar do last char ka
                   freq[ch-'a'] = ei ;// this denotes ki ye wale char ka last freq ei par stored hai
               }
               ei-- ;
           }
       }
       
       for(int i = 0 ; i < S.length() ; i++){
           if(freq[S.charAt(i) -'a'] == i){ // check karo kya curr char par jo humne last freq ka index store kia tha equals to i
               sb.append(S.charAt(i)) ; // means ye curr char sabse last wala frequency wala char h
           }
       }
       
       // agar direc 1 hai matlab humara string reversed ho gya tha isliyt return reversed sb
       if(direc == 1) return sb.reverse().toString() ;
       
       return sb.toString() ;
    }
}
