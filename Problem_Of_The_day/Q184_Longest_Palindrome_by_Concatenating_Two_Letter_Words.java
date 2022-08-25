package Problem_Of_The_day;
import java.util.*;

public class Q184_Longest_Palindrome_by_Concatenating_Two_Letter_Words {

    public int longestPalindrome(String[] words) {
        
        int size = 0 ;
        int odd = 0 ; // this denotes that wheather we have used any word whose freq is odd. 
        
        // step1 : storing the word with their freq
        HashMap<String,Integer> map = new HashMap<>() ;
        for(String word : words){
            map.put(word, map.getOrDefault(word,0)+1) ;
        }
        
       
        for(String key : words){
            
            int freq1 = map.get(key) ;
            if(key.charAt(0) == key.charAt(1)){ // agar current word palindrome hai to alag se process kro kyuki eska reverse bhi same word hoga to if condition k bahar ka code galat answer dega.
                if(freq1 == 0) continue ; // agar freq 0 hai to skip
                
                if(freq1 % 2 != 0 && odd == 0){ // agar word ki freq odd hai aur abhi tak koi word humne nhi lia jiski freqq odd ho to esko lelo.
                    size += (key.length() * freq1) ;
                    odd++ ; // aur ye denote karega ki odd word humne le lia
                }
                else if(freq1 % 2 != 0){ // agar freq odd hai lekin humne phle se koi odd freeq le rhakha toh 
                    freq1 -= 1 ; // even freq me es word ko lo
                    size += (key.length() * freq1) ;
                }
                else{ // otherwise evem freq hai to pure lello
                    size += (key.length() * freq1) ;
                }
                
                map.put(key,0) ; // this makes us not use same word twice.
                continue ;
            }
            
            String reverse = new StringBuilder(key).reverse().toString() ;
            int freq2 = map.getOrDefault(reverse,0) ;
            
            int count = Math.min(freq1,freq2) ; // min freq between key and it's reverse
            if(count > 0 ){ // agar 0 se jyda hai matlab 1 ya ussey jyda pair ban rhe.
                size += (2*(key.length() * count)); // toh utne pair ka length calculate kar lo 
            }
            
            map.put(key,0) ; // aur last me dono key ko 0 bana do.
            map.put(reverse,0) ;
        }
        
        
        return size ;
    }
}
