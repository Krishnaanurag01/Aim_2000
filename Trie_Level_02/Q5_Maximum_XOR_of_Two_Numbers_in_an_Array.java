package Trie_Level_02;

public class Q5_Maximum_XOR_of_Two_Numbers_in_an_Array {

    public int findMaximumXOR(int[] nums) {
        
        Trie t = new Trie() ;
        
        for(int val : nums){ // adding every value in trie(saving in the binary form)
            t.insert(val) ;
        }
        
        int max = 0 ;
        
        for(int val : nums){
            
            int find = Integer.MAX_VALUE ^ val ; // binary form of Integer max is  : 1111....31 times. so doing "XOR" with it means finding the bit in val where same bit present so at place of same bit it will give 0 and on different 1 allocated..\

         // now cheking if the bit we discovered from above line is available or not in trie, if it is not available then the trie find operation will do some modification in it and return.
            int res = t.find(find) ;
            max = Math.max(max, res ^ val) ;// updating max
        }
        
        return max ;
    }
    
    class Trie{
        
        class Node{
            Node left,right ;
        }
        
        Node root ;
        Trie(){
            root = new Node() ;
        } 
        
        // Insert Operaton.
        
        void insert(int val){
            
            Node curr = root ;
            int bitIdx = 30 ; // As Integer can hold 31 bits(32th bit is sign bit so not considering it.) from 0 - 30.
            
            while(bitIdx >= 0){
                int mask = 1 << bitIdx ; // helps in checking whether the bitIdx or val is 1 or 0.
                int bit = ( val & mask ) > 0 ? 1 : 0 ;
                
                if(bit == 0 ){ // when 0 store on left pointer else on right pointer for 1
                    
                    if(curr.left == null){ // if not present then create it else move to left
                        curr.left = new Node() ;
                    }
                    curr = curr.left ;
                }
                else{
                    
                    if(curr.right == null){ /// if not present then create else move to right
                        curr.right = new Node() ;
                    }
                    curr = curr.right ;   
                }
                
                bitIdx-- ;
            }
        } 
        
        // search operation. 
        // it will return given value if that value is present in trie else modify the given value then return.
        
        int find(int val){
            
            Node curr = root ;
            int bitIdx = 30 ; // As Integer can hold 31 bits(32th bit is sign bit) from 0 - 30.
            
            while(bitIdx >= 0){
                int mask = 1 << bitIdx ;
                int bit = ( val & mask ) > 0 ? 1 : 0 ;
                
                if(bit == 0 ){ // when 0 look in left pointer else on right pointer for 1
                    
                    if(curr.left == null){ // when left not present then give right value. 
                        curr = curr.right ;
                        // also modify in the given value. this will change the current bit to 1.(denotes that 0 is not present so changing 0 to 1)
                        val = val ^ mask ;
                    }
                    else{
                       curr = curr.left ;
                    }
                }
                else{
                    
                     if(curr.right == null){ // when left not present then give right value. 
                        curr = curr.left ;
                        // also modify in the given value. will change current bit to 0 (denotes that 1 is not present so changing 1 to 0)
                        val = val ^ mask ;
                    }
                    else{
                       curr = curr.right ;
                    }
                }
                
                bitIdx-- ;
            }
            
            return val ;
        }
        
    }
    
}
