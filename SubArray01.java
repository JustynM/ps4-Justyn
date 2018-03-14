
/**
 * Write a description of class SubArray01 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SubArray01
{
    public int main(int[] A){
        int countSub = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i]==0){
                for(int j = i; j < A.length; j++){
                    if(A[j]==1){
                        countSub++;
                    }
                }
            }
        }
        return countSub;
    }

    public int RecursiveLinear(int[] A){
        int countSub = 0;
        if (A.length == 0){
            return 0;
        }
        else if(A[0]!=0){
            int[] B = new int[A.length-1];
            for(int i = 1; i < A.length; i++){
                B[i-1] = A[i];
            }
            return RecursiveLinear(B);
        }
        else{
            for(int i = 0; i < A.length; i++){
                if(A[i] == 1){
                    countSub++;
                }
            }
            int[] B = new int[A.length-1];
            for(int i = 1; i < A.length; i++){
                B[i-1] = A[i];
            }
            return RecursiveLinear(B) + countSub;
        }
    }

    public int MaxProfit(int[] A, int sday, int eday){
        int maxValue = 0;
        if(sday == eday){
            return A[sday];
        }
        else 
        {
            int[] values = new int[A.length];
            for (int i = sday; i <= eday; i++){
                if(i==sday){
                    values[i] = A[i];
                }
                else{
                    values[i] = A[i] + values[i-1];
                }
                if (values[i] > maxValue){
                    maxValue = values[i];
                }
            }
            if (MaxProfit(A,sday + 1, eday) < maxValue){
                return maxValue;
            }
            else{
                return MaxProfit(A,sday + 1, eday);
            }
        }
    }

    public int MaxHalf(int[] A, int sday, int eday){
        int[] B = new int[A.length/2];
        int[] C = new int[A.length/2];
        int j = 0;
        int max = 0;
        for(int i = 0; i < Math.floor(A.length/2); i++){
            if (i < A.length/2){
                B[i] = A[i];
            }
            else {
                C[j] = A[i];
            }
        }
        
        if(sday == eday){
            return A[sday];
        }
        else {
            max = MaxProfit(A,0,A.length - 1);
            if (max < MaxProfit(B,0,B.length - 1)){
                max = MaxProfit(B,0,B.length - 1);
            }
            if (max < MaxProfit(C,0,C.length - 1)){
                max = MaxProfit(C,0,C.length - 1);
            }
            return max;
        }

    }
}
