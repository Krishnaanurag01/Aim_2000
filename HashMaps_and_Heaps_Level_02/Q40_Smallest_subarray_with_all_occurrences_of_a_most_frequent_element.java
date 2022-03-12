package HashMaps_and_Heaps_Level_02;
import java.util.*;

public class Q40_Smallest_subarray_with_all_occurrences_of_a_most_frequent_element {


    ArrayList<Integer> smallestSubsegment(int a[], int n)
    {

        HashMap<Integer,Integer> fmap = new HashMap<>() ; // frequency map
        HashMap<Integer,Integer> simap = new HashMap<>() ; // starting index map
       
       int mlsf = 0 ; // max length so far.
       int si = 0 ; // starting index
       int ei = 0 ; // ending index
       int maxFreq = 0 ; // max frequency so far
       
       for(int i = 0 ; i < n ; i++){
           int num = a[i] ;
           
           if(simap.containsKey(num) == false){ // if starting index of current num is not stored(means current num did not cam before) then store with current index.
               simap.put(num,i) ;
           }
           
           // also increasing the freq of current num
           fmap.put(num,fmap.getOrDefault(num,0)+1) ;
           int freq = fmap.get(num) ;
           
           if(freq > maxFreq){ // if the freq of current num is greater then calculate the subarray and update the si and ei and maxFreq
               mlsf = i - simap.get(num) + 1 ; // updating the length
               si = simap.get(num) ;
               ei =  i ;
               maxFreq = freq ; 
           }
           else if(freq == maxFreq){ // when the freq is same then check for thier sub array length and choose the one with smaller subarray.
               int len = i - simap.get(num) + 1 ;

               if(mlsf > len ){ // if current num form smaller sub array then update the answer with smaller one.
                  mlsf= len ;
                  si = simap.get(num) ;
                  ei =  i ;
               }
           }
           
       }
       
       ArrayList<Integer> list = new ArrayList<>() ;
       
       for(int k = si ; k <=ei ; k++)
       list.add(a[k]) ;
        
        return list;
    }
  
    
}
