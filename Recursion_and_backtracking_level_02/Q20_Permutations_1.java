package Recursion_and_backtracking_level_02;
import java.io.*;
import java.util.*;

public class Q20_Permutations_1 {

  // approch 1 : 


  List<List<Integer>> ans ;
  public List<List<Integer>> permute(int[] nums) {
      ans = new ArrayList<>() ;
      boolean[] taken = new boolean[nums.length] ;  // denotes whether the ith index is taken or not.
      helper(nums,new ArrayList<>(),taken);
      return ans ;
  }
  
  void helper(int[] arr, List<Integer> list, boolean[] taken) {
      
      if(list.size() == arr.length ){ // if list has all the element in it then add this to answer.
          ans.add(new ArrayList<>(list));
          return ;
      }
      
      // we will try all element which are not used or taken.
      for(int i = 0; i < arr.length ; i++){
          if(taken[i] == false){ // if current element is not taken previously then only we can add this to ans.
              taken[i] = true ;
              list.add(arr[i]) ;
              helper(arr,list,taken) ;
              list.remove(list.size() - 1) ;
              taken[i] = false ;
          }
      }
      
  }


  // approch 2 : better and optimal.

  // List<List<Integer>> ans ;
  public List<List<Integer>> permute_(int[] nums) {
      ans = new ArrayList<>() ;
     
      helper(0,nums); // here we will work on the same array and on the indexes.
      return ans ;
  }
  
  void helper(int idx,int[] arr) {
      
      if(idx == arr.length ){ 

         ArrayList<Integer> list = new ArrayList<>() ;  // storing the permutation in list and adding to ans.
          for(int val : arr) list.add(val) ;          
          ans.add(list) ;
          return ;
      }
      
      // we will try all element of the array at current idx index.
      // all the elements which are not used are on right side becuase we had swapped the element in previous iteration.
      for(int i = idx ; i < arr.length ; i++){
          swap(arr,idx,i) ; // swaping
          helper(idx+1,arr) ;
          swap(arr,i,idx) ;// backtracking
      }
  }
  
  void swap(int[] arr, int i, int j){
      int temp = arr[i] ;
      arr[i] = arr[j] ;
      arr[j] = temp ;
  }











  // pepcoding approch : 

    // ci -> current item
    // ti -> total item

    public static void permutations(int[] boxes, int ci, int ti){
    
        if(ci > ti){ // base case when current item exceeded
          for (int item : boxes) { 
            System.out.print(item);
          }
          System.out.println();
          return ;
        }
    
        for(int i = 0 ; i < boxes.length ; i++){
          if(boxes[i] == 0){ // if box is empty then store item and move forward
          boxes[i] = ci ; // storing current item
          permutations(boxes,ci+1,ti) ; // moving forward
          boxes[i] = 0 ; // backtracking
          }
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
        br.close();
      }
    
}
