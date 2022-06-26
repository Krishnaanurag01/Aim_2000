package Problem_Of_The_day;

public class Q64_Maximum_Points_You_Can_Obtain_from_Cards {

    public int maxScore(int[] cardPoints, int k) {
        
        // finding the total sum of cards.
        int sum = 0 ;
        for(int i : cardPoints) sum += i ;
        
        // this is the window size of continuos cards which are not part of our answer.
        int win = cardPoints.length - k ;
        
        // so find the min sum of continuos cards which are not part of our answer.
        int temp = 0;
        for(int i = 0 ; i < win ; i++){
            temp += cardPoints[i] ;
        }
        
        int min = temp ;
        for(int i = win, j = 0 ; i < cardPoints.length ; i++ , j++){
            temp += cardPoints[i] ;
            temp -= cardPoints[j] ;
            min = Math.min(min,temp) ;
        }
        
        // and simply subtract the min unselected sum of cards from total.
        return sum - min ;
    }
}
