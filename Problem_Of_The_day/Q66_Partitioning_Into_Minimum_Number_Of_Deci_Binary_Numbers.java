package Problem_Of_The_day;

public class Q66_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers {

    public int minPartitions(String n) {
        int max = 0 ;
        for(char ch : n.toCharArray()){
            max =  Math.max(max, (ch-'0')) ;
        }   
        return max;
    }
}
