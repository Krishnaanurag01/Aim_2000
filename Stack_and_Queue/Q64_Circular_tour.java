package Stack_and_Queue ;

/**
 * Q64_Circular_tour
 */
public class Q64_Circular_tour {

    int tour(int petrol[], int distance[])
    {
	
	int s = 0 ; // start pointer
	int balance = 0 ; // manage qunatity of petrol
	
	for(int i = 0 ; i < petrol.length ; i++){
	    // fueling up
	    balance += petrol[i] ; // adding fuel
	    balance = balance - distance[i] ; // and subtracting distance of next petrol pump
	    
	    if(balance < 0 ){ // if balanae hits negative then it means we can't go to next station.
	        s = i+1 ;
	        balance = 0 ;
	    }
	}
	
	
    /// just In case if s becomes any intermediate point to start not 0 then we also have to check the distance from 0 to s.
	for(int i = 0 ; i < s ; i++){
	    
	    balance += petrol[i] ; 
	    balance = balance - distance[i] ;
	    
	    if(balance < 0 ){ // here we won't update as we already did this in  above method so if balance becomes negative then we can't travel circularly so return -1;
	       return -1 ;
	    }
	    
	}

	    return s ;
    }


    // nethod 02 : // much faster than above.

    int tour2(int petrol[], int distance[])
    {
	// Your code here	

    int start = 0 ;
    int extra = 0 ; // this will carry extra petrol.
    int require = 0 ; // this is the required petrol.

    for (int i = 0; i < distance.length; i++) {
        
        extra += petrol[i] - distance[i] ;
        
        if (extra < 0) { // if it becomes negative then reset
            require += extra ; // now this is the require petrol from 0 to i station
            start = i + 1; /// new start  pointer.
            extra = 0 ;
        }
    }

    if (require + extra >= 0) { // after trvaersing whole arr this is the require petrol and if it is smaller than extra petrol then we are cool else return -1 (we can't traverse whole arr circularly.)
        return start ;
    }
    else{
        return -1 ;
    }
    }
}