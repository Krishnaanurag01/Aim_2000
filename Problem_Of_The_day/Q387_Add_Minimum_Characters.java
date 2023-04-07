package Problem_Of_The_day;

public class Q387_Add_Minimum_Characters {

    public static int addMinChar(String str){
		int left = 0 ;
		int right = str.length() - 1; 
		int count = 0 ;
		
		while(left <= right){
		    if(str.charAt(left) == str.charAt(right)){ // if both boundry char same then hop to next
		        left++ ;
		        right-- ;
		    }
		    else{
		        count++; // increase count of new char
		        // and reset the pointers
		        left = 0 ; // this will start from 0
		        right = str.length() - 1 - count ; // and it starts from end - count of new char
		    }
		}
		
		return count;
	}
}
