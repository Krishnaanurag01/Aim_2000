package Stack_and_Queue ;
import java.util.*;

/**
 * Q23_Exclusive_Time_of_Functions
 */
public class Q23_Exclusive_Time_of_Functions {

    public static void main(String[] args) {
        
    }

    static class Pair {

        int id ; // id
        int st ; // starting or ending time.
        int ci ; // child interval
        
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        

        int[] time = new int[n] ; // it will contain the final time answer.

        Stack<Pair> stack = new Stack<>() ; // made an pair stack

        for (int i = 0; i < logs.size() ; i++) {
            
            String p[] = logs.get(i).split(":") ; // spliting the log

            if(p[1].equals("start")){ // if log is start then simply make a pair and push
                int id = Integer.parseInt( p[0] ) ; // this will be id
                int st = Integer.parseInt( p[2] ) ; // this is starting time
                int ct = 0 ; // this child interval by default it will be 0

                Pair pair = new Pair() ;
                pair.id = id ;
                pair.st = st ;
                pair.ci = ct ;

                stack.push(pair) ; // pushing to stack
            }
            else{

                Pair popped = stack.pop() ; // removing previous pair

                int interval = Integer.parseInt(p[2]) - popped.st + 1 ; // getting interval length ( j - i + 1)
                int ftime = interval - popped.ci ; // finding time by subtracting child interval if any exist for popped element
                time[popped.id] += ftime ; // now adding time in  popped element with its id as index. 

                if(stack.size() > 0 ) { // 
                    // and storing the its interval (as child interval ) for its parent.
                    stack.peek().ci += interval ; 
                }


            }
        }



        return time ;
    }
}
