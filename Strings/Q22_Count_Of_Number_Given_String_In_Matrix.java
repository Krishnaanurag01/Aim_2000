package Strings;

public class Q22_Count_Of_Number_Given_String_In_Matrix {
    public static void main(String[] args) {
        String needle = "MAGIC";
    String input[] = { "BBABBM", "CBMBBA",
                       "IBABBG", "GOZBBI",
                       "ABBBBC", "MCIGAM" };
        System.out.println(getNumberOfPresence(needle , input));
    }

    public static int getNumberOfPresence(String str , String[] strArray) {
        
        int strSize = str.length();

        int ans = 0;

        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray.length; j++) {
               ans+= searchCHar(i,j,str,strArray,strSize,0);
            }
        }
        return ans ; 
    }

    public static int searchCHar(int i , int j , String s ,String[] sArr , int size , int index ) {
        int found = 0 ;
        if(i >= 0 && j >= 0 && i< sArr.length && j < sArr.length && s.charAt(index)==sArr[i].charAt(j)){
            char temp = sArr[i].charAt(j);
            sArr[i] = sArr[i].substring(0,j) + "0" + sArr[i].substring(j+1);
            index++;

            if(index ==  size){
                found = 1;
            }
            else{
                found += searchCHar(i, j + 1 , s , sArr , size , index);
                found += searchCHar(i, j -1 , s , sArr , size , index);
                found += searchCHar(i + 1, j , s , sArr , size , index);
                found += searchCHar(i - 1, j , s , sArr , size , index);



            }

            sArr[i] = sArr[i].substring(0,j) + temp + sArr[i].substring(j+1);

        }
        return found;
    }
}
