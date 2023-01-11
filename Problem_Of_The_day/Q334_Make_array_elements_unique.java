package Problem_Of_The_day;
import java.util.*;

public class Q334_Make_array_elements_unique {

       
    /*
    So , from the given problem statement we understand to make the array distinct .The operation we perform is to increment any element by one and we can apply operation as many times.
Our objective is to make the array distinct by applying minimum operations..

One approach is use hashmap , see the occurances of each element in map , if >1 increment it and add it to the end . But this approach can be seen from other comments.

The count variable keeps the count of the no of operations .

Our  approach is to maintain a variable which tells us the max_val upto which the elements  present in the  array are distinct.So that in case if our curr element's value is less than the max_val ,then we have to make it max_val+1 to maintain the distictness of the array .and  after that also increment the max_value.
Update the value of the count variable to the difference bw the max_val and curr_val , because we have to increment the curr_val that much times to make it 1+max_val.

In case curr_val is greater than the max_value .It means that the now we have to update the max_val to cur_value .

So we used Sorting to get curr_val which can always be valid for the incoming indexes .

Below example makes it clear :-

8
4 5 3 3 1 3 7 6

sort it :-
1 3 3 3 4 5 6 7

max_val=0 , count=0;


iterating the array
i=0;

1. max_val<arr[0] 
max_val=arr[0]=1;

i=1;

2. max_val<arr[1]
 max_val=arr[1]=3;

3. max_val==arr[2]
max_val=3+1=4;
count+=4-3=1 ,count=1;

3. max_val>arr[3]
max_val=4+1=5;
count+=5-3=2 ,count=3;

3. max_val>arr[4]
max_val=5+1=6;
count+=6-4=2 , count=5;
-----
------
Similarly 
final value of count would be 11.*/
public long minIncrements(int[] arr, int N) {
    long ans = 0 ;
    int max = 0 ;
    Arrays.sort(arr) ;
    
    for(int i = 0 ; i < N ; i++){
        if(max < arr[i]){ // if max is lesser thena assign current val as max. it means current val is not occured before
            max = arr[i] ;
        }
        else{ // when current val is equals or lesser than max.
        // if it is equal then we need to increment current by 1 as some prev value take this value
        // if current is lesseer means this value is already used so we need to assign current val with max + 1 - current increaments.
            max++ ;
            ans += max - arr[i] ;
        }
    }
    
    return ans ;
 }
}
