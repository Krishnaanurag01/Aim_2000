package Problem_Of_The_day;

public class Q213_Reformat_Date {

    public String reformatDate(String date) {
        String[] dates = date.split(" ") ;
        String day = dates[0] ;
        String month = dates[1] ;
        String year = dates[2] ;
        
        return year +"-"+getMonth(month)+"-"+(day.length() == 3 ? "0"+day.substring(0,1) : day.substring(0,2) ) ;
    }
    
    String getMonth(String s){
        
        switch(s){
            case "Jan" : return "01" ;
            case "Feb" : return "02" ;
            case "Mar" : return "03" ;
            case "Apr" : return "04" ;
            case "May" : return "05" ;
            case "Jun" : return "06" ;
            case "Jul" : return "07" ;
            case "Aug" : return "08" ;
            case "Sep" : return "09" ;
            case "Oct" : return "10" ;
            case "Nov" : return "11" ;
            case "Dec" : return "12" ;
            default : return "0" ;
        }
    }
}
